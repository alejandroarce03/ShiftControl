package model;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import model.User;

class UserTest {
	private User user;

	public void setup1() {
		String name = "Alejandro Arce";
		String type = "identy card";
		String id = "1006908361";
		String phone = "31045647787";
		String adress = "Carrera 100 # 22-44";
		user = new User(name,type,id,phone,adress);
	}
	@Test
	public void testUser() {
		setup1();
		assertTrue("The name has not been created correctly",user.getName()=="Alejandro Arce");
		assertTrue("The type of document has not been created correctly",user.getTypeId()=="identy card");
		assertTrue("The id has not been created correctly",user.getId()=="1006908361");
		assertTrue("The phone number has not been created correctly",user.getPhone()=="31045647787");
		assertTrue("The adress has not been created correctly",user.getAdress()=="Carrera 100 # 22-44");
		
	}

}