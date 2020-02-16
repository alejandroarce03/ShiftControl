package model;

public class User {
//Constants
	public static final String IDENTIFICATION_CARD="Identification card";
	public static final String IDENTY_CARD="Identy card";
	public static final String PASSPORT="Passport";
	public static final String CIVIL_REGISTRATION="Civil registration";
	public static final String FOREIGNER_ID = "Foreigner id";
//Attributes
	private String name;
	private String typeId;
	private String  id;
	private String phone;
	private String adress;
	private String shift;
//Methods
	public User(String n,String t,String i) {
		name=n;
		typeId=t;
		id=i;

	}
	public void setAdress(String a) {
		adress=a;
	}
	public void setPhone(String p) {
		phone=p;
	}
	public String getName() {
		return name;
	}
	public String getTypeId() {
		return typeId;
	}
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setShift(String s) {
		shift = s;
		
	}
	public String getShift() {
		return shift;
	}

}
