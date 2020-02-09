package ui;

import java.util.Scanner;

import model.Shift;
import model.ShiftControler;

public class Main {
//Attributes
	private Scanner lector;
	private Main main;
	private ShiftControler system;
//Methods
	public Main() {
		lector = new Scanner(System.in);
		system = new ShiftControler();
	}
	public static void main(String args[]) {
		int nOne=0;
		int nTwo=0;
		char[] letters = new char[26];
		for(int i=0;i<26;i++) {
			letters[i]=(char)('A'+i);
			nOne=0;
			nTwo=0;
			for(int w=0;w<10;w++) {
				for(int j=0;j<10;j++) {
					System.out.println(letters[i]+""+nOne+""+nTwo);
					nTwo++;
				}
				nOne++;
				nTwo=0;
			}
		}
	}
	public void menu() {
		int option=0;
		System.out.println("MENU");
	}
}
