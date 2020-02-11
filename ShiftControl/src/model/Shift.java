package model;

public class Shift {
//Attributes
	private String numberOne;
	private char letter;
	private boolean status;
	private String numberTwo;
//Methods
	public Shift(char l,String nOne,String nTwo,boolean s) {
		numberOne=nOne;
		numberTwo=nTwo;
		letter=l;
		status=s;
	}
	
}
