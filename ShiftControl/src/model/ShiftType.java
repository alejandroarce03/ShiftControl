package model;

import java.io.Serializable;

public class ShiftType implements Serializable{
	private String name;
	private long time;
	
	public ShiftType(String name, long time) {
		this.name=name;
		this.time=time;
	}
	public String getName() {
		return name;
	}
	public long getTime() {
		return time;
	}
}
