package greenAcademiGolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tab_enter implements ActionListener, Runnable {
	GreenDAO dao = new GreenDAO();
	JPanel p_box;
	JLabel l_boxNo, l_state, l_currenttime;
	JButton box_1_b_enter;
	JLabel label;

	int box_no, current_state;
	String mem_id, mem_nickname, enter_time;

	String user_nickname, start_time, wait_mem;

	boolean occupy;

	Tab_enter(int box_no, String mem_id, String mem_nickname) {
		this.box_no = box_no;
		this.mem_id = mem_id;
		this.mem_nickname = mem_nickname;

		dao.connDB();
		ArrayList<UserStateVO> list1 = dao.currentState(mem_id);

		for (int i = 0; i < list1.size(); i++) {
			UserStateVO data = (UserStateVO) list1.get(i);
			current_state = data.getCurrent_state();
			enter_time = data.getEnter_time();
		}

		ArrayList<BoxStateVO> list2 = dao.boxState(box_no);

		for (int i = 0; i < list2.size(); i++) {
			BoxStateVO data = (BoxStateVO) list2.get(i);
			user_nickname = data.getMem_nickname();
			start_time = data.getStart_time();
			wait_mem = data.getWait_mem();
		}

		System.out.println("box_no : " + box_no);
		System.out.println("user_nickname : " + user_nickname);
		System.out.println("start_time : " + start_time);
		System.out.println("mem_nickname : " + mem_nickname);

		if (!(user_nickname.equals("0"))) {
			occupy = false;
		}
		System.out.println("occupy : " + occupy);

		p_box = new JPanel();
		p_box.setLayout(null);

		l_boxNo = new JLabel();
		l_boxNo.setText("No." + box_no);
		l_boxNo.setFont(new Font("Arial", Font.PLAIN, 50));
		l_boxNo.setBounds(90, 60, 150, 100);

		box_1_b_enter = new JButton();
		box_1_b_enter.setBounds(210, 170, 100, 50);
		box_1_b_enter.setFocusable(false);

		l_state = new JLabel();
		l_state.setBounds(240, 10, 100, 50);
		l_state.setForeground(Color.blue);

		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formatedNow = now.format(formatter);

		l_currenttime = new JLabel();
		l_currenttime.setBounds(10, 10, 100, 50);
		l_currenttime.setText(formatedNow);

		label = new JLabel();
		label.setForeground(Color.blue);
		label.setBounds(10, 180, 150, 50);

		box_1_b_enter.addActionListener(this);

		if (occupy = true) {
			box_1_b_enter.setText("입장하기");
			l_state.setText("비어있음");
			label.setText("사용가능한 타석입니다..");
		} else {
			box_1_b_enter.setText("줄서기");
			l_state.setText("사용중");
			label.setText("");
		}

		p_box.add(label);
		p_box.add(l_currenttime);
		p_box.add(l_state);
		p_box.add(l_boxNo);
		p_box.add(box_1_b_enter);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("입장하기")) {

			dao.enterance1(mem_id, mem_nickname, box_no);
			dao.enterance2(mem_nickname, box_no);

//			l_state.setText("사용중");
//			box_1_b_enter.setText("줄서기");
			Thread t = new Thread(this);
			t.start();
		}
		if (e.getActionCommand().equals("줄서기")) {
			System.out.println("줄서기");
		}
	}

	@Override
	public void run() {
		for (int i = 10; i >= 0; i--) {
			try {
				label.setText(i + "분 남았습니다...");
				Thread.sleep(1000);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		label.setText("사용가능한 타석입니다..");
		box_1_b_enter.setText("입장하기");
		l_state.setText("비어있음");
		dao.exit(mem_id, mem_nickname, box_no);
	}
}