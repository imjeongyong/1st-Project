package greenAcademiGolf;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tab_main implements ActionListener {

	GreenDAO dao = new GreenDAO();
	JPanel tab_main_p, main_p_state;
	JTextArea tab_main_ta2;
	JButton tab_main_bEnter;
	JTextField[] main_tfs_state;

	int current_state, box_no;
	String id, nickname, pwd, enter_time, state;

	Tab_main(String id, String nickname, String pwd) {
		this.id = id;
		this.nickname = nickname;
		this.pwd = pwd;

		dao.connDB();
		ArrayList<UserStateVO> list = dao.currentState(id);

		for (int i = 0; i < list.size(); i++) {
			UserStateVO data = (UserStateVO) list.get(i);
			current_state = data.getCurrent_state();
			box_no = data.getBox_no();
			enter_time = data.getEnter_time();
		}

		tab_main_p = new JPanel();
		tab_main_p.setBackground(Color.blue);
		tab_main_p.setLayout(null);

		main_p_state = new JPanel();
		main_p_state.setLayout(new GridLayout(4, 1, 20, 20));
		main_p_state.setBounds(20, 20, 640, 300);

		main_tfs_state = new JTextField[4];

		System.out.println("currenst_state : " + current_state);
		System.out.println("box_no : " + box_no);

		state = "";
		switch (current_state) {
		case 0:
			state = "사용중인 타석이 없습니다.";
			break;
		case 1:
			state = "현재 " + String.valueOf(box_no) + "번 타석 이용중입니다.";
			break;
		case 2:
			state = "현재 " + String.valueOf(box_no) + "번 타석 이용 대기중입니다.";
			break;
		}

		System.out.println(state);

		String[] stateText = { nickname + " 님", "드라이버 10m 증가", "평균 구질 드로우", state };
		for (int i = 0; i < main_tfs_state.length; i++) {
			main_tfs_state[i] = new JTextField();
			main_tfs_state[i].setText(stateText[i]);
			main_p_state.add(main_tfs_state[i]);
		}

		tab_main_bEnter = new JButton();
		tab_main_bEnter.setBounds(20, 340, 640, 80);
		tab_main_bEnter.setText("새로고침");
		tab_main_bEnter.addActionListener(this);

		tab_main_ta2 = new JTextArea();
		tab_main_ta2.setBounds(20, 440, 640, 300);
		tab_main_ta2.setText("Board System...");

		tab_main_p.add(main_p_state);
		tab_main_p.add(tab_main_bEnter);
		tab_main_p.add(tab_main_ta2);
	}

	public void actionPerformed(ActionEvent e) {
		new MainFrame(id, nickname, pwd);
	}
}