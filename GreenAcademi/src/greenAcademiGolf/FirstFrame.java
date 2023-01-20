package greenAcademiGolf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FirstFrame implements ActionListener {

	GreenDAO dao = new GreenDAO();
	JFrame ff_f_first;
	JPanel ff_p_background1, ff_p_background2;
	JPanel[] cards;
	CardLayout cardLayout;
	Color bgColor;
	JButton[] login_bts, login_bts2;
	Font bt_font;
	JLabel[] login_labels;
	JTextField login_tfID;
	JPasswordField login_pfPWD;
	JDialog notice;
	JButton b_notice;
	JLabel l_notice;

	FirstFrame() {

		// 첫 화면 프레임

		bgColor = new Color(0, 102, 0); // ** 배경 색 **

		bt_font = new Font("맑은 고딕", Font.BOLD, 15);

		ff_f_first = new JFrame("그린아카데미"); // ** 프레임 1 **
		ff_f_first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ff_f_first.setSize(590, 740);
		ff_f_first.setResizable(false);
		ff_f_first.setLayout(null);

		ImageIcon golpu = new ImageIcon("golpu.png");

		ff_p_background1 = new JPanel(); // ** 메인 패널 **
		ff_p_background1.setBackground(Color.white);
		ff_p_background1.setBounds(0, 0, 590, 500);
		ff_p_background1.setLayout(null);

		JLabel l_golpu = new JLabel();
		l_golpu.setBounds(90, 30, 410, 440);
		l_golpu.setBackground(Color.white);
		l_golpu.setIcon(golpu);

		l_golpu.setOpaque(true);

		ff_p_background1.add(l_golpu, BorderLayout.CENTER);

		cardLayout = new CardLayout(); // ** 카드 패널 **

		ff_p_background2 = new JPanel();
		ff_p_background2.setLayout(cardLayout);
		ff_p_background2.setBounds(0, 500, 590, 240);
		ff_p_background2.setBackground(bgColor);

		cards = new JPanel[2]; // ** 카드 레이아웃 패널 **
		String[] card_name = { "first", "login" };
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new JPanel();
			cards[i].setBackground(Color.white);
			cards[i].setLayout(null);
			cards[i].setBounds(0, 500, 590, 240);

			ff_p_background2.add(cards[i], card_name[i]);
		}

		login_bts = new JButton[3];
		String[] btName = { "로그인", "회원가입", "아이디/비밀번호 찾기" };

		for (int i = 0; i < login_bts.length; i++) {
			login_bts[i] = new JButton();
			login_bts[i].setFocusable(false);
			login_bts[i].setText(btName[i]);
			login_bts[i].setForeground(Color.white);
			login_bts[i].setBackground(bgColor);
			login_bts[i].setFont(bt_font);
			login_bts[i].addActionListener(this);

			cards[0].add(login_bts[i]);
		}

		login_bts[0].setBounds(200, 20, 190, 60); // 로그인
		login_bts[1].setBounds(70, 100, 190, 60); // 회원가입
		login_bts[2].setBounds(330, 100, 190, 60); // 아이디/비밀번호 찾기

		login_labels = new JLabel[2];
		String[] labelName = { "ID 입력", "비밀번호 입력" };
		for (int i = 0; i < login_labels.length; i++) {
			login_labels[i] = new JLabel();
			login_labels[i].setText(labelName[i]);
			login_labels[i].setHorizontalAlignment(JLabel.RIGHT);
			login_labels[i].setFont(bt_font);
			login_labels[i].setBackground(Color.white);
			login_labels[i].setOpaque(true);

			cards[1].add(login_labels[i]);
		}

		login_labels[0].setBounds(40, 30, 100, 50);
		login_labels[1].setBounds(40, 100, 100, 50);

		login_tfID = new JTextField();
		login_tfID.setFont(bt_font);
		login_tfID.setBounds(160, 30, 200, 50);
		cards[1].add(login_tfID);

		login_pfPWD = new JPasswordField();
		login_pfPWD.setFont(bt_font);
		login_pfPWD.setBounds(160, 100, 200, 50);
		cards[1].add(login_pfPWD);

		login_bts2 = new JButton[2];
		String[] bts2Name = { "로그인하기", "돌아가기" };
		for (int i = 0; i < login_bts2.length; i++) {
			login_bts2[i] = new JButton();
			login_bts2[i].setText(bts2Name[i]);
			login_bts2[i].setFocusable(false);
			login_bts2[i].setFont(bt_font);
			login_bts2[i].setBackground(bgColor);
			login_bts2[i].setForeground(Color.white);
			login_bts2[i].addActionListener(this);

			cards[1].add(login_bts2[i]);
		}

		login_bts2[0].setBounds(380, 30, 150, 50);
		login_bts2[1].setBounds(380, 100, 150, 50);

		ff_f_first.add(ff_p_background1);
		ff_f_first.add(ff_p_background2);

		cardLayout.show(ff_p_background2, "first");

		l_notice = new JLabel();
		l_notice.setBounds(20, 30, 250, 60);
		l_notice.setFont(bt_font);

		b_notice = new JButton();
		b_notice.setText("확인");
		b_notice.setBounds(150, 100, 70, 50);
		b_notice.setFont(bt_font);
		b_notice.addActionListener(this);

		notice = new JDialog(ff_f_first, false);
		notice.setLayout(null);
		notice.setBounds(300, 200, 300, 200);
		notice.add(b_notice);
		notice.add(l_notice);

		dao.connDB();
	}

	public void startFrame() {
		ff_f_first.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login_bts[0]) { // **카드레이아웃 로그인 화면 버튼**
			cardLayout.show(ff_p_background2, "login");
		}
		if (e.getSource() == login_bts[1]) { // **회원가입 화면 버튼**
			new JoinFrame();
			ff_f_first.setVisible(false);
		}
		if (e.getSource() == login_bts[2]) { // **아이디/비밀번호 찾기 화면 버튼**
			new SearchFrame();
			ff_f_first.setVisible(false);
		}

		if (e.getSource() == login_bts2[1]) { // **카드레이아웃 첫 화면 버튼**
			cardLayout.show(ff_p_background2, "first");
		}

		if (e.getSource() == login_bts2[0]) { // **로그인 하기 버튼**
			String id = login_tfID.getText();
			String nickname = "";
			String pwd = String.valueOf(login_pfPWD.getPassword());

			ArrayList<MemberVO> list = dao.tryLogin(id, pwd);
			String password = "";

			for (int i = 0; i < list.size(); i++) {
				MemberVO data = (MemberVO) list.get(i);
				nickname = data.getMem_nickname();
				password = data.getMem_pwd();
			}
			if (id.length() == 0) {
				notice.setVisible(true);
				l_notice.setText("아이디를 입력하세요.");
			} else if (pwd.length() == 0) {
				notice.setVisible(true);
				l_notice.setText("비밀번호를 입력하세요.");
			} else if (pwd.equals(password)) {
				login_tfID.setText("");
				login_pfPWD.setText("");
				new MainFrame(id).startFrame();
			} else {
				notice.setVisible(true);
				l_notice.setText("로그인 실패");
				login_tfID.setText("");
				login_pfPWD.setText("");
			}
		}

		if (e.getSource() == b_notice) {
			notice.dispose();
		}
	}
}