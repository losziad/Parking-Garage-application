package Garage;

import java.util.Scanner;

public class OwnerForm {
	public int desplayMenuList() {
		boolean result;
		int choice;
		do {
			result = true;
			System.out.println("--------------------Choose the an option from the list below: --------------------");
			System.out.println("1.Add a new parking slot.");
			System.out.println("2.Generate Report.");
			System.out.println("3.Add new garage operator.");
			System.out.println("4.Close the programme.");
			System.out.print("your choice: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			if (choice<1 || choice>4) {
				System.out.println("!!This is not an option!!");
				result = false;
			}
		} while(!result);
		return choice;
	}
	
	public ParkingSlot enterSlotInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the width: ");
		double width = sc.nextDouble();
		System.out.print("Enter the length: ");
		double length = sc.nextDouble();
		return new ParkingSlot(width, length);
	}
	
	public String enterOperatorInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the operator name: ");
		return sc.nextLine();
	}
}
