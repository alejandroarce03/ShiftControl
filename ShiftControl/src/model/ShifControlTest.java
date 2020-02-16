package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import customExceptions.RequiredFieldsException;

class ShifControlTest {
	private ArrayList<Shift> shifts;
	private ArrayList<User> users;
	private ShiftControler s;
	
	public void setup1() {
		shifts = new ArrayList<Shift>();
		users = new ArrayList<User>();
		s = new ShiftControler();
	}
	

	@Test
	public void testArrayList() {
		setup1();
		assertEquals("The shifts have not been created correctly",s.getShifts(),shifts);
		assertEquals("The users have not been created correctly",s.getUsers(),users);
	}
	public void testAddUser() {
		setup1();
		try {
			assertEquals("The user has not been created in the system",s.addUser("Alejo","29899556","identification card", "3348765", "calle 5#56"),s.getUsers().get(0));
		} catch (RequiredFieldsException e) {
			e.printStackTrace();
		}
		
	}

}
