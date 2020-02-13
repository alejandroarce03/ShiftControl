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
	public String assignShifts(String id) {
		String numberShift=""; 
		boolean cont=false;
		boolean p = false;
		boolean status=false;
		Shift shift;
		if(k==25 && nOne==9 && nTwo==9 ) {
			k=0;
			nOne=0;
			nTwo=0;
		}
		if(nOne==10) {
			nOne=0;
			nTwo=0;
			k++;
		}
		for(int w=0;w<10 && !cont;w++) {
				for(int j=0;j<10 && !cont;j++) {
						shift= new Shift(letters[k],Integer.toString(nOne),Integer.toString(nTwo),status);
						shift.setId(id);
						shifts.add(shift);
						numberShift= shift.getShift();
						cont=true;
						nTwo++;
					}
					if(nTwo==10) {
						nTwo=0;
						nOne++;
					}
				}
		
		return numberShift;
	}
	public void abecedario() {
		for(int e=0;e<letters.length;e++) {
			letters[e]=(char)('A'+e);
		}
		
	}
	public void addUser(String name,String id,String type,String phone,String adress) {
		User user = new User(name,type,id,phone,adress);
		users.add(user);
	}
	public String registerShifts(String id) {
		String msg = "";
		boolean cont=false;
		int i=0;
		for( i=0;i<users.size() && !cont;i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				cont =true;
				users.get(i).setShift(assignShifts(id));
				msg = "The id is registred, your turn is "+users.get(i).getShift();
			}else {
				msg = "The id is not registred, Enter 1 to register";
			}
		}		
					
		return msg;
	}
	public boolean searchUser(String id) {
		boolean user=false;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				user=true;
			}
				
		}
		return user;
	}
	}

