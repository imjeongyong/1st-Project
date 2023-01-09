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

public class MainFrame implements ActionListener {
	MainUI main = new MainUI();
	Tab_main tab_main_panel = new Tab_main();
	Tab_data tab_data_panel = new Tab_data();
	JFrame mainFrame;
	JButton mf_b_logout;
	JLabel mf_l_loginID;
	JPanel mf_p_state, tab_enter, tab_data, tab_community, tab_myInfo, tab_enter_p1, tab_enter_p2, tab_enter_p3;
	JTabbedPane tabbedPane;
	JScrollPane sp;

	MainFrame(String ID) {

		mainFrame = new JFrame();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(700, 850);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		mf_p_state = new JPanel();
		mf_p_state.setSize(750, 50);
		mf_p_state.setBackground(Color.pink);
		mf_p_state.setLayout(new BorderLayout());

		mf_l_loginID = new JLabel();
		mf_l_loginID.setText(ID + " login...");

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

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("main", tab_main_panel.tab_main_p);
		tabbedPane.addTab("enter", sp);
		tabbedPane.addTab("data", tab_data_panel.tab_data_p);
		tabbedPane.addTab("community", tab_community);
		tabbedPane.addTab("five", tab_myInfo);
		tabbedPane.setFocusable(false);

		tab_enter.add(new Tab_enter(1).p_box);
		tab_enter.add(new Tab_enter(2).p_box);
		tab_enter.add(new Tab_enter(3).p_box);
		tab_enter.add(new Tab_enter(4).p_box);
		tab_enter.add(new Tab_enter(5).p_box);
		tab_enter.add(new Tab_enter(6).p_box);
		tab_enter.add(new Tab_enter(7).p_box);
		tab_enter.add(new Tab_enter(8).p_box);
		tab_enter.add(new Tab_enter(9).p_box);
		tab_enter.add(new Tab_enter(10).p_box);

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

	public static void main(String[] args) {
		new MainFrame("KimPro");
	}
}