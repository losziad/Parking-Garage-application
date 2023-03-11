package Garage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle {
	private static int count = 0;
	private VehicleSpec mySpec;
	private int vehicleID;
	private Date arrival;
	private Date departure;
	private int vehicleSlot;
	
	public Vehicle(VehicleSpec mySpec) {
		this.mySpec = mySpec;
		count++;
		vehicleID = count;
		Garage.addVehicle(this);
	}
	
	public Vehicle(VehicleSpec mySpec, int vehicleID, int slotID) {
		this.mySpec = mySpec;
		this.vehicleID = vehicleID;
		this.vehicleSlot = slotID;
	}
	
	public void setArrivalTime(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			arrival = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateVehicles() {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("Vehicles.txt"));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String id : Garage.getVehicles().keySet()) {
			Garage.getVehicles().get(id).addVehicleToFile();
		}
	}
	
	public void addVehicleToFile() {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(new File("Vehicles.txt"), true));
			br.write(String.valueOf(vehicleID) + "\t");
			br.write(String.valueOf(vehicleSlot) + "\t");
			br.write(String.valueOf(mySpec.print())+ "\t");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			br.write(formatter.format(getArrivalTime().getTime()) + "\t");
			br.write("\n");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setVehicleSlot(int slotID) {
		vehicleSlot = slotID;
	}
	
	public void markArrival() {
		arrival = new Date();
	}
	
	public void markDeparture() {
		departure = new Date();
	}
	
	public VehicleSpec getVehicleSpec() {
		return mySpec;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}
	
	public Date getArrivalTime() {
		return arrival;
	}
	
	public Date getDepartureTime() {
		return departure;
	}
	
	public int getVehicleSlot() {
		return vehicleSlot;
	}
	
	public static void setVehicleCount(int num) {
		count = num;
	}
}
