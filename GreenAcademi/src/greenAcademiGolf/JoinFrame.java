package greenAcademiGolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinFrame extends FirstFrame {

	JFrame jf_f_join;
	JLabel jf_f_labelTitle, l_notice;
	JLabel[] jf_f_labels;
	JTextField[] jf_f_tfs;
	JPasswordField[] jf_f_pfs;
	JButton[] jf_f_bts;
	JButton b_notice;
	JDialog notice;
	boolean idchk, pwdchk;

	JoinFrame() {
		jf_f_join = new JFrame("회원가입");
		jf_f_join.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_f_join.setSize(590, 740);
		jf_f_join.setResizable(false);
		jf_f_join.setLayout(null);
		jf_f_join.getContentPane().setBackground(Color.white);

		jf_f_labelTitle = new JLabel();
		jf_f_labelTitle.setText("회원가입");
		jf_f_labelTitle.setBounds(0, 0, 590, 100);
		jf_f_labelTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jf_f_labelTitle.setBackground(Color.white);
		jf_f_labelTitle.setOpaque(true);
		jf_f_labelTitle.setHorizontalAlignment(JLabel.CENTER);

		jf_f_labels = new JLabel[5];
		String[] labelsTxt = { "ID 입력", "닉네임", "이메일 주소", "비밀번호 입력", "비밀번호 확인" };
		for (int i = 0; i < jf_f_labels.length; i++) {
			jf_f_labels[i] = new JLabel();
			jf_f_labels[i].setText(labelsTxt[i]);
			jf_f_labels[i].setFont(bt_font);
			jf_f_labels[i].setSize(100, 60);
			jf_f_labels[i].setBackground(Color.white);
			jf_f_labels[i].setOpaque(true);
			jf_f_labels[i].setHorizontalAlignment(JLabel.RIGHT);

			jf_f_join.add(jf_f_labels[i]);
		}

		jf_f_labels[0].setLocation(20, 130);
		jf_f_labels[1].setLocation(20, 230);
		jf_f_labels[2].setLocation(20, 330);
		jf_f_labels[3].setLocation(20, 430);
		jf_f_labels[4].setLocation(20, 530);

		jf_f_tfs = new JTextField[3];
		for (int i = 0; i < jf_f_tfs.length; i++) {
			jf_f_tfs[i] = new JTextField();
			jf_f_tfs[i].setSize(250, 60);
			jf_f_tfs[i].setFont(bt_font);

			jf_f_join.add(jf_f_tfs[i]);
		}

		jf_f_tfs[1].setEditable(false);

		jf_f_tfs[0].setLocation(140, 130);
		jf_f_tfs[1].setLocation(140, 230);
		jf_f_tfs[2].setLocation(140, 330);

		jf_f_pfs = new JPasswordField[2];
		for (int i = 0; i < jf_f_pfs.length; i++) {
			jf_f_pfs[i] = new JPasswordField();
			jf_f_pfs[i].setSize(250, 60);
			jf_f_pfs[i].setFont(bt_font);
			jf_f_pfs[i].setEchoChar('*');

			jf_f_join.add(jf_f_pfs[i]);
		}

		jf_f_pfs[0].setLocation(140, 430);
		jf_f_pfs[1].setLocation(140, 530);

		jf_f_bts = new JButton[4];
		String[] btsTxt = { "중복확인", "비밀번호 확인", "회원가입", "로그인하기" };
		for (int i = 0; i < jf_f_bts.length; i++) {
			jf_f_bts[i] = new JButton();
			jf_f_bts[i].setText(btsTxt[i]);
			jf_f_bts[i].setFont(bt_font);
			jf_f_bts[i].setSize(140, 60);
			jf_f_bts[i].setBackground(bgColor);
			jf_f_bts[i].setForeground(Color.white);
			jf_f_bts[i].addActionListener(this);

			jf_f_join.add(jf_f_bts[i]);
		}

		jf_f_bts[0].setLocation(410, 130);
		jf_f_bts[1].setLocation(410, 530);
		jf_f_bts[2].setLocation(140, 620);
		jf_f_bts[3].setLocation(300, 620);

		l_notice = new JLabel();
		l_notice.setBounds(20, 30, 250, 60);
		l_notice.setFont(bt_font);

		b_notice = new JButton();
		b_notice.setText("확인");
		b_notice.setBounds(150, 100, 70, 50);
		b_notice.setFont(bt_font);
		b_notice.addActionListener(this);

		notice = new JDialog(jf_f_join, false);
		notice.setLayout(null);
		notice.setBounds(300, 200, 300, 200);
		notice.add(b_notice);
		notice.add(l_notice);

		jf_f_join.add(jf_f_labelTitle);
		jf_f_join.setVisible(true);

		dao.connDB();

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jf_f_bts[0]) { // **중복확인**
			notice.setVisible(true);
			if (jf_f_tfs[0].getText().length() == 0) {
				l_notice.setText("아이디를 입력하세요.");
				jf_f_tfs[0].setText("");
			} else if (dao.idChk(jf_f_tfs[0].getText())) {
				l_notice.setText("아이디 생성이 가능합니다.");
				jf_f_tfs[0].setEditable(false);
				jf_f_tfs[1].setEditable(true);
				idchk = true;
			} else {
				l_notice.setText("아이디가 이미 있습니다.");
				jf_f_tfs[0].setText("");
			}
		}
		if (e.getSource() == b_notice) { // **알림 다이얼로그 버튼**
			notice.dispose();
		}

		if (e.getSource() == jf_f_bts[1]) { // **비밀번호 확인**
			notice.setVisible(true);
			String pwd1 = String.valueOf(jf_f_pfs[0].getPassword());
			String pwd2 = String.valueOf(jf_f_pfs[1].getPassword());
			if (pwd1.length() == 0) {
				l_notice.setText("비밀번호를 입력하세요.");
				jf_f_tfs[0].setText("");
			} else if (pwd1.equals(pwd2)) {
				l_notice.setText("비밀번호를 바르게 입력하였습니다.");
				pwdchk = true;
			} else {
				l_notice.setText("비밀번호를 다시 입력해주세요.");
				jf_f_pfs[0].setText("");
				jf_f_pfs[1].setText("");
			}
		}

		if (e.getSource() == jf_f_bts[2]) { // **회원가입 버튼**
			String join_ID = jf_f_tfs[0].getText();
			String join_NN = jf_f_tfs[1].getText();
			String join_Email = jf_f_tfs[2].getText();
			String join_PWD = String.valueOf(jf_f_pfs[0].getPassword());
			if (jf_f_tfs[0].getText().equals("")) {
				notice.setVisible(true);
				l_notice.setText("아이디를 입력하세요.");
			} else if (idchk == false) {
				notice.setVisible(true);
				l_notice.setText("중복확인을 해주세요.");
			} else if (jf_f_tfs[1].getText().equals("")) {
				notice.setVisible(true);
				l_notice.setText("닉네임을 입력하세요.");
			} else if (jf_f_tfs[2].getText().equals("")) {
				notice.setVisible(true);
				l_notice.setText("이메일 주소를 입력하세요.");
			} else if (jf_f_tfs[2].getText().contains("@") == false) {
				notice.setVisible(true);
				l_notice.setText("이메일 주소를 확인해주세요.");
			} else if (join_PWD.equals("")) {
				notice.setVisible(true);
				l_notice.setText("비밀번호를 입력하세요.");
			} else if (pwdchk == false) {
				notice.setVisible(true);
				l_notice.setText("비밀번호를 확인해주세요.");
			} else {
				try {
					dao.joinMembership(join_ID, join_NN, join_Email, join_PWD);
					dao.ins_record1(join_ID, join_NN);
					dao.createData(join_ID);
					dao.addData(join_ID);
					notice.setVisible(true);
					l_notice.setText("아이디가 생성되었습니다.");
					for (int i = 0; i < jf_f_tfs.length; i++) {
						jf_f_tfs[i].setText("");
					}
					for (int i = 0; i < jf_f_pfs.length; i++) {
						jf_f_pfs[i].setText("");
					}
				} catch (Exception e1) {
					notice.setVisible(true);
					l_notice.setText("다시 입력해주세요.");
				}
			}
		}
		if (e.getSource() == jf_f_bts[3]) { // **로그인창 이동 버튼**
			jf_f_join.dispose();
			new FirstFrame().startFrame();
		}
	}
}