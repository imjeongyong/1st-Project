package greenAcademiGolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Card_main implements ActionListener {

	JPanel card_main, cm_p_state, cm_p_board;
	JTextField[] cm_tfs;
	JButton cm_b_refresh;

	String id;

	GreenDAO dao = new GreenDAO();

	Card_main(String id) {
		this.id = id;

		card_main = new JPanel();
		card_main.setBackground(Color.white);
		card_main.setLayout(null);

		cm_p_state = new JPanel();
		cm_p_state.setLayout(new GridLayout(4, 0, 10, 20));
		cm_p_state.setBounds(30, 30, 510, 250);
		cm_p_state.setBackground(Color.white);

		cm_tfs = new JTextField[4];
		for (int i = 0; i < cm_tfs.length; i++) {
			cm_tfs[i] = new JTextField();
			cm_tfs[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			cm_tfs[i].setEditable(false);
			cm_tfs[i].setBackground(Color.white);
			cm_p_state.add(cm_tfs[i]);
		}

		cm_b_refresh = new JButton();
		cm_b_refresh.setBounds(130, 310, 310, 60);
		cm_b_refresh.setText("새로고침");
		cm_b_refresh.setBackground(new Color(0, 102, 0));
		cm_b_refresh.setForeground(Color.white);
		cm_b_refresh.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cm_b_refresh.setFocusable(false);
		cm_b_refresh.addActionListener(this);

		cm_p_board = new JPanel();
		cm_p_board.setBackground(Color.white);
		cm_p_board.setBounds(30, 400, 510, 210);

		card_main.add(cm_p_state);
		card_main.add(cm_b_refresh);
		card_main.add(cm_p_board);

		printState1();
		printState2();
		printState3();
	}

	void printState1() {
		dao.connDB();

		ArrayList<UserStateVO> list = dao.currentState(id);
		String mem_nickname = "";
		int current_state = 0;
		int box_no = 0;
		for (int i = 0; i < list.size(); i++) {
			UserStateVO data = (UserStateVO) list.get(i);
			mem_nickname = data.getMem_nickname();
			System.out.println("d:" + data.getMem_nickname());
			current_state = data.getCurrent_state();
			box_no = data.getBox_no();
		}

		String state1 = "";

		switch (current_state) {
		case 0:
			state1 = "현재 사용중인 타석이 없습니다.";
			break;
		case 1:
			state1 = "현재 " + box_no + "번 타석 이용중입니다.";
			break;
		case 2:
			state1 = box_no + " 번 타석 대기중입니다.";
			break;
		}

		cm_tfs[0].setText(mem_nickname + " 님");
		cm_tfs[3].setText(state1);
	}

	void printState2() {
		dao.connDB();

		ArrayList<SwingDataVO> list = dao.viewAll(id);
		String clubType = "";
		int distance = 0;

		SwingDataVO data = (SwingDataVO) list.get(0);
		clubType = data.getClub();
		distance = data.getCarry();

		String state2 = "";
		if (clubType.equals("")) {
			state2 = "최근 스윙이 없습니다.";
		} else {
			state2 = "최근 " + clubType + " 비거리 " + distance + "m,";
			cm_tfs[1].setText(state2);
		}
	}

	void printState3() {
		dao.connDB();
		String state3 = dao.printState3(id);
		if (state3.equals("")) {
			state3 = "현재 기록이 없습니다.";
		} else {
			cm_tfs[2].setText("평균 구질은 " + state3 + "입니다.");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cm_b_refresh) {
			printState1();
			printState2();
			printState3();
		}
	}
}