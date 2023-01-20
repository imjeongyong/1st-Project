package greenAcademiGolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Card_record implements ActionListener {

	JPanel card_record, card_p_view, card_p_record;
	JLabel record_title, record_ballSpeed, record_carry;
	JComboBox<String> cb_vclub, cb_club, cb_path, cb_face, cb_shot;
	JSpinner sp_speed, sp_carry;
	JButton b_search, record_input;

	String id;

	GreenDAO dao;

	String club, path, face, shot;
	int ballSpeed, carry;

	DefaultTableModel model;
	JTable table;
	JScrollPane scrollPane;

	String clubType;

	Card_record(String id) {
		this.id = id;
	}

	public void startCard() {
		recordCard();
		makeViewPanel();
		inputTable1();
		makeRecordPanel();
		addUI();
	}

	public void recordCard() {
		card_record = new JPanel();
		card_record.setBackground(Color.white);
		card_record.setLayout(null);
	}

	public void makeViewPanel() {
		card_p_view = new JPanel();
		card_p_view.setLayout(null);
		card_p_view.setBackground(Color.white);
		card_p_view.setBounds(30, 30, 510, 340);

		String[] v_clubs = { "전체 클럽", "Driver", "3 Woods", "5 Woods", "4 Iron", "5 Iron", "6 Iron", "7 Iron", "8 Iron",
				"9 Iron", "PW", "AS", "SW", "Putter" };
		cb_vclub = new JComboBox<String>(v_clubs);
		cb_vclub.setBounds(0, 0, 100, 50);
		cb_vclub.setFont(new Font("맑은 고딕", Font.PLAIN, 11));

		b_search = new JButton();
		b_search.setBounds(110, 0, 100, 50);
		b_search.setText("조회하기");
		b_search.setBackground(new Color(0, 102, 0));
		b_search.setForeground(Color.white);
		b_search.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		b_search.setFocusable(false);
		b_search.addActionListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 60, 510, 270);

		card_p_view.add(scrollPane);
		card_p_view.add(cb_vclub);
		card_p_view.add(b_search);
	}

	public void inputTable1() {
		dao = new GreenDAO();
		dao.connDB();

		ArrayList<SwingDataVO> list = dao.viewAll(id);
		String[] columnName = { "스윙", "날짜", "클럽", "볼 스피드", "비거리", "스윙패스", "헤드페이스", "구질" };
		String[][] rowData = new String[list.size()][columnName.length];
		for (int row = 0; row < rowData.length; row++) {
			rowData[row][0] = list.get(row).getSwing_number() + "";
			rowData[row][1] = list.get(row).getSwing_date();
			rowData[row][2] = list.get(row).getClub();
			rowData[row][3] = list.get(row).getBallSpeed() + "";
			rowData[row][4] = list.get(row).getCarry() + "";
			rowData[row][5] = list.get(row).getPath();
			rowData[row][6] = list.get(row).getFace();
			rowData[row][7] = list.get(row).getShot();
		}

		model = new DefaultTableModel(rowData, columnName);
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

	public void inputTable2() {
		dao = new GreenDAO();
		dao.connDB();

		ArrayList<SwingDataVO> list = dao.viewClub(id, clubType);
		String[] columnName = { "스윙", "날짜", "클럽", "볼 스피드", "비거리", "스윙패스", "헤드페이스", "구질" };
		String[][] rowData = new String[list.size()][columnName.length];
		for (int row = 0; row < rowData.length; row++) {
			rowData[row][0] = list.get(row).getSwing_number() + "";
			rowData[row][1] = list.get(row).getSwing_date();
			rowData[row][2] = list.get(row).getClub();
			rowData[row][3] = list.get(row).getBallSpeed() + "";
			rowData[row][4] = list.get(row).getCarry() + "";
			rowData[row][5] = list.get(row).getPath();
			rowData[row][6] = list.get(row).getFace();
			rowData[row][7] = list.get(row).getShot();
		}

		model = new DefaultTableModel(rowData, columnName);
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

	public void makeRecordPanel() {
		card_p_record = new JPanel();
		card_p_record.setLayout(null);
		card_p_record.setBackground(Color.white);
		card_p_record.setBounds(30, 400, 510, 210);

		record_title = new JLabel();
		record_title.setBounds(0, 0, 120, 50);
		record_title.setText("스윙 기록실");
		record_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		record_title.setBackground(Color.white);
		record_title.setOpaque(true);

		String[] clubs = { "클럽 종류", "Driver", "3 Woods", "5 Woods", "4 Iron", "5 Iron", "6 Iron", "7 Iron", "8 Iron",
				"9 Iron", "PW", "AS", "SW", "Putter" };
		cb_club = new JComboBox<String>(clubs);
		cb_club.setBounds(0, 70, 100, 50);
		cb_club.setBackground(Color.white);

		record_ballSpeed = new JLabel();
		record_ballSpeed.setBounds(120, 70, 120, 50);
		record_ballSpeed.setHorizontalAlignment(JLabel.CENTER);
		record_ballSpeed.setText("볼 스피드 (km/h) : ");

		sp_speed = new JSpinner();
		sp_speed.setBounds(240, 70, 80, 50);

		record_carry = new JLabel();
		record_carry.setBounds(320, 70, 100, 50);
		record_carry.setHorizontalAlignment(JLabel.CENTER);
		record_carry.setText("비거리 (m) : ");

		sp_carry = new JSpinner();
		sp_carry.setBounds(420, 70, 80, 50);

		String[] path = { "스윙패스", "In-In", "In-Out", "Out-In" };
		cb_path = new JComboBox<String>(path);
		cb_path.setBounds(0, 140, 100, 50);
		cb_path.setBackground(Color.white);

		String[] face = { "클럽 페이스", "Square", "Open", "Close" };
		cb_face = new JComboBox<String>(face);
		cb_face.setBounds(120, 140, 100, 50);
		cb_face.setBackground(Color.white);

		String[] shot = { "구질", "스트레이트", "드로우", "페이드", "훅", "슬라이스", "푸쉬", "풀" };
		cb_shot = new JComboBox<String>(shot);
		cb_shot.setBounds(240, 140, 100, 50);
		cb_shot.setBackground(Color.white);

		record_input = new JButton();
		record_input.setBounds(360, 140, 100, 50);
		record_input.setFocusable(false);
		record_input.setText("기록하기");
		record_input.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		record_input.setBackground(new Color(0, 102, 0));
		record_input.setForeground(Color.white);
		record_input.addActionListener(this);
	}

	public void addUI() {
		card_p_record.add(record_title);
		card_p_record.add(cb_club);
		card_p_record.add(record_ballSpeed);
		card_p_record.add(sp_speed);
		card_p_record.add(record_carry);
		card_p_record.add(sp_carry);
		card_p_record.add(cb_path);
		card_p_record.add(cb_face);
		card_p_record.add(cb_shot);
		card_p_record.add(record_input);

		card_record.add(card_p_view);
		card_record.add(card_p_record);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == record_input) {
			club = (String) cb_club.getSelectedItem();
			ballSpeed = (int) sp_speed.getValue();
			carry = (int) sp_carry.getValue();
			path = (String) cb_path.getSelectedItem();
			face = (String) cb_face.getSelectedItem();
			shot = (String) cb_shot.getSelectedItem();

			if (club.equals("클럽 종류")) {
				JOptionPane.showMessageDialog(null, "클럽을 골라주세요.", "", JOptionPane.PLAIN_MESSAGE);
			} else if (ballSpeed <= 0) {
				JOptionPane.showMessageDialog(null, "볼 스피드를 확인해주세요.", "", JOptionPane.PLAIN_MESSAGE);
			} else if (carry <= 0) {
				JOptionPane.showMessageDialog(null, "비거리를 확인해주세요.", "", JOptionPane.PLAIN_MESSAGE);
			} else if (path.equals("스윙패스")) {
				JOptionPane.showMessageDialog(null, "스윙패스를 확인해주세요.", "", JOptionPane.PLAIN_MESSAGE);
			} else if (face.equals("클럽 페이스")) {
				JOptionPane.showMessageDialog(null, "클럽 페이스를 확인해주세요.", "", JOptionPane.PLAIN_MESSAGE);
			} else if (shot.equals("구질")) {
				JOptionPane.showMessageDialog(null, "구질을 확인해주세요.", "", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "기록이 저장되었습니다.", "", JOptionPane.PLAIN_MESSAGE);
				dao = new GreenDAO();
				dao.connDB();
				dao.inputRecord(id, club, ballSpeed, carry, path, face, shot);
			}
			;
		}

		if (e.getSource() == b_search) {
			if (cb_vclub.getSelectedItem().equals("전체 클럽")) {
				inputTable1();
			} else {
				clubType = cb_vclub.getSelectedItem() + "";
				inputTable2();
			}
		}
	}
}