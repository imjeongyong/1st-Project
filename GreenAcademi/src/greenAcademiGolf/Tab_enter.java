package greenAcademiGolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tab_enter implements ActionListener, Runnable {
	JPanel p_box;
	JLabel l_boxNo, l_state, l_currenttime;
	JButton box_1_b_enter;
	JLabel label;

	Tab_enter(int box_No) {
		p_box = new JPanel();
		p_box.setLayout(null);
		p_box.setBackground(Color.lightGray);

		l_boxNo = new JLabel();
		l_boxNo.setText("No." + box_No);
		l_boxNo.setFont(new Font("Arial", Font.PLAIN, 50));
		l_boxNo.setBounds(90, 60, 150, 100);
		l_boxNo.setBackground(Color.LIGHT_GRAY);
		l_boxNo.setOpaque(true);

		box_1_b_enter = new JButton();
		box_1_b_enter.setBounds(240, 180, 80, 50);
		box_1_b_enter.setText("enter");

		l_state = new JLabel();
		l_state.setBounds(240, 10, 100, 50);
		l_state.setText("Vacant");

		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분");
		String formatedNow = now.format(formatter);

		l_currenttime = new JLabel();
		l_currenttime.setBounds(10, 10, 100, 50);
		l_currenttime.setText(formatedNow);

		label = new JLabel();
		label.setText("available..");
		label.setBounds(10, 180, 100, 50);

		box_1_b_enter.addActionListener(this);

		p_box.add(label);
		p_box.add(l_currenttime);
		p_box.add(l_state);
		p_box.add(l_boxNo);
		p_box.add(box_1_b_enter);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("enter")) {
			l_state.setText("Occupied");
			box_1_b_enter.setText("Line up");
			Thread t = new Thread(this);
			t.start();
		}
		if (e.getActionCommand().equals("Line up")) {
			System.out.println("줄서기");
		}
	}

	@Override
	public void run() {
		for (int i = 10; i >= 0; i--) {
			try {
				label.setText(i + "sec left...");
				Thread.sleep(1000);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		label.setText("available..");
		box_1_b_enter.setText("enter");
		l_state.setText("Vacant");
	}
}