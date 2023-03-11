package Garage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Garage {
	private static HashMap<String,ParkingSlot> slots = new HashMap<String,ParkingSlot>();
	private static HashMap<String,Vehicle> vehicles = new HashMap<String,Vehicle>();
	private static Garage myGarage;
	private static Configuration config;
	
	private void setSlots() {
		if (new File("Slots.txt").exists()) {  
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File("Slots.txt")));
				String line;     
				String[] spec = null;
				boolean free;
				try {
					while((line=br.readLine())!=null) {
						free = false;
						spec = line.split("\t");
						if (spec[3].equals("Available"))
							free = true;
						ParkingSlot slot = new ParkingSlot(Integer.parseInt(spec[0]), Double.parseDouble(spec[1]), Double.parseDouble(spec[2]), free);
						slots.put(spec[0], slot);
					}
					ParkingSlot.setSlotCount(Integer.parseInt(spec[0]));
					br.close();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} 
		}
	}
	
	private void setVehicles() {
		if (new File("Vehicles.txt").exists()) {  
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File("Vehicles.txt")));
				String line;     
				String[] info = null;
				try {
					while((line=br.readLine())!=null) {
						info = line.split("\t");
						VehicleSpec spec = new VehicleSpec(info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]), Double.parseDouble(info[5]));
						Vehicle vehicle = new Vehicle(spec, Integer.parseInt(info[0]), Integer.parseInt(info[1]));
						vehicle.setArrivalTime(info[6]); 
						vehicles.put(info[0], vehicle);
					}
					br.close();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} 
		}
	}
	
	private void setConfig() {
		if (new File("First Come.txt").exists()) 
			config = new FirstComeConfig();
		else if (new File("Best Fit.txt").exists())
			config = new BestFitConfig();
	}
	
	private Garage() {
		this.setSlots();
		this.setVehicles();
		this.setConfig();
	}
	
	public static Garage createGarage() {
		myGarage = new Garage();
		return myGarage;
	}
	
	public static void addSlot(ParkingSlot slot) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(new File("Slots.txt"), true));
			br.write(String.valueOf(slot.getSlotID()) + "\t");
			br.write(String.valueOf(slot.getSlotWidth())+ "\t");
			br.write(String.valueOf(slot.getSlotLength())+ "\t");
			if (slot.isFree()) {
				br.write("Available\t");
			} else {
				br.write("Not Available\t");
			}
			br.write("\n");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		slots.put(String.valueOf(slot.getSlotID()),slot);
	}
	
	public static Configuration getConfig() {
		return config;
	}
	
	public static HashMap<String,ParkingSlot> getSlots() {
		return slots;
	}
	
	public static void addVehicle(Vehicle vehicle) {
		vehicles.put(String.valueOf(vehicle.getVehicleID()), vehicle);
	}
	
	public static void removeVehicle(Vehicle vehicle) {
		Garage.getVehicles().remove(String.valueOf(vehicle.getVehicleID()));
	}
	
	public static HashMap<String,Vehicle> getVehicles() {
		return vehicles;
	}
	
}
