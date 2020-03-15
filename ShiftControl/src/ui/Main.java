package ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import customExceptions.RequiredFieldsException;
import customExceptions.TypeOfDocumentImproperException;
import customExceptions.UserExistException;
import model.Shift;
import model.ShiftControler;

public class Main implements Serializable{
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
		system.alphabet();
		int option=0;
		do {
			
				System.out.println(system.getDate().getActual());
				System.out.println("MENU");
				System.out.println("0. Exit");
				System.out.println("1. Register user");
				System.out.println("2. Assign Shift");
				System.out.println("3. Attend shift");
				System.out.println("4. Refresh time");
				System.out.println("5. Create type of shift");
				System.out.println("6. Report of shifts of the user");
				System.out.println("7. Report of users ot the shift");
				System.out.println("8. Generate names");
				option = Integer.parseInt(lector.nextLine());
		switch(option) {
		case 1: 
			long totalSum = 0;
			System.out.print("Enter name: ");
			String name = lector.nextLine();
			System.out.print("Enter lastname: ");
			String lastname = lector.nextLine();
			System.out.println("Enter type of docuemnt");
			System.out.println("1.IDENTIFICATION_CARD");
			System.out.println("2.IDENTY_CARD,PASSPORT");
			System.out.println("3.CIVIL_REGISTRATION");
			System.out.println("4.FOREIGNER_ID");
			System.out.println("5.PASSPORT");
			int type = Integer.parseInt(lector.nextLine());
			System.out.print("Enter Id: ");
			String id = lector.nextLine();
			try {
				system.searchUser(id);
				System.out.print("Enter phone number: ");
				String phone = lector.nextLine();
				System.out.print("Enter adress: ");
				String adress = lector.nextLine();
				long startTime = System.currentTimeMillis();

				try {
					system.addUser(name,lastname,id, type, phone, adress);
					System.out.println("The user has been registred successfully");
					totalSum= (System.currentTimeMillis()-startTime);
					System.out.println("running time: "+totalSum);
				} catch (RequiredFieldsException | TypeOfDocumentImproperException | IOException e) {
			
					System.out.println(e.getMessage());
				}
			} catch (UserExistException e1) {
				System.out.println(e1.getMessage());

			}
			
			
			
		break;
		case 2:
			long totalSum2=0;
			System.out.print("Enter the id: ");
			String idSearch = lector.nextLine();
			System.out.println("Enter type of shift: ");
			String typeShift = lector.nextLine();
			long startTime2=System.currentTimeMillis();
			try {
				System.out.println(system.registerShifts(idSearch,typeShift));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			totalSum2=(System.currentTimeMillis()-startTime2);
			System.out.println("running time: "+totalSum2);
		break;
		case 3:
			long totalSum3=0;
			long startTime3=System.currentTimeMillis();
			int numShifts=system.attendShift();
			if(numShifts==0) {
				System.out.println("No turns to atend ");
				totalSum3=(System.currentTimeMillis()-startTime3);
				System.out.println("runnung time: "+totalSum3);
			}else {
				System.out.println(numShifts+" shifts has been attended");
				for(int i=0;i<numShifts;i++) {
					System.out.println("The shift number "+(i+1)+" the user was present?");
					String s = lector.nextLine();
					system.presentUser(s, i);
				}
				totalSum3=(System.currentTimeMillis()-startTime3);
				System.out.println("runnung time: "+totalSum3);
			}
		break;
		case 4:
			long totalSum4=0;
			long startTime4=System.currentTimeMillis();
			system.time();
			totalSum4=(System.currentTimeMillis()-startTime4);
			System.out.println("runnung time: "+totalSum4);
		break;
		case 5:
			long totalSum5=0;
			System.out.print("Enter name of shift: ");
			String nameShift = lector.nextLine();
			System.out.println("Enter time in minutes. Example 1.5(1 minute and 30 seconds)");
			long startTime5=System.currentTimeMillis();
			double time = Double.parseDouble(lector.nextLine());
			try {
				system.createShiftType(nameShift, time);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			totalSum5=(System.currentTimeMillis()-startTime5);
			System.out.println("runnung time: "+totalSum5);
		
			
		break;
		case 6:
			long totalSum6=0;
			System.out.print("Enter id of user: ");
			String idUser = lector.nextLine();
			long startTime6=System.currentTimeMillis();
			System.out.println(system.reportAllShifts(idUser));
			totalSum6=(System.currentTimeMillis()-startTime6);
			System.out.println("runnung time: "+totalSum6);
		break;
		case 7:
			long totalSum7=0;
			System.out.print("Enter num of shift: ");
			String nShift = lector.nextLine();
			long startTime7=System.currentTimeMillis();
			System.out.println(system.reportShiftWithUsers(nShift));
			totalSum7=(System.currentTimeMillis()-startTime7);
			System.out.println("runnung time: "+totalSum7);
		break;
		case 8:
			try {
				system.generateNames();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}while(option!=0);
  }
}
