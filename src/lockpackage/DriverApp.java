package lockpackage;

import java.io.*;
import java.util.*;

public class DriverApp {
	public static void displayMenu() {

		System.out.println("\t\t\t\t1.List files in the directory");
		System.out.println("\t\t\t\t2.File operations (Add/Delete/Search a file)");
		System.out.println("\t\t\t\t3.Exit");
	}

	public static void displaySubMenu() {
		System.out.println("\t\t\t\t========================");
		System.out.println("\t\t\t\t\t1.Add a File");
		System.out.println("\t\t\t\t\t2.Delete a File");
		System.out.println("\t\t\t\t\t3.Search a File");
		System.out.println("\t\t\t\t\t4. Back to Main Menu");
		System.out.println("\t\t\t\t==========================");
		System.out.println("Please Enter one of the choices above as 1/2/3");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner object and variable declaration
		Scanner sc = new Scanner(System.in);
		int ip;
		System.out.println("\t\t\t\t=======================================================");
		System.out.println("\t\t\t\t\t\tWelcome to LockedMe.com!");
		System.out.println("\t\t\t\t\t\tDeveloped By: G TRIVIKRAM SHARMA");
		System.out.println("\t\t\t\t========================================================");
		// Display Menu until the user exits the Application
		try {
			do {
				displayMenu();
				System.out.println("Please select one of the options as 1/2/3");
				ip = sc.nextInt();
				if (ip == 1) {
					LockerApp lapp = new LockerApp();
					lapp.displayFiles();
				} else if (ip == 2) {
					displaySubMenu();
					int op = sc.nextInt();
					if (op == 1) {
						LockerApp.addFile();
					} else if (op == 2) {
						LockerApp.deleteFile();
					} else if (op == 3) {
						LockerApp.searchFile();
					} else if (op == 4) {
					} else {
						System.out.println("Invalid Input!! Please enter one of the options 1/2/3/4 as per the menu");
					}
				} else if (ip == 3) {
					System.exit(0);
				} else {
					System.out.println("Please enter options as 1/2/3 as per the menu");
				}
			} while (ip != 3);
		} catch (NumberFormatException ex) {
			System.out.println("Please enter numeric inputs for options!!" + ex.getMessage());
		} finally {
			sc.close();
		}
		// Input block for output to be visible on Command prompt when using executable
		// jar with cmd
	}

}
