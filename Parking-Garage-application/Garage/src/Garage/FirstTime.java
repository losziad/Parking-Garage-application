package Garage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FirstTime {
	
	class FirstTimeControl {
		private void setupOwner() {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the garage Owner name: ");
			String Name = sc.nextLine();
			System.out.print("Enter your password: ");
			String Pass = sc.nextLine();
			GarageOwner.createOwner(Name, Pass);
		}
		
		private void setupConfig() {
			boolean result;
			int choice;
			do {
				result = true;
				System.out.println("1.First Come Approach.");
				System.out.println("1.Best Fit Approach.");
				System.out.print("your choice: ");
				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();
				if (choice==1) {
					try {
						FileWriter fw = new FileWriter(new File("First Come.txt"));
						fw.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (choice==2) {
					try {
						FileWriter fw = new FileWriter(new File("Best Fit.txt"));
						fw.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("!!This is not an option!!");
					result = false;
				}
			} while(!result);
		}
		
		public void setupGarage() {
			System.out.println("Hello, This is your first time using the programe :)");
			System.out.println("Now let's start setting up your garage: ");
			setupOwner();
			System.out.println("Now choose onr of the two possible configuration to apply: ");
			setupConfig();
			System.out.println("Your garage is ready to go :) ");
		}
		
	}
	
	public void firstTime() {
		if (!new File("First Time.txt").exists()) {
			try {
				FileWriter fw = new FileWriter(new File("First Time.txt"));
				fw.close();
				new FirstTimeControl().setupGarage();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
