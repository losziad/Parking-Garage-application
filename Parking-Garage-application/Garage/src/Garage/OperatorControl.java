package Garage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Garage.Payment.PaymentForm;

public class OperatorControl {
	private int searchVehicle(int vehicleID) {
		if (new File("Vehicles.txt").exists()) {  
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File("Vehicles.txt")));
				String line;     
				String[] info = null;
				try {
					while((line=br.readLine())!=null) {
						info = line.split("\t");
						if (Integer.parseInt(info[0])==vehicleID) {
							br.close();
							return Integer.parseInt(info[1]);
						}	
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} 
		}
		return -1;
	}
	
	public void validateChoice() {
		OperatorForm form = new OperatorForm();
		int choice = form.desplayMenuList();
		if (choice==1) {
			form.parkInMessage(ParkIn());
		} else if (choice==2) {
			form.parkOutMessage(ParkOut());
		} else if (choice==3) {
			form.displayAvailableSlots();
		} else if (choice==4) {
			return;
		}
		validateChoice();
	}
	
	public boolean ParkIn() {
		OperatorForm form = new OperatorForm();
		VehicleSpec spec = form.enterVehicleSpec();
		ParkingSlot freeSlot = Garage.getConfig().apply(spec, Garage.getSlots());
		if (freeSlot!=null) {
			Vehicle vehicle = new Vehicle(spec);
			vehicle.markArrival();
			Garage.getSlots().get(String.valueOf(freeSlot.getSlotID())).reserve(vehicle);
			return true;
		}
		return false;
	}
	
	public boolean ParkOut() {
		OperatorForm form = new OperatorForm();
		int vehicleID = form.enterVehicleID();
		int reservedSlot = searchVehicle(vehicleID);
		if(reservedSlot!=-1) {
			Garage.getVehicles().get(String.valueOf(vehicleID)).markDeparture();
			Payment payment = new Payment();
			payment.displayAmount(Garage.getVehicles().get(String.valueOf(vehicleID)));
			Payment.PaymentForm payForm = payment.new PaymentForm();
			payForm.addPaymentToFile(Garage.getVehicles().get(String.valueOf(vehicleID)), payment);
			Garage.getSlots().get(String.valueOf(reservedSlot)).free(Garage.getVehicles().get(String.valueOf(vehicleID)));
			return true;
		}
		return false;
	}
	
}
