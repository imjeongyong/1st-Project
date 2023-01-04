package greenAcademiGolf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements ActionListener {
	MainUI main = new MainUI();
	JFrame mainFrame;
	JButton mf_b_logout;
	JLabel mf_l_loginID;

	MainFrame() {

		mf_l_loginID = new JLabel();
		mf_l_loginID.setBounds(10, 750, 200, 50);
		mf_l_loginID.setText(main.getLoginID() + " login...");

		mf_b_logout = new JButton();
		mf_b_logout.setBounds(550, 750, 100, 50);
		mf_b_logout.setText("logout");
		mf_b_logout.setFocusable(false);
		mf_b_logout.addActionListener(this);

		mainFrame = new JFrame();
		mainFrame.setLayout(null);
		mainFrame.setSize(700, 850);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.add(mf_b_logout);
		mainFrame.add(mf_l_loginID);
		
		mainFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mf_b_logout) {
			mainFrame.setVisible(false);
		}
	}

	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		TabbedPanel tp = new TabbedPanel();
		main.getContentPane().add(tp);
	}
}
