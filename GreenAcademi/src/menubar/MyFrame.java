package menubar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame implements ActionListener {

	JMenuBar menuBar;
	JMenu fileMenu, editMenu, helpMenu;
	JMenuItem loadItem, saveItem, exitItem;

	MyFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		menuBar = new JMenuBar();

		fileMenu = new JMenu("file");
		editMenu = new JMenu("edit");
		helpMenu = new JMenu("help");

		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");

		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);

		fileMenu.setMnemonic(KeyEvent.VK_F); // alt + f for file
		editMenu.setMnemonic(KeyEvent.VK_E); // alt + e for file
		helpMenu.setMnemonic(KeyEvent.VK_H); // alt + h for file

		loadItem.setMnemonic(KeyEvent.VK_L); // l for load
		saveItem.setMnemonic(KeyEvent.VK_S); // s for save
		exitItem.setMnemonic(KeyEvent.VK_E); // e for exit

		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadItem) {
			System.out.println("load item!");
		}
		if (e.getSource() == saveItem) {
			System.out.println("save item!");
		}
		if (e.getSource() == exitItem) {
			System.exit(0);
		}

	}
}