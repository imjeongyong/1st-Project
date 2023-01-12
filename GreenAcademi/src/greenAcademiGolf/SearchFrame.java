package greenAcademiGolf;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFrame extends FirstFrame {

	JFrame sf_f_find;
	JPanel sf_p_btPanel, sf_p_panel;
	JPanel[] sf_p_cards;
	JButton[] sf_f_bts1, sf_f_bts2, sf_f_bts3, sf_cards_bts;
	JButton b_notice;
	JLabel[] sf_label_cards;
	JLabel l_notice;
	JTextField[] sf_tf_cards;
	JDialog notice;

	SearchFrame() {
		sf_f_find = new JFrame("아이디 / 비밀번호 찾기");
		sf_f_find.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sf_f_find.setSize(590, 740);
		sf_f_find.setResizable(false);
		sf_f_find.setLayout(null);

		sf_p_btPanel = new JPanel();
		sf_p_btPanel.setLayout(new FlowLayout());
		sf_p_btPanel.setBounds(0, 0, 590, 60);

		sf_f_bts1 = new JButton[3];
		String[] bts1Txt = { "아이디 찾기", "비밀번호 찾기", "돌아가기" };
		for (int i = 0; i < sf_f_bts1.length; i++) {
			sf_f_bts1[i] = new JButton();
			sf_f_bts1[i].setText(bts1Txt[i]);
			sf_f_bts1[i].setSize(150, 60);
			sf_f_bts1[i].setFont(bt_font);
			sf_f_bts1[i].addActionListener(this);

			sf_p_btPanel.add(sf_f_bts1[i]);
		}

		sf_p_panel = new JPanel();
		sf_p_panel.setLayout(cardLayout);
		sf_p_panel.setBounds(0, 60, 590, 680);
		sf_p_panel.setBackground(bgColor);

		sf_p_cards = new JPanel[2];
		String[] cardName = { "sf_card_ID", "sf_card_PWD" };
		for (int i = 0; i < sf_p_cards.length; i++) {
			sf_p_cards[i] = new JPanel();
			sf_p_cards[i].setLayout(null);
			sf_p_cards[i].setBounds(0, 60, 590, 680);

			sf_p_panel.add(sf_p_cards[i], cardName[i]);
		}

		sf_label_cards = new JLabel[4];
		String[] labelName = { "닉네임", "이메일 주소", "아이디", "이메일 주소" };
		for (int i = 0; i < sf_label_cards.length; i++) {
			sf_label_cards[i] = new JLabel();
			sf_label_cards[i].setText(labelName[i]);
			sf_label_cards[i].setSize(100, 60);
			sf_label_cards[i].setFont(bt_font);
			sf_label_cards[i].setHorizontalAlignment(JLabel.RIGHT);
		}

		sf_label_cards[0].setLocation(20, 20);
		sf_label_cards[1].setLocation(20, 120);
		sf_p_cards[0].add(sf_label_cards[0]);
		sf_p_cards[0].add(sf_label_cards[1]);

		sf_label_cards[2].setLocation(20, 20);
		sf_label_cards[3].setLocation(20, 120);
		sf_p_cards[1].add(sf_label_cards[2]);
		sf_p_cards[1].add(sf_label_cards[3]);

		sf_tf_cards = new JTextField[4];
		for (int i = 0; i < sf_tf_cards.length; i++) {
			sf_tf_cards[i] = new JTextField();
			sf_tf_cards[i].setSize(250, 60);
			sf_tf_cards[i].setFont(bt_font);
		}

		sf_tf_cards[0].setLocation(140, 20);
		sf_tf_cards[1].setLocation(140, 120);
		sf_p_cards[0].add(sf_tf_cards[0]);
		sf_p_cards[0].add(sf_tf_cards[1]);

		sf_tf_cards[2].setLocation(140, 20);
		sf_tf_cards[3].setLocation(140, 120);
		sf_p_cards[1].add(sf_tf_cards[2]);
		sf_p_cards[1].add(sf_tf_cards[3]);

		sf_cards_bts = new JButton[4];
		String[] btsName = { "확인", "취소", "확인", "취소" };
		for (int i = 0; i < sf_cards_bts.length; i++) {
			sf_cards_bts[i] = new JButton();
			sf_cards_bts[i].setText(btsName[i]);
			sf_cards_bts[i].addActionListener(this);
			sf_cards_bts[i].setSize(140, 60);
			sf_cards_bts[i].setFont(bt_font);
		}

		sf_cards_bts[0].setLocation(140, 500);
		sf_cards_bts[1].setLocation(320, 500);
		sf_p_cards[0].add(sf_cards_bts[0]);
		sf_p_cards[0].add(sf_cards_bts[1]);

		sf_cards_bts[2].setLocation(140, 500);
		sf_cards_bts[3].setLocation(320, 500);
		sf_p_cards[1].add(sf_cards_bts[2]);
		sf_p_cards[1].add(sf_cards_bts[3]);

		l_notice = new JLabel();
		l_notice.setBounds(20, 30, 250, 60);
		l_notice.setFont(bt_font);

		b_notice = new JButton();
		b_notice.setText("확인");
		b_notice.setBounds(150, 100, 70, 50);
		b_notice.setFont(bt_font);
		b_notice.addActionListener(this);

		notice = new JDialog(sf_f_find, false);
		notice.setLayout(null);
		notice.setBounds(300, 200, 300, 200);
		notice.add(b_notice);
		notice.add(l_notice);

		sf_f_find.add(sf_p_panel);
		sf_f_find.add(sf_p_btPanel);
		sf_f_find.setVisible(true);

		dao.connDB();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sf_f_bts1[0]) { // **ID 찾기 창 버튼**
			cardLayout.show(sf_p_panel, "sf_card_ID");
		}

		if (e.getSource() == sf_f_bts1[1]) { // **PWD 찾기 창 버튼**
			cardLayout.show(sf_p_panel, "sf_card_PWD");
		}

		if (e.getSource() == sf_f_bts1[2] || e.getSource() == sf_cards_bts[1] || e.getSource() == sf_cards_bts[3]) { // **돌아가기,
																														// 취소
																														// 버튼**
			sf_f_find.setVisible(false);
			new FirstFrame();
		}

		if (e.getSource() == sf_cards_bts[0]) { // **ID 찾기 버튼**
			String nickname = sf_tf_cards[0].getText();
			String email = sf_tf_cards[1].getText();

			if (nickname.length() == 0) {
				notice.setVisible(true);
				l_notice.setText("닉네임을 입력해주세요.");
			} else if (email.length() == 0) {
				notice.setVisible(true);
				l_notice.setText("이메일 주소를 입력해주세요.");
			} else if (email.contains("@") == false) {
				notice.setVisible(true);
				l_notice.setText("이메일 주소를 다시 입력해주세요.");
			} else {

				ArrayList<MemberVO> list = dao.searchID(nickname, email);
				String mem_id = "";
				String mem_email = "";

				for (int i = 0; i < list.size(); i++) {
					MemberVO data = (MemberVO) list.get(i);
					mem_id = data.getMem_id();
					mem_email = data.getMem_email();
				}

				if (email.equals(mem_email)) {
					notice.setVisible(true);
					l_notice.setText("아이디 : " + mem_id);
					for (int i = 0; i < sf_tf_cards.length; i++) {
						sf_tf_cards[i].setText("");
					}
				} else {
					notice.setVisible(true);
					l_notice.setText("다시 입력해주세요.");
				}
			}
		}

		if (e.getSource() == sf_cards_bts[2]) { // **PWD 찾기 버튼**
			String id = sf_tf_cards[2].getText();
			String email = sf_tf_cards[3].getText();

			if (id.length() == 0) {
				notice.setVisible(true);
				l_notice.setText("아이디를 입력해주세요.");
			} else if (email.length() == 0) {
				notice.setVisible(true);
				l_notice.setText("이메일 주소를 입력해주세요.");
			} else if (email.contains("@") == false) {
				notice.setVisible(true);
				l_notice.setText("이메일 주소를 다시 입력해주세요.");
			} else {

				ArrayList<MemberVO> list = dao.searchPwd(id, email);
				String mem_pwd = "";
				String mem_email = "";

				for (int i = 0; i < list.size(); i++) {
					MemberVO data = (MemberVO) list.get(i);
					mem_pwd = data.getMem_id();
					mem_email = data.getMem_email();
				}

				if (email.equals(mem_email)) {
					notice.setVisible(true);
					l_notice.setText("비밀번호 : " + mem_pwd);
					for (int i = 0; i < sf_tf_cards.length; i++) {
						sf_tf_cards[i].setText("");
					}
				} else {
					notice.setVisible(true);
					l_notice.setText("다시 입력해주세요.");
				}
			}
		}

		if (e.getSource() == b_notice) {
			notice.dispose();
		}
	}
}