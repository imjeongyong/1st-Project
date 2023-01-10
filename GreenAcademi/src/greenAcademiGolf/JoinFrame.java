package greenAcademiGolf;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinFrame extends FirstFrame {

	JFrame jf_f_join;
	JLabel ff_f_labelTitle;
	JLabel[] ff_f_labels;
	JTextField[] ff_f_tfs;
	JPasswordField[] ff_f_pfs;
	JButton[] ff_f_bts;

	JoinFrame() {
		jf_f_join = new JFrame("회원가입");
		jf_f_join.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_f_join.setSize(590, 740);
		jf_f_join.setResizable(false);
		jf_f_join.setLayout(null);

		ff_f_labelTitle = new JLabel();
		ff_f_labelTitle.setText("회원가입");
		ff_f_labelTitle.setBounds(0, 0, 590, 100);
		ff_f_labelTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ff_f_labelTitle.setHorizontalAlignment(JLabel.CENTER);

		ff_f_labels = new JLabel[5];
		String[] labelsTxt = { "ID 입력", "닉네임", "이메일 주소", "비밀번호 입력", "비밀버호 확인" };
		for (int i = 0; i < ff_f_labels.length; i++) {
			ff_f_labels[i] = new JLabel();
			ff_f_labels[i].setText(labelsTxt[i]);
			ff_f_labels[i].setFont(bt_font);
			ff_f_labels[i].setSize(100, 60);
			ff_f_labels[i].setHorizontalAlignment(JLabel.RIGHT);

			jf_f_join.add(ff_f_labels[i]);
		}

		ff_f_labels[0].setLocation(20, 130);
		ff_f_labels[1].setLocation(20, 230);
		ff_f_labels[2].setLocation(20, 330);
		ff_f_labels[3].setLocation(20, 430);
		ff_f_labels[4].setLocation(20, 530);

		ff_f_tfs = new JTextField[3];
		for (int i = 0; i < ff_f_tfs.length; i++) {
			ff_f_tfs[i] = new JTextField();
			ff_f_tfs[i].setSize(250, 60);
			ff_f_tfs[i].setFont(bt_font);

			jf_f_join.add(ff_f_tfs[i]);
		}

		ff_f_tfs[0].setLocation(140, 130);
		ff_f_tfs[1].setLocation(140, 230);
		ff_f_tfs[2].setLocation(140, 330);

		ff_f_pfs = new JPasswordField[2];
		for (int i = 0; i < ff_f_pfs.length; i++) {
			ff_f_pfs[i] = new JPasswordField();
			ff_f_pfs[i].setSize(250, 60);
			ff_f_pfs[i].setFont(bt_font);

			jf_f_join.add(ff_f_pfs[i]);
		}

		ff_f_pfs[0].setLocation(140, 430);
		ff_f_pfs[1].setLocation(140, 530);

		ff_f_bts = new JButton[4];
		String[] btsTxt = { "중복확인", "비밀번호 확인", "회원가입", "로그인하기" };
		for (int i = 0; i < ff_f_bts.length; i++) {
			ff_f_bts[i] = new JButton();
			ff_f_bts[i].setText(btsTxt[i]);
			ff_f_bts[i].setFont(bt_font);
			ff_f_bts[i].setSize(140, 60);
			ff_f_bts[i].addActionListener(this);

			jf_f_join.add(ff_f_bts[i]);
		}

		ff_f_bts[0].setLocation(410, 130);
		ff_f_bts[1].setLocation(410, 530);
		ff_f_bts[2].setLocation(140, 620);
		ff_f_bts[3].setLocation(300, 620);

		jf_f_join.add(ff_f_labelTitle);
		jf_f_join.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ff_f_bts[3]) {
			jf_f_join.setVisible(false);
			new FirstFrame();
		}
	}
}