package greenAcademiGolf;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class Tab_data {

	JPanel tab_data_p, tab_data_pRecord, tab_data_pInquiry;
	JLabel tab_data_lRecord, l_clubSpeed, l_carry;
	JComboBox<String> cb_club, cb_path, cb_face, cb_shot, cb_inquiry;
	JSpinner sp_speed, sp_carry;
	JButton b_record_add;
	JTable t_records;
	JScrollPane scr_records;

	Tab_data() {

		tab_data_p = new JPanel();
		tab_data_p.setLayout(null);
		tab_data_p.setBackground(Color.black);

		String[][] records = {{"7I","55","160","in-out","square","draw"}};
		String[] fieldList = { "club", "ball speed", "carry", "path", "face", "shot" };

		t_records = new JTable(records, fieldList);

		scr_records = new JScrollPane(t_records);
		scr_records.setBounds(0, 50, 640, 390);

		String[] inquiry = { "whole recordin...", "Driver", "3 Woods", "5 Woods", "4 Iron", "5 Iron", "6 Iron",
				"7 Iron", "8 Iron", "9 Iron", "pw", "as", "sw", "putter" };
		cb_inquiry = new JComboBox<String>(inquiry);
		cb_inquiry.setBounds(0, 0, 150, 50);

		tab_data_pInquiry = new JPanel();
		tab_data_pInquiry.setLayout(null);
		tab_data_pInquiry.setBackground(Color.ORANGE);
		tab_data_pInquiry.setBounds(20, 20, 640, 400);

		tab_data_pRecord = new JPanel();
		tab_data_pRecord.setLayout(null);
		tab_data_pRecord.setBackground(Color.YELLOW);
		tab_data_pRecord.setBounds(20, 440, 640, 300);

		tab_data_lRecord = new JLabel();
		tab_data_lRecord.setBounds(10, 10, 150, 60);
		tab_data_lRecord.setText("Swing Record");
		tab_data_lRecord.setBackground(Color.gray);
		tab_data_lRecord.setOpaque(true);

		String[] clubs = { "Choose club..", "Driver", "3 Woods", "5 Woods", "4 Iron", "5 Iron", "6 Iron", "7 Iron",
				"8 Iron", "9 Iron", "pw", "as", "sw", "putter" };
		cb_club = new JComboBox<String>(clubs);
		cb_club.setBounds(10, 90, 150, 50);

		l_clubSpeed = new JLabel();
		l_clubSpeed.setBounds(170, 90, 100, 50);
		l_clubSpeed.setText("Club speed (km/h) : ");

		sp_speed = new JSpinner();
		sp_speed.setBounds(290, 90, 100, 50);

		l_carry = new JLabel();
		l_carry.setBounds(410, 90, 100, 50);
		l_carry.setText("carry (m) : ");

		sp_carry = new JSpinner();
		sp_carry.setBounds(520, 90, 100, 50);

		String[] path = { "swing path..", "in-in", "in-out", "out-in" };
		cb_path = new JComboBox<String>(path);
		cb_path.setBounds(10, 190, 150, 50);

		String[] face = { "club face..", "square", "open", "close" };
		cb_face = new JComboBox<String>(face);
		cb_face.setBounds(180, 190, 150, 50);

		String[] shot = { "your shot..", "straight", "draw", "fade", "hook", "slice", "push", "pull" };
		cb_shot = new JComboBox<String>(shot);
		cb_shot.setBounds(350, 190, 150, 50);

		b_record_add = new JButton();
		b_record_add.setBounds(520, 190, 100, 50);
		b_record_add.setText("add");

		tab_data_pInquiry.add(scr_records);
		tab_data_pInquiry.add(cb_inquiry);

		tab_data_pRecord.add(tab_data_lRecord);
		tab_data_pRecord.add(cb_club);
		tab_data_pRecord.add(l_clubSpeed);
		tab_data_pRecord.add(sp_speed);
		tab_data_pRecord.add(l_carry);
		tab_data_pRecord.add(sp_carry);
		tab_data_pRecord.add(cb_path);
		tab_data_pRecord.add(cb_face);
		tab_data_pRecord.add(cb_shot);
		tab_data_pRecord.add(b_record_add);

		tab_data_p.add(tab_data_pInquiry);
		tab_data_p.add(tab_data_pRecord);
	}
}