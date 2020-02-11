package model;

public class User {
//Attributes
	private String name;
	private String typeId;
	private String  id;
	private String phone;
	private String adress;
	private Shift shift;
//Methods
	public User(String n,String t,String i, String p,String a,Shift sh) {
		name=n;
		typeId=t;
		id=i;
		phone=p;
		adress=a;
		shift=sh;
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
}
