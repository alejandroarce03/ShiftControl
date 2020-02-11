package ui;

import java.util.Scanner;

import model.Shift;
import model.ShiftControler;

public class Main {
//Attributes
	private static  Scanner lector;
	private static Main main;
	private ShiftControler system;
//Methods
	public Main() {
		lector = new Scanner(System.in);
		system = new ShiftControler();
	}
	public static void main(String args[]) {
		main = new Main();
		int i=0;
		do {
		 i = lector.nextInt();
		}while(i!=2);
	}
	public void menu() {
		int option=0;
		System.out.println("MENU");
	}
}
