package greenAcademiGolf;

public class BoxStateVO {

	private int box_no;
	private String mem_nickname;
	private String start_time;
	private String wait_mem;

	public BoxStateVO() {

	}

	public BoxStateVO(int box_no, String mem_nickname, String start_time, String wait_mem) {
		this.box_no = box_no;
		this.mem_nickname = mem_nickname;
		this.start_time = start_time;
		this.wait_mem = wait_mem;
	}

	public int getBox_no() {
		return box_no;
	}

	public void setBox_no(int box_no) {
		this.box_no = box_no;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getWait_mem() {
		return wait_mem;
	}

	public void setWait_mem(String wait_mem) {
		this.wait_mem = wait_mem;
	}
}
