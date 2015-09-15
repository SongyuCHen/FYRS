package nju.software.fyrs.service.model;

public class Condition {
	public static int NORMAL = 0;
	public static int DATE = 1;
	
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
