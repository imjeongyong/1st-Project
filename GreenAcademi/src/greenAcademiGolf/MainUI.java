package greenAcademiGolf;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainUI extends WindowAdapter implements ActionListener {
	private Frame firstFrame, joinFrame, searchFrame, mainFrame;
	private Button ff_bLogin, ff_bJoin, ff_bFind, bt2_bCancel, bt2_bLogin, jf_bJoin, jf_bLogin, jf_bIDchk, jf_bPWDchk,
			d3_idchk_bok, d3_idchk_bno, d3_pwdchk_bok, d3_pwdchk_bno, d3_joinComplet_bok, sf_bFindID, sf_bFindPwd,
			sf_bBack, sf_pID_bConfirm, sf_pID_bCancel, sf_pPwd_bConfirm, sf_pPwd_bCancel, d1_bOK, d2_bOK1, d2_bOK2,
			mf_pM_bHome, mf_pM_bRecord, mf_pM_bStats, mf_pM_bSwing, mf_pM_bMap, mf_pH_bReser;
	private Panel p_1stMain, fst_pBottom1, fst_pBottom2, sf_pFindID, sf_pFindPwd, mf_pMenu, mf_pHome, mf_pRecord,
			mf_pStat, mf_pVideo, mf_pMap;
	private Label bt2_lID, bt2_lPwd, jf_lJoin, jf_lID, jf_lName, jf_lEmail, jf_lPwd, jf_lRepwd, d3_idchk_lok,
			d3_idchk_lno, d3_pwdchk_lok, d3_pwdchk_lno, d3_joinComplet_ljc, sf_pID_lName, sf_pID_lEmail, sf_pPwd_lID,
			sf_pPwd_lEmail, d1_lMsg1, d2_lSuccess, d2_lFail, mf_pH_lTitle;
	private TextField bt2_tID, bt2_tPwd, jf_tID, jf_tName, jf_tEmail, jf_tPwd, jf_tRepwd, sf_pID_tName, sf_pID_tEmail,
			sf_pPwd_tID, sf_pPwd_tEmail;
	private TextArea mf_pH_taSum, mf_pH_taVideo;
	private Dialog d1_LoginFail, d2_joinSuccess, d2_joinFail, d3_jf_idchk_ok, d3_jf_idchk_no, d3_jf_pwdchk_ok,
			d3_jf_pwdchk_no, d3_jf_joinComplet;

	MainUI() {

		// 프레임 1(첫 화면)
		firstFrame = new Frame("First Frame");
		firstFrame.setSize(700, 850);
		firstFrame.setBackground(Color.WHITE);
		firstFrame.setLayout(null);

		// 프래임1 -> 메인패널
		p_1stMain = new Panel();
		p_1stMain.setSize(600, 650);
		p_1stMain.setLocation(50, 25);
		p_1stMain.setBackground(Color.GREEN);

		// 프레임 1 -> 바텀 패널1
		fst_pBottom1 = new Panel();
		fst_pBottom1.setLayout(null);
		fst_pBottom1.setSize(600, 100);
		fst_pBottom1.setLocation(50, 700);
		fst_pBottom1.setBackground(Color.YELLOW);

		ff_bLogin = new Button("ff_bLogin");
		ff_bLogin.setSize(600, 50);
		ff_bLogin.setLocation(0, 0);

		ff_bJoin = new Button("ff_bJoin");
		ff_bJoin.setSize(300, 50);
		ff_bJoin.setLocation(0, 50);

		ff_bFind = new Button("ff_bFind");
		ff_bFind.setSize(300, 50);
		ff_bFind.setLocation(300, 50);

		// 프레임1 -> 바텀 패널2
		fst_pBottom2 = new Panel();
		fst_pBottom2.setLayout(null);
		fst_pBottom2.setSize(600, 100);
		fst_pBottom2.setLocation(50, 700);
		fst_pBottom2.setBackground(Color.RED);

		bt2_lID = new Label("bt2_lID", Label.LEFT);
		bt2_lID.setSize(100, 50);
		bt2_lID.setBackground(Color.LIGHT_GRAY);
		bt2_lID.setLocation(0, 0);

		bt2_lPwd = new Label("bt2_lPwd", Label.LEFT);
		bt2_lPwd.setSize(100, 50);
		bt2_lPwd.setBackground(Color.LIGHT_GRAY);
		bt2_lPwd.setLocation(0, 50);

		bt2_tID = new TextField(20);
		bt2_tID.setText("bt2_tID");
		bt2_tID.setSize(300, 50);
		bt2_tID.setLocation(100, 0);

		bt2_tPwd = new TextField(20);
		bt2_tPwd.setText("bt2_tPwd");
		bt2_tPwd.setSize(300, 50);
		bt2_tPwd.setLocation(100, 50);
		bt2_tPwd.setEchoChar('*');

		bt2_bLogin = new Button("bt2_bLogin");
		bt2_bLogin.setSize(100, 100);
		bt2_bLogin.setLocation(400, 00);

		bt2_bCancel = new Button("bt2_bCancel");
		bt2_bCancel.setSize(100, 100);
		bt2_bCancel.setLocation(500, 0);

		// 프레임1 -> 바텀 패널2 -> 로그인 실패 안내 다이얼로그
		d1_LoginFail = new Dialog(firstFrame, false);
		d1_LoginFail.setLayout(new FlowLayout());
		d1_LoginFail.setSize(300, 200);
		d1_LoginFail.setLocation(150, 300);

		d1_lMsg1 = new Label("Login Fail!! \nReTry!!");
		d1_bOK = new Button("OK");

		// 프레임 2(회원가입 창)
		joinFrame = new Frame("join Frame");
		joinFrame.setLayout(null);
		joinFrame.setSize(700, 850);
		joinFrame.setVisible(false);

		// 프레임 2 -> 회원가입 정보 입력 라벨, 텍스트박스
		jf_lJoin = new Label("jf_lJoin", Label.CENTER);
		jf_lJoin.setSize(700, 100);
		jf_lJoin.setLocation(0, 0);
		jf_lID = new Label("jf_lID", Label.LEFT);
		jf_lID.setSize(100, 100);
		jf_lID.setLocation(0, 100);
		jf_tID = new TextField(10);
		jf_tID.setSize(500, 100);
		jf_tID.setLocation(100, 100);
		jf_lName = new Label("jf_lName", Label.LEFT);
		jf_lName.setSize(100, 100);
		jf_lName.setLocation(0, 200);
		jf_tName = new TextField(10);
		jf_tName.setSize(500, 100);
		jf_tName.setLocation(100, 200);
		jf_lEmail = new Label("jf_lEmail", Label.LEFT);
		jf_lEmail.setSize(100, 100);
		jf_lEmail.setLocation(0, 300);
		jf_tEmail = new TextField(10);
		jf_tEmail.setSize(500, 100);
		jf_tEmail.setLocation(100, 300);
		jf_lPwd = new Label("jf_lPwd", Label.LEFT);
		jf_lPwd.setSize(100, 100);
		jf_lPwd.setLocation(0, 400);
		jf_tPwd = new TextField(10);
		jf_tPwd.setSize(500, 100);
		jf_tPwd.setLocation(100, 400);
		jf_lRepwd = new Label("jf_lRepwd", Label.LEFT);
		jf_lRepwd.setSize(100, 100);
		jf_lRepwd.setLocation(0, 500);
		jf_tRepwd = new TextField(10);
		jf_tRepwd.setSize(500, 100);
		jf_tRepwd.setLocation(100, 500);

		// 프레임2 -> 버튼
		jf_bIDchk = new Button("jf_bIDchk");
		jf_bIDchk.setSize(100, 100);
		jf_bIDchk.setLocation(600, 100);
		jf_bPWDchk = new Button("jf_bPWDchk");
		jf_bPWDchk.setSize(100, 100);
		jf_bPWDchk.setLocation(600, 500);
		jf_bJoin = new Button("jf_bJoin");
		jf_bJoin.setSize(100, 100);
		jf_bJoin.setLocation(100, 700);
		jf_bLogin = new Button("jf_bLogin");
		jf_bLogin.setSize(100, 100);
		jf_bLogin.setLocation(300, 700);

		// 프레임2 -> 다이얼로그
		d2_joinSuccess = new Dialog(joinFrame, false);
		d2_joinSuccess.setLayout(new FlowLayout());
		d2_joinSuccess.setSize(300, 200);
		d2_joinSuccess.setLocation(150, 300);
		d2_lSuccess = new Label("Complete!!");
		d2_bOK1 = new Button("OK1");

		d2_joinFail = new Dialog(joinFrame, false);
		d2_joinFail.setLayout(new FlowLayout());
		d2_joinFail.setSize(300, 200);
		d2_joinFail.setLocation(150, 300);
		d2_lFail = new Label("Fail!\nReTry!!");
		d2_bOK2 = new Button("OK2");

		d3_jf_idchk_ok = new Dialog(joinFrame, false);
		d3_jf_idchk_ok.setLayout(new FlowLayout());
		d3_jf_idchk_ok.setSize(300, 200);
		d3_jf_idchk_ok.setLocation(150, 300);
		d3_idchk_lok = new Label("d3_idchk_lok");
		d3_idchk_bok = new Button("d3_idchk_bok");

		d3_jf_idchk_no = new Dialog(joinFrame, false);
		d3_jf_idchk_no.setLayout(new FlowLayout());
		d3_jf_idchk_no.setSize(300, 200);
		d3_jf_idchk_no.setLocation(150, 300);
		d3_idchk_lno = new Label("d3_idchk_lno");
		d3_idchk_bno = new Button("d3_idchk_bno");

		d3_jf_pwdchk_ok = new Dialog(joinFrame, false);
		d3_jf_pwdchk_ok.setLayout(new FlowLayout());
		d3_jf_pwdchk_ok.setSize(300, 200);
		d3_jf_pwdchk_ok.setLocation(150, 300);
		d3_pwdchk_lok = new Label("d3_pwdchk_lok");
		d3_pwdchk_bok = new Button("d3_pwdchk_bok");

		d3_jf_pwdchk_no = new Dialog(joinFrame, false);
		d3_jf_pwdchk_no.setLayout(new FlowLayout());
		d3_jf_pwdchk_no.setSize(300, 200);
		d3_jf_pwdchk_no.setLocation(150, 300);
		d3_pwdchk_lno = new Label("d3_pwdchk_lno");
		d3_pwdchk_bno = new Button("d3_pwdchk_bno");

		d3_jf_joinComplet = new Dialog(joinFrame, false);
		d3_jf_joinComplet.setLayout(new FlowLayout());
		d3_jf_joinComplet.setSize(300, 200);
		d3_jf_joinComplet.setLocation(150, 300);
		d3_joinComplet_ljc = new Label("d3_joinComplet_ljc");
		d3_joinComplet_bok = new Button("d3_joinComplet_bok");

		// 프레임 3(아이디/비밀번호 찾기 창)
		searchFrame = new Frame("search Frame");
		searchFrame.setLayout(null);
		searchFrame.setSize(700, 850);
		searchFrame.setVisible(false);

		// 프레임 3 -> ID찾기, PASSWORD찾기, BACK 버튼
		sf_bFindID = new Button("sf_bFindID");
		sf_bFindID.setSize(250, 100);
		sf_bFindID.setLocation(50, 50);

		sf_bFindPwd = new Button("sf_bFindPwd");
		sf_bFindPwd.setSize(250, 100);
		sf_bFindPwd.setLocation(300, 50);

		sf_bBack = new Button("sf_bBack");
		sf_bBack.setSize(100, 100);
		sf_bBack.setLocation(550, 50);

		// 프레임 3 -> ID찾기 패널
		sf_pFindID = new Panel(null);
		sf_pFindID.setSize(600, 600);
		sf_pFindID.setLocation(50, 150);
		sf_pFindID.setBackground(Color.BLUE);
		sf_pFindID.setVisible(false);

		sf_pID_bConfirm = new Button("sf_pID_bConfirm");
		sf_pID_bConfirm.setSize(300, 100);
		sf_pID_bConfirm.setLocation(0, 500);
		sf_pID_bCancel = new Button("sf_pID_bCancel");
		sf_pID_bCancel.setSize(300, 100);
		sf_pID_bCancel.setLocation(300, 500);

		sf_pID_lName = new Label("sf_pID_lName", Label.LEFT);
		sf_pID_lName.setSize(600, 100);
		sf_pID_lName.setLocation(0, 0);
		sf_pID_lName.setBackground(Color.WHITE);

		sf_pID_lEmail = new Label("sf_pId_lEmail", Label.LEFT);
		sf_pID_lEmail.setSize(600, 100);
		sf_pID_lEmail.setLocation(0, 200);
		sf_pID_lEmail.setBackground(Color.WHITE);

		sf_pID_tName = new TextField(10);
		sf_pID_tName.setSize(600, 100);
		sf_pID_tName.setLocation(0, 100);
		sf_pID_tName.setBackground(Color.WHITE);

		sf_pID_tEmail = new TextField(10);
		sf_pID_tEmail.setSize(600, 100);
		sf_pID_tEmail.setLocation(0, 300);
		sf_pID_tEmail.setBackground(Color.WHITE);

		// 프레임 3 -> PASSWORD 찾기 패널
		sf_pFindPwd = new Panel(null);
		sf_pFindPwd.setSize(600, 600);
		sf_pFindPwd.setLocation(50, 150);
		sf_pFindPwd.setBackground(Color.RED);
		sf_pFindPwd.setVisible(false);

		sf_pPwd_bConfirm = new Button("sf_pPwd_bConfirm");
		sf_pPwd_bConfirm.setSize(300, 100);
		sf_pPwd_bConfirm.setLocation(0, 500);
		sf_pPwd_bCancel = new Button("sf_pPwd_bCancel");
		sf_pPwd_bCancel.setSize(300, 100);
		sf_pPwd_bCancel.setLocation(300, 500);

		sf_pPwd_lID = new Label("sf_pPwd_lID", Label.LEFT);
		sf_pPwd_lID.setSize(600, 100);
		sf_pPwd_lID.setLocation(0, 0);
		sf_pPwd_lID.setBackground(Color.WHITE);

		sf_pPwd_lEmail = new Label("sf_pPwd_lEmail", Label.LEFT);
		sf_pPwd_lEmail.setSize(600, 100);
		sf_pPwd_lEmail.setLocation(0, 200);
		sf_pPwd_lEmail.setBackground(Color.WHITE);

		sf_pPwd_tID = new TextField(10);
		sf_pPwd_tID.setSize(600, 100);
		sf_pPwd_tID.setLocation(0, 100);
		sf_pPwd_tID.setBackground(Color.WHITE);

		sf_pPwd_tEmail = new TextField(10);
		sf_pPwd_tEmail.setSize(600, 100);
		sf_pPwd_tEmail.setLocation(0, 300);
		sf_pPwd_tEmail.setBackground(Color.WHITE);

		// 프레임4 (로그인 완료 후 메인창)
		mainFrame = new Frame("MainFrame");
		mainFrame.setLayout(null);
		mainFrame.setSize(700, 850);
		mainFrame.setVisible(false);

		// 프레임4 -> 홈 패널
		mf_pHome = new Panel(null);
		mf_pHome.setSize(700, 750);
		mf_pHome.setLocation(0, 0);
		mf_pHome.setBackground(Color.YELLOW);
		mf_pHome.setVisible(true);

		mf_pH_lTitle = new Label("Title", Label.CENTER);
		mf_pH_lTitle.setSize(700, 50);
		mf_pH_lTitle.setLocation(0, 30);

		mf_pH_taSum = new TextArea("mf_pH_taSum \nmf_pH_taSum \nmf_pH_taSum", 10, 5);
		mf_pH_taSum.setSize(700, 300);
		mf_pH_taSum.setLocation(6, 80);

		mf_pH_bReser = new Button("mf_pH_bReser");
		mf_pH_bReser.setSize(700, 100);
		mf_pH_bReser.setLocation(0, 380);

		mf_pH_taVideo = new TextArea("Video Play display?????", 10, 5);
		mf_pH_taVideo.setSize(700, 300);
		mf_pH_taVideo.setLocation(0, 480);

		// 프레임4 -> Record패널
		mf_pRecord = new Panel(null);
		mf_pRecord.setSize(700, 750);
		mf_pRecord.setLocation(0, 0);
		mf_pRecord.setBackground(Color.RED);
		mf_pRecord.setVisible(false);

		// 프레임4 -> Stat패널
		mf_pStat = new Panel(null);
		mf_pStat.setSize(700, 750);
		mf_pStat.setLocation(0, 0);
		mf_pStat.setBackground(Color.ORANGE);
		mf_pStat.setVisible(false);

		// 프레임4 -> Video패널
		mf_pVideo = new Panel(null);
		mf_pVideo.setSize(700, 750);
		mf_pVideo.setLocation(0, 0);
		mf_pVideo.setBackground(Color.PINK);
		mf_pVideo.setVisible(false);

		// 프레임4 -> Map패널
		mf_pMap = new Panel(null);
		mf_pMap.setSize(700, 750);
		mf_pMap.setLocation(0, 0);
		mf_pMap.setBackground(Color.YELLOW);
		mf_pMap.setVisible(false);

		// 프레임4 -> 하단 메뉴바
		mf_pMenu = new Panel();
		mf_pMenu.setLayout(new GridLayout(1, 5));
		mf_pMenu.setSize(700, 100);
		mf_pMenu.setLocation(0, 750);
		mf_pMenu.setBackground(Color.GREEN);
		mf_pMenu.setVisible(true);

		mf_pM_bHome = new Button("mf_pM_bHome");
		mf_pM_bRecord = new Button("mf_pM_bRecord");
		mf_pM_bStats = new Button("mf_pM_bStats");
		mf_pM_bSwing = new Button("mf_pM_bSwing");
		mf_pM_bMap = new Button("mf_pM_bMap");
	}

	public void startFrame() {
		firstFrame.addWindowListener(this);
		firstFrame.add(p_1stMain);
		firstFrame.add(fst_pBottom1);
		firstFrame.add(fst_pBottom2);
		firstFrame.setVisible(true);

		Button[] bStr = { ff_bLogin, ff_bFind, ff_bJoin };
		for (int i = 0; i < bStr.length; i++) {
			fst_pBottom1.add(bStr[i]);
			bStr[i].addActionListener(this);
		}

		bt2_bLogin.addActionListener(this);
		bt2_bCancel.addActionListener(this);
		jf_bIDchk.addActionListener(this);
		jf_bPWDchk.addActionListener(this);
		jf_bJoin.addActionListener(this);
		jf_bLogin.addActionListener(this);

		d1_bOK.addActionListener(this);

		d2_bOK1.addActionListener(this);
		d2_bOK2.addActionListener(this);

		joinFrame.addWindowListener(this);

		d3_idchk_bok.addActionListener(this);
		d3_idchk_bno.addActionListener(this);
		d3_pwdchk_bok.addActionListener(this);
		d3_pwdchk_bno.addActionListener(this);
		d3_joinComplet_bok.addActionListener(this);

		fst_pBottom2.add(bt2_lID);
		fst_pBottom2.add(bt2_tID);
		fst_pBottom2.add(bt2_lPwd);
		fst_pBottom2.add(bt2_tPwd);
		fst_pBottom2.add(bt2_bLogin);
		fst_pBottom2.add(bt2_bCancel);

		d1_LoginFail.add(d1_lMsg1);
		d1_LoginFail.add(d1_bOK);

		d2_joinSuccess.add(d2_lSuccess);
		d2_joinSuccess.add(d2_bOK1);
		d2_joinFail.add(d2_lFail);
		d2_joinFail.add(d2_bOK2);

		joinFrame.setVisible(false);
		joinFrame.add(jf_lJoin);
		joinFrame.add(jf_lID);
		joinFrame.add(jf_tID);
		joinFrame.add(jf_bIDchk);
		joinFrame.add(jf_lName);
		joinFrame.add(jf_tName);
		joinFrame.add(jf_lEmail);
		joinFrame.add(jf_tEmail);
		joinFrame.add(jf_lPwd);
		joinFrame.add(jf_tPwd);
		joinFrame.add(jf_bPWDchk);
		joinFrame.add(jf_lRepwd);
		joinFrame.add(jf_tRepwd);
		joinFrame.add(jf_bJoin);
		joinFrame.add(jf_bLogin);

		d3_jf_idchk_ok.add(d3_idchk_lok);
		d3_jf_idchk_ok.add(d3_idchk_bok);
		d3_jf_idchk_no.add(d3_idchk_lno);
		d3_jf_idchk_no.add(d3_idchk_bno);
		d3_jf_pwdchk_ok.add(d3_pwdchk_lok);
		d3_jf_pwdchk_ok.add(d3_pwdchk_bok);
		d3_jf_pwdchk_no.add(d3_pwdchk_lno);
		d3_jf_pwdchk_no.add(d3_pwdchk_bno);
		d3_jf_joinComplet.add(d3_joinComplet_ljc);
		d3_jf_joinComplet.add(d3_joinComplet_bok);

		searchFrame.addWindowListener(this);
		searchFrame.add(sf_bFindID);
		searchFrame.add(sf_bFindPwd);
		searchFrame.add(sf_bBack);
		searchFrame.add(sf_pFindID);
		searchFrame.add(sf_pFindPwd);

		sf_pFindID.add(sf_pID_bConfirm);
		sf_pFindID.add(sf_pID_bCancel);
		sf_pFindID.add(sf_pID_lName);
		sf_pFindID.add(sf_pID_tName);
		sf_pFindID.add(sf_pID_lEmail);
		sf_pFindID.add(sf_pID_tEmail);
		sf_pFindPwd.add(sf_pPwd_bConfirm);
		sf_pFindPwd.add(sf_pPwd_bCancel);
		sf_pFindPwd.add(sf_pPwd_lID);
		sf_pFindPwd.add(sf_pPwd_tID);
		sf_pFindPwd.add(sf_pPwd_lEmail);
		sf_pFindPwd.add(sf_pPwd_tEmail);

		sf_bFindID.addActionListener(this);
		sf_bFindPwd.addActionListener(this);
		sf_bBack.addActionListener(this);
		sf_pID_bConfirm.addActionListener(this);
		sf_pID_bCancel.addActionListener(this);
		sf_pPwd_bConfirm.addActionListener(this);
		sf_pPwd_bCancel.addActionListener(this);

		mainFrame.addWindowListener(this);

		mainFrame.add(mf_pMenu);
		mainFrame.add(mf_pHome);
		mainFrame.add(mf_pRecord);
		mainFrame.add(mf_pStat);
		mainFrame.add(mf_pVideo);
		mainFrame.add(mf_pMap);

		mf_pMenu.add(mf_pM_bHome);
		mf_pMenu.add(mf_pM_bRecord);
		mf_pMenu.add(mf_pM_bStats);
		mf_pMenu.add(mf_pM_bSwing);
		mf_pMenu.add(mf_pM_bMap);

		mf_pHome.add(mf_pH_lTitle);
		mf_pHome.add(mf_pH_taSum);
		mf_pHome.add(mf_pH_bReser);
		mf_pHome.add(mf_pH_taVideo);

		mf_pM_bHome.addActionListener(this);
		mf_pM_bRecord.addActionListener(this);
		mf_pM_bStats.addActionListener(this);
		mf_pM_bSwing.addActionListener(this);
		mf_pM_bMap.addActionListener(this);
		mf_pH_bReser.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		MemberDAO dao = new MemberDAO();

		System.out.println("click!");

		if (e.getActionCommand().equals(ff_bLogin.getLabel())) {
			firstFrame.remove(fst_pBottom1);
			firstFrame.add(fst_pBottom2);
		}

		if (e.getActionCommand().equals(ff_bFind.getLabel())) {
			searchFrame.setVisible(true);
		}

		if (e.getActionCommand().equals(bt2_bLogin.getLabel())) { // **로그인 버튼**
			ArrayList<MemberVo> list = dao.tryLogin(bt2_tID.getText());
			String mem_pwd = "";
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				mem_pwd = data.getMem_pwd();
			}
			if (bt2_tPwd.getText().equals(mem_pwd)) {
				firstFrame.setVisible(false);
				mainFrame.setVisible(true);
			} else {
				d1_LoginFail.setVisible(true);
			}
		}

		if (e.getActionCommand().equals(jf_bIDchk.getLabel())) { // **회원가입 IDchk 버튼**
			if ((dao.idChk(jf_tID.getText())) == false) {
				System.out.println("retry");
				d3_jf_idchk_no.setVisible(true);
				jf_tID.setText("");
			} else {
				d3_jf_idchk_ok.setVisible(true);
			}
		}

		if (e.getActionCommand().equals(d1_bOK.getLabel())) {
			d1_LoginFail.setVisible(false);
			bt2_tID.setText("");
			bt2_tPwd.setText("");
		}

		if (e.getActionCommand().equals(bt2_bCancel.getLabel())) {
			firstFrame.remove(fst_pBottom2);
			firstFrame.add(fst_pBottom1);
		}
		if (e.getActionCommand().equals(ff_bJoin.getLabel())) {
			joinFrame.setVisible(true);
		}
		if (e.getActionCommand().equals(jf_bJoin.getLabel())) { // **회원가입 버튼**
			String new_id = jf_tID.getText();
			String new_name = jf_tName.getText();
			String new_email = jf_tEmail.getText();
			String new_pwd = jf_tPwd.getText();
			dao.joinMembership(new_id, new_name, new_email, new_pwd);
			d3_jf_joinComplet.setVisible(true);
			jf_tID.setText("");
			jf_tName.setText("");
			jf_tEmail.setText("");
			jf_tPwd.setText("");
			jf_tRepwd.setText("");
		}
		if (e.getActionCommand().equals(jf_bLogin.getLabel())) {
			System.out.println("Login");
			joinFrame.setVisible(false);
		}
		if (e.getActionCommand().equals(sf_bFindID.getLabel())) {
			sf_pFindID.setVisible(true);
			sf_pFindPwd.setVisible(false);
		}
		if (e.getActionCommand().equals(sf_bFindPwd.getLabel())) {
			sf_pFindID.setVisible(false);
			sf_pFindPwd.setVisible(true);
		}
		if (e.getActionCommand().equals(sf_bBack.getLabel())) {
			searchFrame.setVisible(false);
		}
		if (e.getActionCommand().equals(sf_pID_bConfirm.getLabel())) {
			System.out.println("Confirm1");
		}
		if (e.getActionCommand().equals(sf_pID_bCancel.getLabel())) {
			sf_pFindID.setVisible(false);
			sf_pFindPwd.setVisible(false);
		}
		if (e.getActionCommand().equals(sf_pPwd_bConfirm.getLabel())) {
			System.out.println("Confirm2");
		}
		if (e.getActionCommand().equals(sf_pPwd_bCancel.getLabel())) {
			sf_pFindID.setVisible(false);
			sf_pFindPwd.setVisible(false);
		}
		if (e.getActionCommand().equals(d2_bOK1.getLabel())) {
			d2_joinSuccess.dispose();
			joinFrame.setVisible(false);
			firstFrame.setVisible(true);
		}
		if (e.getActionCommand().equals(d2_bOK2.getLabel())) {
			d2_joinFail.dispose();
		}
		if (e.getActionCommand().equals(mf_pH_bReser.getLabel())) {
			System.out.println("reservation!!");
		}
		if (e.getActionCommand().equals(mf_pM_bHome.getLabel())) {
			mf_pHome.setVisible(true);
			mf_pRecord.setVisible(false);
			mf_pStat.setVisible(false);
			mf_pVideo.setVisible(false);
			mf_pMap.setVisible(false);
		}
		if (e.getActionCommand().equals(mf_pM_bRecord.getLabel())) {
			mf_pHome.setVisible(false);
			mf_pRecord.setVisible(true);
			mf_pStat.setVisible(false);
			mf_pVideo.setVisible(false);
			mf_pMap.setVisible(false);
		}
		if (e.getActionCommand().equals(mf_pM_bStats.getLabel())) {
			mf_pHome.setVisible(false);
			mf_pRecord.setVisible(false);
			mf_pStat.setVisible(true);
			mf_pVideo.setVisible(false);
			mf_pMap.setVisible(false);
		}
		if (e.getActionCommand().equals(mf_pM_bSwing.getLabel())) {
			mf_pHome.setVisible(false);
			mf_pRecord.setVisible(false);
			mf_pStat.setVisible(false);
			mf_pVideo.setVisible(true);
			mf_pMap.setVisible(false);
		}
		if (e.getActionCommand().equals(mf_pM_bMap.getLabel())) {
			mf_pHome.setVisible(false);
			mf_pRecord.setVisible(false);
			mf_pStat.setVisible(false);
			mf_pVideo.setVisible(false);
			mf_pMap.setVisible(true);
		}
		if (e.getActionCommand().equals(d3_idchk_bok.getLabel())) {
			d3_jf_idchk_ok.dispose();
		}
		if (e.getActionCommand().equals(d3_idchk_bno.getLabel())) {
			d3_jf_idchk_no.dispose();
		}
		if (e.getActionCommand().equals(jf_bPWDchk.getLabel())) {
			if (jf_tPwd.getText().equals(jf_tRepwd.getText())) {
				System.out.println("good");
				d3_jf_pwdchk_ok.setVisible(true);
			} else {
				System.out.println("retry");
				d3_jf_pwdchk_no.setVisible(true);
				jf_tPwd.setText("");
				jf_tRepwd.setText("");
			}
		}

		if (e.getActionCommand().equals(d3_pwdchk_bok.getLabel())) {
			d3_jf_pwdchk_ok.dispose();
		}

		if (e.getActionCommand().equals(d3_pwdchk_bno.getLabel())) {
			d3_jf_pwdchk_no.dispose();
		}
		if (e.getActionCommand().equals(d3_joinComplet_bok.getLabel())) {
			d3_jf_joinComplet.dispose();
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		MainUI green = new MainUI();
		green.startFrame();
	}
}