package greenAcademiGolf;

public class MemberVO {

	private String mem_id;
	private String mem_nickname;
	private String mem_email;
	private String mem_pwd;

	public MemberVO() {

	}

	public MemberVO(String mem_id, String mem_nickname, String mem_email, String mem_pwd) {
		this.mem_id = mem_id;
		this.mem_nickname = mem_nickname;
		this.mem_email = mem_email;
		this.mem_pwd = mem_pwd;
	}

	public String getMem_id() {
		return mem_id;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public String getMem_email() {
		return mem_email;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}
}