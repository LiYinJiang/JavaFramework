package action;

import java.util.Date;

public class TimeAction {

	Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String show() {
		time = new Date();
		return "show";
	}
}
