package greenAcademiGolf;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FirstFrame implements ActionListener {

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

	FirstFrame() {

		// 첫 화면 프레임

		bgColor = new Color(0, 102, 0); // ** 배경 색 **

		bt_font = new Font("맑은 고딕", Font.BOLD, 15);

		ff_f_first = new JFrame("그린아카데미"); // ** 프레임 1 **
		ff_f_first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ff_f_first.setSize(590, 740);
		ff_f_first.setResizable(false);
		ff_f_first.setLayout(null);

		ff_p_background1 = new JPanel(); // ** 메인 패널 **
		ff_p_background1.setBounds(0, 0, 590, 500);

		cardLayout = new CardLayout(); // ** 카드 패널 **

		ff_p_background2 = new JPanel();
		ff_p_background2.setLayout(cardLayout);
		ff_p_background2.setBounds(0, 500, 590, 240);
		ff_p_background2.setBackground(bgColor);

		cards = new JPanel[2]; // ** 카드 레이아웃 패널 **
		String[] card_name = { "first", "login" };
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new JPanel();
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
			login_bts2[i].addActionListener(this);

			cards[1].add(login_bts2[i]);
		}

		login_bts2[0].setBounds(380, 30, 150, 50);
		login_bts2[1].setBounds(380, 100, 150, 50);

		ff_f_first.add(ff_p_background1);
		ff_f_first.add(ff_p_background2);

		cardLayout.show(ff_p_background2, "first");

		ff_f_first.setVisible(true);

	}

	public static void main(String[] args) {
		new FirstFrame();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("click");
		if (e.getSource() == login_bts[0]) {
			cardLayout.show(ff_p_background2, "login");
		}
		if (e.getSource() == login_bts[1]) {
			new JoinFrame();
			ff_f_first.setVisible(false);
		}
		if (e.getSource() == login_bts[2]) {
			new SearchFrame();
			ff_f_first.setVisible(false);
		}

		if (e.getSource() == login_bts2[1]) {
			cardLayout.show(ff_p_background2, "first");
		}

	}
}