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
		main.menu();
	}
	public void menu() {
		system.abecedario();
		int option=0;
		do {
		System.out.println("MENU");
		System.out.println("1. Register user");
		System.out.println("2. AssignShift");
		option = Integer.parseInt(lector.nextLine());
		switch(option) {
		case 1: 
			System.out.print("Enter Complete name: ");
			String name = lector.nextLine();
			System.out.print("Enter type of id(IDENTIFICATION_CARD,IDENTY_CARD,PASSPORT,CIVIL_REGISTRATION,FOREIGNER_ID): ");
			String type = lector.nextLine();
			System.out.print("Enter Id: ");
			String id = lector.nextLine();
			if(system.searchUser(id)) {
				System.out.print("The id is already registred");
			}else {
			System.out.print("Enter phone number: ");
			String phone = lector.nextLine();
			System.out.print("Enter adress: ");
			String adress = lector.nextLine();
			system.addUser(name, id, type, phone, adress);
			System.out.print("The user has been registred successfully");
			}
		break;
		case 2:
			System.out.print("Enter the id: ");
			String idSearch = lector.nextLine();
			String m = system.registerShifts(idSearch);
			if(m==null) {
				System.out.println("The id is not registred");
				System.out.println("Enter number 1 to register");
			}else {
				system.registerShifts(idSearch);
			}
		}
		
	}while(option!=5);
  }
}
