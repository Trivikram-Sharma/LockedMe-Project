package lockpackage;

import java.io.*;
import java.util.*;

public class LockerApp {
	static Scanner sc = new Scanner(System.in);
	private static final String fdir = "D:\\Lockerfiles";

	// Method of first option to display All Files of a directory
	public void displayFiles() {
		File folder = new File(fdir);
		File[] fnames = folder.listFiles();
		// Using bubble sort to sort filenames in ascending order
		for (int i = 0; i < fnames.length; i++) {
			for (int j = 0; j < fnames.length; j++) {
				if (fnames[i].getName().compareTo(fnames[j].getName()) < 0) {
					File temp = fnames[i];
					fnames[i] = fnames[j];
					fnames[j] = temp;
				}
			}
		}

		// Displaying file names after sorting
		for (File f : fnames)
			System.out.println(f.getName());

	}

	// Utility Function to check if File Exists
	public static boolean checkFileExists(String filename) {
		ArrayList<String> fnames = new ArrayList<String>();
		File f = new File(fdir);
		for (File fn : f.listFiles())
			fnames.add(fn.getName());
		return fnames.contains(filename);
	}

	// Method to Search a File
	public static void searchFile() {
		System.out.println("Please enter the filename to be searched:");
		String filename = sc.nextLine();
		if (checkFileExists(filename)) {

			System.out.println("The file " + filename + " exists");
		} else {
			System.out.println("The file " + filename + " is not found in the directory");
		}
	}

	// Method to Add a File
	public static void addFile() {
		System.out.println("Please Enter the filename of the file to be added:");
		String filename = sc.nextLine();
		try {
			if (checkFileExists(filename)) {
				System.out.println("The file " + filename
						+ " already exists in the directory. Please choose a different name to add new file.");
			} else {
				FileWriter fw = new FileWriter(fdir + "\\" + filename);
				System.out.println("Enter the number of lines to be written to the file:");
				int lines = sc.nextInt();
				System.out.println("Enter "+lines+" lines to be written to the file below");
				for (int i = 0; i <=lines; i++) {
					fw.write(sc.nextLine()+"\n");}
				System.out.println("File added successfully!!");
				fw.close();
			}
		} catch (NumberFormatException ne) {
			System.out.println("Please Enter numeric input for number of lines to be entered into a file");
			System.out.println(ne.getMessage());
		} catch (Exception ie) {
			System.out.println("IO Exception occured" + ie.getMessage());
		}
	}

	// Method to Delete a File
	public static void deleteFile() {
		System.out.println("Please enter the file name of the file to be deleted.");
		String filename = sc.nextLine();
		if (checkFileExists(filename)) {
			File f = new File(fdir + "\\" + filename);
			System.out.println(f.getName());
			// Check if File Deletion works
			boolean status = f.delete();
			if (status) {

				System.out.println("File deleted Successfully.");
			} else {
				System.out.println("File could not be deleted!! Please check the file name and try again");
				System.out.println(status);
				System.out.println(f.exists());

			}

		} else {
			System.out.println(
					"The file does not exist in the directory. Please check the file list using option 1 in Main Menu");
		}
	}

}