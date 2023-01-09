package greenAcademiGolf;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Tab_main implements ActionListener {

	JPanel tab_main_p;
	JTextArea tab_main_ta, tab_main_ta2;
	JButton tab_main_bEnter;

	Tab_main() {
		tab_main_p = new JPanel();
		tab_main_p.setBackground(Color.blue);
		tab_main_p.setLayout(null);

		tab_main_ta = new JTextArea();
		tab_main_ta.setBounds(20, 20, 640, 300);
		tab_main_ta.setText("My data briefing...");

		tab_main_bEnter = new JButton();
		tab_main_bEnter.setBounds(20, 340, 640, 80);
		tab_main_bEnter.setText("enter");
		tab_main_bEnter.addActionListener(this);
		
		tab_main_ta2 = new JTextArea();
		tab_main_ta2.setBounds(20, 440, 640, 300);
		tab_main_ta2.setText("Board System...");

		tab_main_p.add(tab_main_ta);
		tab_main_p.add(tab_main_bEnter);
		tab_main_p.add(tab_main_ta2);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("click");
	}
}