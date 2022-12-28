package greenAcademiGolf;

public class MemberVo {
	private String mem_id;
	private String mem_name;
	private String mem_email;
	private String mem_pwd;

	public MemberVo() {

	}

	public MemberVo(String mem_id, String mem_name, String mem_email, String mem_pwd) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.mem_pwd = mem_pwd;
	}

	public String getMem_id() {
		return mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public String getMem_email() {
		return mem_email;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}
}