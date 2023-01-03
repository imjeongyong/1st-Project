package jRadioButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ActionListener {

	JRadioButton pizzaButton, hambergerButton, hotdogButton;
	ImageIcon pizzaIcon, hambergerIcon, hotdogIcon;

	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		pizzaIcon = new ImageIcon("pizza.png");
		hambergerIcon = new ImageIcon("hamberger.png");
		hotdogIcon = new ImageIcon("hotdog.png");

		pizzaButton = new JRadioButton("pizza");
		hambergerButton = new JRadioButton("hamberger");
		hotdogButton = new JRadioButton("hotdog");

		pizzaButton.addActionListener(this);
		hambergerButton.addActionListener(this);
		hotdogButton.addActionListener(this);

		pizzaButton.setIcon(pizzaIcon);
		hambergerButton.setIcon(hambergerIcon);
		hotdogButton.setIcon(hotdogIcon);

		ButtonGroup group = new ButtonGroup();
		group.add(pizzaButton);
		group.add(hambergerButton);
		group.add(hotdogButton);

		this.add(pizzaButton);
		this.add(hambergerButton);
		this.add(hotdogButton);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pizzaButton) {
			System.out.println("You ordered a pizza!");
		} else if (e.getSource() == hambergerButton) {
			System.out.println("You ordered a hamberger!");
		} else if (e.getSource() == hotdogButton) {
			System.out.println("You ordered a hotdog!");
		}
	}
}