package greenAcademiGolf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##green1234";
	String password = "0000";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	// **로그인 시도 메서드**
	public ArrayList<MemberVo> tryLogin(String inp_mem_id) {
		ArrayList<MemberVo> tryLogin = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM MEMBERSHIP";
			if (inp_mem_id != null) {
				query += " where mem_id='" + inp_mem_id + "'";
			}
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
					String mem_name = rs.getString("MEM_NAME");
					String mem_email = rs.getString("MEM_EMAIL");
					String mem_pwd = rs.getString("MEM_PWD");

					MemberVo data = new MemberVo(mem_id, mem_name, mem_email, mem_pwd);
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
			connDB();

			String query = "SELECT * FROM MEMBERSHIP";
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
	public void joinMembership(String mem_id, String mem_name, String mem_email, String mem_pwd) {
		try {
			connDB();
			String query = "INSERT INTO MEMBERSHIP VALUES ('" + mem_id + "', '" + mem_name + "', '" + mem_email + "', '"
					+ mem_pwd + "' )";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
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