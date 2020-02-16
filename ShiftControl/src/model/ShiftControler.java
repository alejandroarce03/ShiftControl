package model;

import java.util.ArrayList;

import customExceptions.RequiredFieldsException;
import customExceptions.TypeOfDocumentImproperException;
import customExceptions.UserExistException;

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
		boolean status=true;
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
	public void alphabet() {
		for(int e=0;e<letters.length;e++) {
			letters[e]=(char)('A'+e);
		}
		
	}
	public User addUser(String name,String id,String type,String phone,String adress) throws RequiredFieldsException {
		if(name.equalsIgnoreCase("") || id.equalsIgnoreCase("") || type.equalsIgnoreCase("")) {
			throw new RequiredFieldsException();
		}
		User user = new User(name,type,id,phone,adress);
		users.add(user);
		return user;
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
	public void searchUser(String id)throws UserExistException {
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				throw new UserExistException();
			}
				
		}
	}
	public String checkAttendShift(String id) {
		String msg="";
		boolean cont=false;
		for(int i=0;i<shifts.size();i++) {
			System.out.println("hola mundo");
			if(shifts.get(i).getId().equalsIgnoreCase(id)) {
				if((shifts.get(i).getStatus()));
				System.out.println("hola mundo");
					msg="Your turn has not been attended yet";
					cont=true;
			}
		}
		return msg;
	}
	public String attendShift() {
		String msg=".";
		boolean attend=false;
		boolean cont=false;
		for(int i=0;i<shifts.size();i++) {
			System.out.println("entra");
			if(shifts.get(i).getStatus() && shifts.get(i).getId()!=null) {
				shifts.get(i).setStatus(attend);
				msg="Turn "+shifts.get(i).getShift()+" user: "+ nameOfUser(shifts.get(i).getId());
				cont = true;
			}
		}
		return msg;
	}
	public String nameOfUser(String id) {
		String name="";
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				name=users.get(i).getName();
			}
		}
		return name;
	}
	public String typeDocument(String type)throws TypeOfDocumentImproperException{
		String msg="";
		if(type.equalsIgnoreCase("Identification card") || type.equalsIgnoreCase("Identy card") || type.equalsIgnoreCase("Passport") || type.equalsIgnoreCase("Civil registration") || type.equalsIgnoreCase("Foreigner id")) {
			msg="The type is correct";
		}else
			throw new TypeOfDocumentImproperException(type);
		return msg;
	}
	public ArrayList<User> getUsers(){
		return users;
	}
	public ArrayList<Shift> getShifts(){
		return shifts;
	}
}

