package model;

import java.util.ArrayList;

public class ShiftControler {
//Attributes
	private ArrayList<User> users;
	private ArrayList<Shift> shifts;
	private int nOne=0;
	private int nTwo=0;
	private char[] letters = new char[26];
	private int k=0;
//Methods
	public ShiftControler() {
		users = new ArrayList<User>();
		shifts = new ArrayList<Shift>();
	}
	public void assignShifts() {
		boolean cont=false;
		boolean p = false;
		boolean status=false;
		Shift shift;
		if(nOne==10) {
			nOne=0;
			nTwo=0;
			k++;
		}
		for(int w=0;w<10 && !cont;w++) {
				for(int j=0;j<10 && !cont;j++) {
						shift= new Shift(letters[k],Integer.toString(nOne),Integer.toString(nTwo),status);
						cont=true;
						nTwo++;
					}
					if(nTwo==10) {
						nTwo=0;
						nOne++;
					}
				}
	}
	public void abecedario() {
		for(int e=0;e<letters.length;e++) {
			letters[e]=(char)('A'+e);
		}
		
	}
	public void addUser(String name,String id,String type,String phone,String adress) {
		Shift shift=null;
		User user = new User(name,type,id,phone,adress,shift);
		users.add(user);
	}
	public String registerShifts(String id) {
		String msg = "";
		boolean cont=false;
		for(int i=0;i<users.size() && !cont;i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				cont =true;
				msg = "The id is registred";
			}
		}
		return msg;
	}
}
