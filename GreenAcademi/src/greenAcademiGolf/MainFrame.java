package greenAcademiGolf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MainFrame extends FirstFrame implements ActionListener {
	Tab_data tab_data_panel = new Tab_data();
	JFrame mainFrame;
	JButton mf_b_logout;
	JLabel mf_l_loginID;
	JPanel mf_p_state, tab_enter, tab_data, tab_community, tab_myInfo, tab_enter_p1, tab_enter_p2, tab_enter_p3;
	JTabbedPane tabbedPane;
	JScrollPane sp;

	MainFrame(String id, String nickname, String pwd) {

		mainFrame = new JFrame();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(700, 850);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		mf_p_state = new JPanel();
		mf_p_state.setSize(750, 50);
		mf_p_state.setLayout(new BorderLayout());

		mf_l_loginID = new JLabel();
		mf_l_loginID.setText(nickname + " 님이 로그인 중입니다...");

		mf_b_logout = new JButton();
		mf_b_logout.setText("logout");
		mf_b_logout.setFocusable(false);
		mf_b_logout.addActionListener(this);

		tab_enter = new JPanel();
		tab_enter.setLayout(new GridLayout(5, 2, 20, 20));
		tab_enter.setPreferredSize(new Dimension(650, 1200));
		tab_enter.setBackground(Color.DARK_GRAY);

		sp = new JScrollPane(tab_enter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.getVerticalScrollBar().setUnitIncrement(16);

		tab_community = new JPanel();
		tab_community.setBackground(Color.yellow);

		tab_myInfo = new JPanel();
		tab_myInfo.setBackground(Color.cyan);

		Tab_main tab_main_panel = new Tab_main(id, nickname, pwd);

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("main", tab_main_panel.tab_main_p);
		tabbedPane.addTab("enter", sp);
		tabbedPane.addTab("data", tab_data_panel.tab_data_p);
		tabbedPane.addTab("community", tab_community);
		tabbedPane.addTab("five", tab_myInfo);
		tabbedPane.setFocusable(false);

		for (int i = 1; i <= 10; i++) {
			tab_enter.add(new Tab_enter(i, id, nickname).p_box);
		}

		mainFrame.add(mf_p_state, BorderLayout.SOUTH);
		mainFrame.add(tabbedPane, BorderLayout.CENTER);

		mf_p_state.add(mf_l_loginID, BorderLayout.WEST);
		mf_p_state.add(mf_b_logout, BorderLayout.EAST);

		mainFrame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mf_b_logout) {
			mainFrame.setVisible(false);
		}
	}
}