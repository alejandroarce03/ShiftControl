package ui;

import java.util.Scanner;

import customExceptions.RequiredFieldsException;
import customExceptions.TypeOfDocumentImproperException;
import customExceptions.UserExistException;
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
			try {
		System.out.println("MENU");
		System.out.println("1. Register user");
		System.out.println("2. Assign Shift");
		System.out.println("3. Attend shift");
		System.out.println("4. Exit");
		option = Integer.parseInt(lector.nextLine());
		switch(option) {
		case 1: 
			System.out.print("Enter Complete name: ");
			String name = lector.nextLine();
			System.out.print("Enter type of id(IDENTIFICATION_CARD,IDENTY_CARD,PASSPORT,CIVIL_REGISTRATION,FOREIGNER_ID): ");
			String type = lector.nextLine();
			System.out.print("Enter Id: ");
			try {
				system.typeDocument(type);
				String id = lector.nextLine();
				try {
					system.searchUser(id);
					System.out.print("Enter phone number: ");
					String phone = lector.nextLine();
					System.out.print("Enter adress: ");
					String adress = lector.nextLine();
					try {
						system.addUser(name, id, type, phone, adress);
						System.out.println("The user has been registred successfully");
					} catch (RequiredFieldsException e) {
				
						System.out.println(e.getMessage());
					}
				} catch (UserExistException e1) {
					System.out.println(e1.getMessage());
			
				}
				
			} catch (TypeOfDocumentImproperException e2) {
				System.out.println(e2.getMessage());
			}
			
			
			
		break;
		case 2:
			System.out.print("Enter the id: ");
			String idSearch = lector.nextLine();
			String m = system.checkAttendShift(idSearch);
			if(!m.equalsIgnoreCase("")) {
			System.out.println(m);
			}else {
				System.out.println(system.registerShifts(idSearch));
			}
		break;
		case 3:
			String msg =system.attendShift();
			if(msg.equalsIgnoreCase(".")) {
				System.out.println("No turns to atend");
			}else
			System.out.println(msg);
			
		}
			}catch(NumberFormatException n) {
				System.out.println("Error choosing option, please use numbers");
			}
		
	}while(option!=4);
  }
}
