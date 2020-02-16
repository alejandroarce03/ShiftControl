package model;

public class Shift {
//Attributes
	private String numberOne;
	private char letter;
	private boolean status;
	private String numberTwo;
	private String id;
//Methods
	public Shift(char l,String nOne,String nTwo,boolean s) {
		numberOne=nOne;
		numberTwo=nTwo;
		letter=l;
		status=s;
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
	
}
