package Garage;

import java.util.HashMap;
import java.util.Scanner;

public class OperatorForm {
	
	public int desplayMenuList() {
		boolean result;
		int choice;
		do {
			result = true;
			System.out.println("--------------------Choose the an option from the list below: --------------------");
			System.out.println("1.Park a new vehicle in the garage.");
			System.out.println("2.Park out a vehicle from the garage.");
			System.out.println("3.Display all available slots.");
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
	
	public VehicleSpec enterVehicleSpec() {
		return new VehicleSpec();
	}
	
	public void parkInMessage(boolean result) {
		if (result==true)
			System.out.println("The vehicle has parked in the Garage :)");
		else 
			System.out.println("Sorry, no available slot for this vehicle!");
	}
	
	public void parkOutMessage(boolean result) {
		if (result==true)
			System.out.println("The vehicle has parked out of the Garage :)");
		else 
			System.out.println("Sorry, no vehicle parked in the garage with that ID!");
	}
	
	public void displayAvailableSlots() {
		HashMap<String,ParkingSlot> slots = Garage.getSlots();
		for (String id : slots.keySet()) {
			if (slots.get(id).isFree()) 
				slots.get(id).print();
		}
	}
	
	public int enterVehicleID() {
		System.out.print("Enter the vehicle ID: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
