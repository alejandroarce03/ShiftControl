package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import customExceptions.RequiredFieldsException;
import customExceptions.TypeOfDocumentImproperException;
import customExceptions.UserExistException;

public class ShiftControler implements Serializable{
//Attributes
	private ArrayList<User> users;
	private ArrayList<Shift> shifts;
	private ArrayList<ShiftType> shiftTypes;
	private int nOne=0;
	private int nTwo=0;
	private char[] letters = new char[26];
	private int k=0;
	private DateAndTime date;
	private ArrayList<Shift> presentUsers;
	public String data="\\data\\serializable.aar";
//Methods
	public ShiftControler() {
		users = new ArrayList<User>();
		shifts = new ArrayList<Shift>();
		shiftTypes = new ArrayList<ShiftType>();
		date = new DateAndTime();
	}
	@SuppressWarnings("unchecked")
	public String assignShifts(String id,String type) throws IOException {
		String numberShift=""; 
		LocalDateTime t = LocalDateTime.now();
		boolean cont=false;
		boolean p = false;
		boolean status=true;
		boolean typeExist= false;
		boolean person = false;
		Shift shift;
		ShiftType s = null;
		int b=0;
		for( b=0;b<shiftTypes.size() && !typeExist;b++) {
			if(shiftTypes.get(b).getName().equalsIgnoreCase(type)) {
				typeExist=true;
				s=shiftTypes.get(b);
			}
		}
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
		for(int w=0;w<10 && !cont && typeExist;w++) {
				for(int j=0;j<10 && !cont ;j++) {
						shift= new Shift(letters[k],Integer.toString(nOne),Integer.toString(nTwo),status,s,t,person);
				
						shift.getUsers().add(id);
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
	public User addUser(String name,String lastname,String id,int type,String phone,String adress) throws RequiredFieldsException, TypeOfDocumentImproperException, IOException {
		if(name.equalsIgnoreCase("") || id.equalsIgnoreCase("") || type==0) {
			throw new RequiredFieldsException();
		}
		String document="";
		switch(type) {
		case 1: document="Identification card";
		break;
		case 2: document="Identy card";
		break;
		case 3: document="Civil registration";
		break;
		case 4: document="Foreigner id";
		break;
		case 5: document="Passport";
		break;
		default: 
			throw new TypeOfDocumentImproperException(document);
		}
		boolean pre=false;
		User user = new User(name,lastname,document,id,phone,adress,pre);
	
		users.add(user);
		
		return user;
	}
	@SuppressWarnings("unchecked")
	public String registerShifts(String id,String type) throws IOException {
		String msg = "";
		boolean cont=false;
		int faults=0;
		int i=0;
		for( i=0;i<users.size() && !cont;i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				for(int y=0;y<shifts.size();y++) {
					if(shifts.get(i).getId().equalsIgnoreCase(id)) {
						if(shifts.get(i).getPerson()) {
						faults++;
						}
					}
					
				}
				if(faults<=2) {
				cont =true;
				users.get(i).setShift(assignShifts(id,type));
				msg = "The id is registred, your turn is "+users.get(i).getShift();
				users.get(i).getShifts().add(users.get(i).getShift());
				}else {
					msg="the user has a fault for two days for not being present on the shift";
				}
			}else {
				msg = "The id is not registred, Enter 1 to register";
			}
		}
		for( i=0;i<users.size();i++) {
		sortAllShifts(users.get(i).getShifts());
		}
					
		return msg;
	}
	public User searchUser(String id)throws UserExistException {
		sortUsers();
		int max = users.size()-1;
		int min = 0;
		int index=0;
			 while (min <= max) {
			        int mid = (min + max) / 2;
			        if (users.get(mid).getId().compareTo(id) < 0) {
			            min = mid + 1;
			        } else if (users.get(mid).getId().compareTo(id) > 0) {
			            max = mid - 1;
			        } else if (users.get(mid).getId().compareTo(id) == 0) {
			            index = mid;
			            break;
			        }
		}
			return users.get(index);
	}
	public void sortUsers() {
		for(int w=0;w<users.size()-1;w++) {
			int temp=w;
			User menor= users.get(w);
			
			
			for(int j=w+1;j<users.size();j++) {
				if(users.get(j).getName().compareTo(menor.getName())<0) {
					menor=users.get(j);
					temp=j;
				}
			}
			User u = users.get(w);
			User te = users.get(temp);
				User n= u;
				u= menor;
				te = n;
		}
	}
	
	public int attendShift() {
		LocalDateTime n = LocalDateTime.now();
		LocalDateTime rest;
		int numOfShifts = 0;
		presentUsers = new ArrayList<Shift>();
	
		for(int i=0;i<shifts.size();i++) {
		System.out.println("entra");
			
			if(!shifts.get(i).getStatus()) {
				System.out.println(shifts.get(i).getTime());
				rest=shifts.get(i).getTime().plusMinutes(shifts.get(i).getType().getTime());
				rest.plusSeconds(15);
				System.out.println("rest:"+rest);
				System.out.println("n: "+n);
				if(n.isAfter(rest)) {
					System.out.println(shifts.get(i).getStatus());
					shifts.get(i).setStatus(false);
					System.out.println(shifts.get(i).getStatus());
					
					presentUsers.add(shifts.get(i));
					numOfShifts++;
					 
				}
				if(i+1<shifts.size()) {
					rest.plusMinutes(shifts.get(i+1).getType().getTime());
					if(n.isAfter(rest)) {
						
						shifts.get(i+1).setStatus(false);
						presentUsers.add(shifts.get(i));
						numOfShifts++;
						
						 
					}
				}
				System.out.println(shifts.get(i).getStatus());
				i++;
			}
			System.out.println(shifts.get(i).getStatus());
		
		}
		
		return numOfShifts;
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
	public ArrayList<User> getUsers(){
		return users;
	}
	public ArrayList<Shift> getShifts(){
		return shifts;
	}
	public ShiftType createShiftType(String name,double time) throws IOException {
		long timeMinutes = (new Double(time)).longValue();
		ShiftType shiftType = new ShiftType(name,timeMinutes);
	
			shiftTypes.add(shiftType);
		return shiftType;
	}
	public LocalDateTime time() {
		 
		return date.refreshTime();
	}
	public DateAndTime getDate() {
		return date;
	}
	public boolean presentUser(String a,int i) {
		boolean p=false;
		for( int j=0;j<presentUsers.size();j++) {
			
			if(a.equalsIgnoreCase("yes")){
				p=true;
				if(j==i) {
				presentUsers.get(j).setStatus(p);
				presentUsers.get(i).setPersonPresent(true);
				}
			}
		}
		return p;
	}
	public ArrayList<Shift> sortAllShifts(ArrayList<Shift> p) {
		for(int i=p.size();i>0;i--) {
			
			for(int j=0;j<i-1;j++) {
				
				if(p.get(j+1).getShift().compareTo(p.get(j).getShift())<0) {
					Shift shift2 = p.get(j+1);
					Shift shift1 = p.get(j);
					Shift temp = shift2;
					shift2= shift1;
					shift1 = temp;
				}
			}
		}
		return p;
	}
	public String reportAllShifts(String id) {
		String ms = "";
		boolean c=false;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equalsIgnoreCase(id)) {
				ms+="User: "+users.get(i).getId()+"\n";
				for(int j=0;j<users.get(i).getShifts().size();j++) {
					ms+=users.get(i).getShifts().get(j).toString()+" ";
					for(int w=0;w<shifts.size() && !c;w++) {
						if(shifts.get(i).getId().equalsIgnoreCase(id)) {
							ms+="Was the user: "+shifts.get(i).getStatus();
							c=true;
						}
					}
				}
			}
		}
			return ms;
	}
	public ArrayList<String> sortUsersWithThisShift(ArrayList<String> u){
		for(int i=1;i<u.size();i++) {
			for(int j=1; j>0 &&   u.get(j).compareTo(u.get(j-1))<0;j--) {
				String u1=u.get(j);
				String u2=u.get(j-1);
				String temp = u1;
				u1 = u2;
				u2 = temp;
			}
		}
		return u;
	}
	public String reportShiftWithUsers(String nameShift) {
		String msg ="";
		for(int i=0;i<shifts.size();i++) {
			
			if(shifts.get(i).getShift().equalsIgnoreCase(nameShift)) {
				msg="Shift: "+shifts.get(i).getShift()+"\n";
				sortUsersWithThisShift(shifts.get(i).getUsers());
				for(int j=0;j<shifts.get(i).getUsers().size();j++) {
					msg+="have been this user: "+shifts.get(i).getUsers().get(j);
				}
			}
		}
		return msg;
	}
	public void generateNames() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\aleja\\Downloads\\ShiftControl-master\\ShiftControl-master\\ShiftControl\\data\\names.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\aleja\\Downloads\\ShiftControl-master\\ShiftControl-master\\ShiftControl\\data\\lastnames.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\aleja\\Downloads\\ShiftControl-master\\ShiftControl-master\\ShiftControl\\data\\generated.txt"));
		PrintWriter pw = new PrintWriter("C:\\Users\\aleja\\Downloads\\ShiftControl-master\\ShiftControl-master\\ShiftControl\\data\\generated.txt");
		String[] names = null;
		String[] last = null;
		String lineN;
		String lineL;
		while((lineN= br.readLine())!=null) {
			names = lineN.split("(?=[A-Z])");
			
		}
		while((lineL= br2.readLine())!=null) {
			last = lineL.split("(?=[A-Z])");
			
		}
		for(int i=0;i<names.length;i++) {
			System.out.println(last[i]);
			System.out.println(names[i]);
		}
		br.close();
		br2.close();
		Random r = new Random();
		for(int i=names.length;i<0;i--) {
			int index1=(int)(r.nextDouble()*names.length+0);
			String name=names[index1];
			int index2=(int)(r.nextDouble()*last.length+0);
			String lastname=last[index2];
			String sum = name+" "+lastname;
			bw.write(sum+"\n");
			pw.print(sum+"\n");
		}
		for(int i=names.length;i<0;i--) {
			int index1=(int)(r.nextDouble()*names.length+0);
			String name=names[index1];
			int index =(int)(r.nextDouble()*names.length+0);
			String name2 = names[index];
			int index2=(int)(r.nextDouble()*last.length+0);
			String lastname=last[index2];
			String sum = name+" "+name2+" "+lastname;
			bw.write(sum+"\n");
			
		}
		
		bw.close();
		
		
		
	}


}

