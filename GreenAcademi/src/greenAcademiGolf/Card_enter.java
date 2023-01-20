package greenAcademiGolf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Card_enter {

	JPanel card_enter;
	String id;

	Card_enter(String id) {
		this.id = id;
	}

	void makeUI() {
		card_enter = new JPanel();
		card_enter.setBackground(Color.white);
		card_enter.setLayout(new GridLayout(4, 2, 20, 20));
		card_enter.setPreferredSize(new Dimension(555, 800));
	}

	void addBox() {
		for (int i = 1; i <= 8; i++) {
			SwingBox1 sbi = new SwingBox1(i, id);
			sbi.startSwingBox();
			card_enter.add(sbi.p_SwingBox);
		}
	}
}