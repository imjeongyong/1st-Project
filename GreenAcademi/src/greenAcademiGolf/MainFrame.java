package greenAcademiGolf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame implements ActionListener {

	JFrame mainFrame;
	JPanel mf_p_state, mf_p_main, mf_p_button;
	JLabel mf_l_state;
	JButton mf_b_state;
	CardLayout cl;
	JButton[] mf_bts_card;
	JScrollPane sp;

	String id;
	Card_main cm;
	Card_enter ce;
	Card_record cr;

	MainFrame(String id) {
		this.id = id;
	}

	public void startFrame() {
		mainUI();
		statePanel();
		cardPanel();
		addUI();
		mainFrame.setVisible(true);
	}

	public void mainUI() {
		mainFrame = new JFrame("메인");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(590, 740);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setBackground(Color.white);
		mainFrame.setLayout(new BorderLayout());

	}

	public void statePanel() {
		mf_p_state = new JPanel();
		mf_p_state.setLayout(new BorderLayout());
		mf_p_state.setBackground(Color.white);

		mf_l_state = new JLabel();
		mf_l_state.setVerticalAlignment(JLabel.CENTER);
		mf_l_state.setText(id + " 님 로그인 했습니다...");
		mf_l_state.setBackground(Color.white);
		mf_l_state.setOpaque(true);

		mf_b_state = new JButton();
		mf_b_state.setText("로그아웃");
		mf_b_state.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mf_b_state.setForeground(Color.white);
		mf_b_state.setFocusable(false);
		mf_b_state.setBackground(new Color(0, 102, 0));
		mf_b_state.addActionListener(this);

	}

	public void cardPanel() {
		cl = new CardLayout();

		mf_p_main = new JPanel();
		mf_p_main.setBackground(Color.white);
		mf_p_main.setOpaque(true);
		mf_p_main.setLayout(cl);
		mf_p_main.setBackground(Color.red);

		cm = new Card_main(id);
		ce = new Card_enter(id);
		cr = new Card_record(id);

		ce.makeUI();
		ce.addBox();

		cr.startCard();

		sp = new JScrollPane(ce.card_enter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		sp.getVerticalScrollBar().setUnitIncrement(16);
		sp.setBackground(Color.white);

		mf_p_main.add(cm.card_main, "main");
		mf_p_main.add(sp, "enter");
		mf_p_main.add(cr.card_record, "data");

		mf_p_button = new JPanel();
		mf_p_button.setBackground(Color.white);
		mf_p_button.setLayout(new FlowLayout());

		mf_bts_card = new JButton[3];
		String[] btName = { "메인", "타석 입장", "기록실" };
		for (int i = 0; i < mf_bts_card.length; i++) {
			mf_bts_card[i] = new JButton();
			mf_bts_card[i].setText(btName[i]);
			mf_bts_card[i].setFocusable(false);
			mf_bts_card[i].setForeground(Color.white);
			mf_bts_card[i].setFocusable(false);
			mf_bts_card[i].setBackground(new Color(0, 102, 0));
			mf_bts_card[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			mf_bts_card[i].addActionListener(this);
			mf_p_button.add(mf_bts_card[i]);
		}

		mf_p_state.add(mf_l_state, BorderLayout.WEST);
		mf_p_state.add(mf_b_state, BorderLayout.EAST);
	}

	public void addUI() {
		mainFrame.add(mf_p_button, BorderLayout.NORTH);
		mainFrame.add(mf_p_main, BorderLayout.CENTER);
		mainFrame.add(mf_p_state, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mf_b_state) {
			mainFrame.dispose();
		}

		if (e.getSource() == mf_bts_card[0]) {
			cl.show(mf_p_main, "main");
			cm.printState1();
		}

		if (e.getSource() == mf_bts_card[1]) {
			cl.show(mf_p_main, "enter");
		}

		if (e.getSource() == mf_bts_card[2]) {
			cl.show(mf_p_main, "data");
		}

	}
}