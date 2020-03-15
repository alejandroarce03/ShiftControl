package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateAndTime implements Serializable{

	private LocalDateTime actual;
	
	public DateAndTime() {
		actual=LocalDateTime.now();
	}
	public LocalDateTime refreshTime() {
		actual=LocalDateTime.now();
		return actual;
	}
	public LocalDateTime getActual() {
		return actual;
	}
}
