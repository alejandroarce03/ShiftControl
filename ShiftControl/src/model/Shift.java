package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Shift implements Serializable{
//Attributes
	private String numberOne;
	private char letter;
	private boolean status;
	private String numberTwo;
	private String id;
	private ShiftType type;
	private LocalDateTime timeWhenCreateTurn;
	private boolean personPresent;
	private ArrayList<String> usersWithThisShift;
//Methods
	public Shift(char l,String nOne,String nTwo,boolean s,ShiftType typeShift,LocalDateTime time,boolean person) {
		numberOne=nOne;
		numberTwo=nTwo;
		letter=l;
		status=s;
		type=typeShift;
		timeWhenCreateTurn=time;
		personPresent = person;
		usersWithThisShift = new ArrayList<String>();
	}
	public String getShift() {
		String msg="";
		msg= String.valueOf(letter)+numberOne+numberTwo;
		
		return msg;
	}
	public void setId(String identification) {
		id = identification;
	}
	public String getId() {
		return id;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean s) {
		status=s;
	}
	public ShiftType getType() {
		return type;
	}
	public LocalDateTime getTime() {
	    return timeWhenCreateTurn;
	}
	public void setPersonPresent(boolean p) {
		personPresent = p;
	}
	public boolean getPerson() {
		return personPresent;
	}
	public ArrayList<String> getUsers() {
		return usersWithThisShift;
	}
}
