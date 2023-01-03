package jButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
	JButton button;
	JLabel label;

	MyFrame() {
		ImageIcon icon = new ImageIcon("icon.png");
		ImageIcon icon1 = new ImageIcon("skul.png");

		label = new JLabel();
		label.setIcon(icon1);
		label.setBounds(150, 250, 150, 150);
		label.setVisible(false);

		button = new JButton();
		button.setBounds(100, 100, 200, 100);
		button.addActionListener(this);
		button.setText("I'm a button!");
		button.setFocusable(false);
		button.setIcon(icon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sens", Font.BOLD, 25));
		button.setIconTextGap(-15);
		button.setForeground(Color.cyan);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createEtchedBorder());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.add(button);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			label.setVisible(true);
//			System.out.println("poo");
//			button.setEnabled(false);
		}
	}
}