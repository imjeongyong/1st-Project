package greenAcademiGolf;

public class SwingDataVO {

	private int swing_number;
	private String swing_date;
	private String club;
	private int ballSpeed;
	private int carry;
	private String path;
	private String face;
	private String shot;

	SwingDataVO() {

	}

	SwingDataVO(int swing_number, String swing_date, String club, int ballSpeed, int carry, String path, String face,
			String shot) {
		this.swing_number = swing_number;
		this.swing_date = swing_date;
		this.club = club;
		this.ballSpeed = ballSpeed;
		this.carry = carry;
		this.path = path;
		this.face = face;
		this.shot = shot;
	}

	public int getSwing_number() {
		return swing_number;
	}

	public String getSwing_date() {
		return swing_date;
	}

	public String getClub() {
		return club;
	}

	public int getBallSpeed() {
		return ballSpeed;
	}

	public int getCarry() {
		return carry;
	}

	public String getPath() {
		return path;
	}

	public String getFace() {
		return face;
	}

	public String getShot() {
		return shot;
	}
}
