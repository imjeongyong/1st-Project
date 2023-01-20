package greenAcademiGolf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GreenDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##firstproj";
	String password = "0000";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	// **로그인 메서드**
	public ArrayList<MemberVO> tryLogin(String id, String pwd) {
		ArrayList<MemberVO> tryLogin = new ArrayList<MemberVO>();

		try {
			String query = "SELECT * FROM GREEN_MEMBERSHIP where mem_id='" + id + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String mem_id = rs.getString("MEM_ID");
					String mem_nickname = rs.getString("MEM_NICKNAME");
					String mem_email = rs.getString("MEM_EMAIL");
					String mem_pwd = rs.getString("MEM_PWD");

					MemberVO data = new MemberVO(mem_id, mem_nickname, mem_email, mem_pwd);
					tryLogin.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tryLogin;
	}

	// **회원가입 IDchk 메서드**
	public boolean idChk(String newID) {
		Boolean chk = false;
		try {
			String query = "SELECT * FROM GREEN_MEMBERSHIP";
			if (newID != null) {
				query += " where mem_id='" + newID + "'";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("join ok");
				chk = true;
			} else {
				System.out.println("duplicated id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chk;
	}

	// **회원가입 메서드**
	public void joinMembership(String mem_id, String mem_nickname, String mem_email, String mem_pwd) {
		try {
			String query = "INSERT INTO GREEN_MEMBERSHIP VALUES ('" + mem_id + "', '" + mem_nickname + "', '"
					+ mem_email + "', '" + mem_pwd + "' )";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **회원가입 -> USER_STATE 테이블 레코드 입력 메서드**
	public void ins_record1(String mem_id, String mem_nickname) {
		try {
			String query = "INSERT INTO USER_STATE VALUES ('" + mem_id + "', '" + mem_nickname + "' , 0, 0, '')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createData(String mem_id) { // 회원가입 -> ID_DATA 테이블 생성
		try {
			String query = "CREATE TABLE " + mem_id.toString()
					+ "_DATA ( MEM_ID VARCHAR2(30), SWING_NUMBER INT NOT NULL, SWING_DATE VARCHAR2(30) NOT NULL, CLUB VARCHAR2(30) NOT NULL, BALLSPEED INT NOT NULL, CARRY INT NOT NULL, PATH VARCHAR2(30), FACE VARCHAR2(30) NOT NULL, SHOT VARCHAR2(30) NOT NULL, PRIMARY KEY(SWING_NUMBER))";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(String mem_id) { // 회원가입 -> ID_DATA 테이블 생성
		try {

			String query = "INSERT INTO " + mem_id.toUpperCase() + "_DATA VALUES('" + mem_id.toUpperCase()
					+ "', 0, TO_CHAR(SYSDATE, 'YY-MM-DD'), '테스트' ,0, 0, '입니다', '테스트요', '아직')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **ID 찾기 메서드**
	public ArrayList<MemberVO> searchID(String nickname, String email) {
		ArrayList<MemberVO> searchID = new ArrayList<MemberVO>();

		try {
			String query = "SELECT * FROM GREEN_MEMBERSHIP WHERE MEM_NICKNAME='" + nickname + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String mem_id = rs.getString("MEM_ID");
					String mem_nickname = rs.getString("MEM_NICKNAME");
					String mem_email = rs.getString("MEM_EMAIL");
					String mem_pwd = rs.getString("MEM_PWD");

					MemberVO data = new MemberVO(mem_id, mem_nickname, mem_email, mem_pwd);
					searchID.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchID;
	}

	// **PWD 찾기 메서드**
	public ArrayList<MemberVO> searchPwd(String id, String email) {
		ArrayList<MemberVO> searchPwd = new ArrayList<MemberVO>();

		try {
			String query = "SELECT * FROM GREEN_MEMBERSHIP where mem_id='" + id + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String mem_id = rs.getString("MEM_ID");
					String mem_nickname = rs.getString("MEM_NICKNAME");
					String mem_email = rs.getString("MEM_EMAIL");
					String mem_pwd = rs.getString("MEM_PWD");

					MemberVO data = new MemberVO(mem_id, mem_nickname, mem_email, mem_pwd);
					searchPwd.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchPwd;
	}

//	 **USER_STATE 레코드 정보 가져오기 메서드**
	public ArrayList<UserStateVO> currentState(String id) {
		ArrayList<UserStateVO> currentState = new ArrayList<UserStateVO>();

		try {
			String query = "SELECT * FROM USER_STATE WHERE MEM_ID = '" + id + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String mem_id = rs.getString("MEM_ID");
					String mem_nickname = rs.getString("MEM_NICKNAME");
					int current_state = rs.getInt("CURRENT_STATE");
					int box_no = rs.getInt("BOX_NO");
					String enter_time = rs.getString("ENTER_TIME");

					UserStateVO data = new UserStateVO(mem_id, mem_nickname, current_state, box_no, enter_time);
					currentState.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentState;
	}

//	 **BOX_STATE 레코드 정보 가져오기 메서드**
	public ArrayList<BoxStateVO> boxState(int number) {
		ArrayList<BoxStateVO> boxState = new ArrayList<BoxStateVO>();

		try {
			String query = "SELECT * FROM BOX_STATE WHERE BOX_NO ='" + number + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					int box_no = rs.getInt("BOX_NO");
					String mem_nickname = rs.getString("MEM_NICKNAME");
					if (mem_nickname == null) {
						mem_nickname = "0";
					}
					String start_time = rs.getString("START_TIME");
					String wait_mem = rs.getString("WAIT_MEM");

					BoxStateVO data = new BoxStateVO(box_no, mem_nickname, start_time, wait_mem);
					boxState.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boxState;
	}

	// **Tab_enter -> 입장하기 버튼 -> USER_STATE 레코드 수정**

	public void enterance1(String mem_id, String mem_nickname, int box_no) {
		try {
			String query = "UPDATE USER_STATE SET CURRENT_STATE = 1, BOX_NO = " + box_no
					+ ", ENTER_TIME = TO_CHAR(SYSDATE, 'HH24:MI') WHERE MEM_ID ='" + mem_id + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **Tab_enter -> 입장하기 버튼 -> 사용시간 종료 -> USER_STATE 레코드 수정**

	public void exit1(String mem_id, String mem_nickname, int box_no) {
		try {
			String query = "UPDATE USER_STATE SET CURRENT_STATE = 0, BOX_NO = 0, ENTER_TIME = NULL WHERE MEM_ID ='"
					+ mem_id + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **Tab_enter -> 입장하기 버튼 -> BOX_STATE 레코드 수정**

	public void enterance2(String mem_nickname, int box_no) {
		try {
			String query = "UPDATE BOX_STATE SET MEM_NICKNAME = '" + mem_nickname
					+ "',START_TIME = TO_CHAR(SYSDATE, 'HH24:MI'), WAIT_MEM =''WHERE BOX_NO = " + box_no;
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exit2(String mem_nickname, int box_no) {
		try {
			String query = "UPDATE BOX_STATE SET MEM_NICKNAME = '', START_TIME = '0', WAIT_MEM =''WHERE BOX_NO = "
					+ box_no;
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String printState3(String id) { // main 상태창에서 평균 구질
		String shotType = "";
		try {
			String query = "SELECT SHOT, COUNT(*) FROM " + id.toUpperCase()
					+ "_DATA GROUP BY SHOT ORDER BY COUNT(*) DESC";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.next();
			shotType = rs.getString("SHOT");
		} catch (Exception e) {
			e.printStackTrace();
			return shotType;
		}
		return shotType;
	}

	// **Card_record -> 기록버튼 -> '아이디'_DATA 레코드 삽입**

	public void inputRecord(String id, String club, int ballSpeed, int carry, String path, String face, String shot) {
		try {
			String query = "SELECT MAX(SWING_NUMBER) FROM " + id + "_DATA";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.next();
			int max = rs.getInt(1) + 1;
			System.out.println(max);

			String query1 = "INSERT INTO " + id.toUpperCase() + "_DATA VALUES('" + id.toUpperCase() + "', " + max
					+ ", TO_CHAR(SYSDATE, 'YY-MM-DD'), '" + club + "' ," + ballSpeed + ", " + carry + ", '" + path
					+ "', '" + face + "', '" + shot + "')";

			System.out.println(query1);
			rs = stmt.executeQuery(query1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<SwingDataVO> viewAll(String id) {
		ArrayList<SwingDataVO> list = new ArrayList<SwingDataVO>();
		try {

			String query = "SELECT * FROM " + id.toUpperCase() + "_DATA ORDER BY SWING_NUMBER DESC";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int swing_number = rs.getInt("SWING_NUMBER");
				String swing_date = rs.getString("SWING_DATE");
				String club = rs.getString("CLUB");
				int ballSpeed = rs.getInt("BALLSPEED");
				int carry = rs.getInt("CARRY");
				String path = rs.getString("PATH");
				String face = rs.getString("FACE");
				String shot = rs.getString("SHOT");
				list.add(new SwingDataVO(swing_number, swing_date, club, ballSpeed, carry, path, face, shot));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public ArrayList<SwingDataVO> viewClub(String id, String clubType) { // 클럽별 기록보기
		ArrayList<SwingDataVO> list = new ArrayList<SwingDataVO>();
		try {

			String query = "SELECT * FROM " + id.toUpperCase() + "_DATA WHERE CLUB = '" + clubType
					+ "' ORDER BY SWING_NUMBER DESC";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int swing_number = rs.getInt("SWING_NUMBER");
				String swing_date = rs.getString("SWING_DATE");
				String club = rs.getString("CLUB");
				int ballSpeed = rs.getInt("BALLSPEED");
				int carry = rs.getInt("CARRY");
				String path = rs.getString("PATH");
				String face = rs.getString("FACE");
				String shot = rs.getString("SHOT");
				list.add(new SwingDataVO(swing_number, swing_date, club, ballSpeed, carry, path, face, shot));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("orcle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
