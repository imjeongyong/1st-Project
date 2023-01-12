package greenAcademiGolf;

public class UserStateVO {
	private String mem_id;
	private String mem_nickname;
	private int current_state;
	private int box_no;
	private String enter_time;

	public UserStateVO() {

	}

	public UserStateVO(String mem_id, String mem_nickname, int current_state, int box_no, String enter_time) {
		this.mem_id = mem_id;
		this.mem_nickname = mem_nickname;
		this.current_state = current_state;
		this.box_no = box_no;
		this.enter_time = enter_time;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public int getCurrent_state() {
		return current_state;
	}

	public void setCurrent_state(int current_state) {
		this.current_state = current_state;
	}

	public int getBox_no() {
		return box_no;
	}

	public void setBox_no(int box_no) {
		this.box_no = box_no;
	}

	public String getEnter_time() {
		return enter_time;
	}

	public void setEnter_time(String enter_time) {
		this.enter_time = enter_time;
	}
}
