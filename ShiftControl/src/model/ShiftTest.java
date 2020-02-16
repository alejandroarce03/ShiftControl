package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShiftTest {
	private Shift s;

	public void setup1() {
		char letter = 'A';
		String nOne = "7";
		String nTwo = "8";
		boolean status = true;
		s = new Shift(letter,nOne,nTwo,status);
	}
	@Test
	public void testShift() {
		setup1();
		assertEquals("The shift has not been created correctly",s.getShift(),"A78");
		assertEquals("The status has not been created correctly",s.getStatus(),true);
		assertEquals("The status has not been change correctly",s.getId(),null);
		
	}

}
