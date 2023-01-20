package greenAcademiGolf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SwingBox1 implements ActionListener, Runnable {
	JPanel p_SwingBox, p_sb_north, p_sb_center, p_sb_south;
	JLabel cen_l_No, north_l_state, north_l_time;
	JButton south_b_enter;
	JLabel south_l_boxInfo;
	Thread t;

	int box_no;
	String mem_id, mem_nickname;

	GreenDAO dao;

	SwingBox1(int box_no, String mem_id) {
		this.mem_id = mem_id;
		this.box_no = box_no;
	}

	public void startSwingBox() {
		makeUI();
		printCenter();
		addUI();
		printNorth();
		printEnterButton();
	}

	public void makeUI() {
		p_SwingBox = new JPanel();
		p_SwingBox.setLayout(new BorderLayout());
		p_SwingBox.setBackground(Color.LIGHT_GRAY);

		p_sb_north = new JPanel();
		p_sb_north.setLayout(new BorderLayout());
		p_sb_north.setBackground(Color.LIGHT_GRAY);

		p_sb_center = new JPanel();
		p_sb_center.setLayout(new BorderLayout());
		p_sb_center.setBackground(Color.LIGHT_GRAY);

		p_sb_south = new JPanel();
		p_sb_south.setLayout(new BorderLayout());
		p_sb_south.setBackground(Color.LIGHT_GRAY);

		cen_l_No = new JLabel();
		cen_l_No.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		cen_l_No.setForeground(new Color(0, 102, 0));
		cen_l_No.setVerticalAlignment(JLabel.CENTER);
		cen_l_No.setHorizontalAlignment(JLabel.CENTER);

		north_l_time = new JLabel();
		north_l_time.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		north_l_state = new JLabel();
		north_l_state.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		south_b_enter = new JButton();
		south_b_enter.setFocusable(false);
		south_b_enter.setBackground(new Color(0, 102, 0));
		south_b_enter.setForeground(Color.white);
		south_b_enter.addActionListener(this);

		south_l_boxInfo = new JLabel();

	}

	public void printCenter() {
		cen_l_No.setText(box_no + "번");
	}

	public void printNorth() {

		dao = new GreenDAO();
		dao.connDB();

		ArrayList<BoxStateVO> list = dao.boxState(box_no);
		String user_nickname = "";
		for (int i = 0; i < list.size(); i++) {
			BoxStateVO data = (BoxStateVO) list.get(i);
			user_nickname = data.getMem_nickname();
		}

		if (user_nickname.equals("0")) {
			north_l_state.setText("입장가능");
			north_l_state.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			north_l_state.setForeground(Color.BLUE);
		} else {
			north_l_state.setText("사용중");
			north_l_state.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			north_l_state.setForeground(Color.RED);
		}

		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formatedNow = now.format(formatter);

		north_l_time.setText(formatedNow);
		System.out.println("printNorth()->user_nickname : " + user_nickname);

	}

	public void printEnterButton() {

		dao = new GreenDAO();
		dao.connDB();

		ArrayList<BoxStateVO> list = dao.boxState(box_no);
		String user_nickname = "";
		for (int i = 0; i < list.size(); i++) {
			BoxStateVO data = (BoxStateVO) list.get(i);
			user_nickname = data.getMem_nickname();
		}

		if (user_nickname.equals("0")) {
			south_b_enter.setText("입장하기");
		} else {
			south_b_enter.setText("줄서기");
		}
	}

	public void addUI() {
		p_sb_center.add(cen_l_No);

		p_sb_south.add(south_b_enter, BorderLayout.EAST);

		p_sb_north.add(north_l_time, BorderLayout.WEST);
		p_sb_north.add(north_l_state, BorderLayout.EAST);

		p_SwingBox.add(p_sb_north, BorderLayout.NORTH);
		p_SwingBox.add(p_sb_center, BorderLayout.CENTER);
		p_SwingBox.add(p_sb_south, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		dao.connDB();

		ArrayList<UserStateVO> list = dao.currentState(mem_id);
		String mem_nickname = "";
		int current_state = 0;
		int use_box = 0;
		for (int i = 0; i < list.size(); i++) {
			UserStateVO data = (UserStateVO) list.get(i);
			mem_nickname = data.getMem_nickname();
			current_state = data.getCurrent_state();
			use_box = data.getBox_no();
		}

		if (e.getActionCommand().equals("입장하기")) {
			if (current_state == 0) {
				dao.enterance1(mem_id, mem_nickname, box_no); // user_state 레코드 수정, current_state(0->1), box_no,
																// start_time
																// 입력
				dao.enterance2(mem_nickname, box_no); // box_state 레코드 수정, 아이디, 시작시간 입력
				printNorth();
				printEnterButton();
				t = new Thread(this);
				t.start();

			} else if (current_state == 1) {
				JOptionPane.showMessageDialog(null, "현재 " + use_box + "번 방을 이용중입니다.", "", JOptionPane.PLAIN_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("줄서기")) {
			System.out.println("Line up!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			if (current_state == 0) {
				JOptionPane.showMessageDialog(null, box_no + "번 방\n입장예약 하시겠습니까?", "", JOptionPane.PLAIN_MESSAGE);
			} else if (current_state == 2) {
				JOptionPane.showMessageDialog(null, box_no + "이미 대기중 입니다.", "", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	public void run() {
		GreenDAO dao = new GreenDAO();
		dao.connDB();

		for (int i = 10; i >= 0; i--) {
			try {
				south_l_boxInfo.setText(i + "분 남았습니다...");
				p_sb_south.add(south_l_boxInfo);
				Thread.sleep(1000);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		dao.exit1(mem_id, mem_nickname, box_no);
		dao.exit2(mem_nickname, box_no);
		south_l_boxInfo.setText("");
		printNorth();
		printEnterButton();
	}
}