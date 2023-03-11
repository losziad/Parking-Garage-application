package Garage;

import java.util.Scanner;

public class VehicleSpec {
	private String modelName;
	private int modelYear;
	private double vehicleWedth;
	private double vehicleLength;
	
	public VehicleSpec() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the model name: ");
		this.modelName = sc.nextLine();
		System.out.print("Enter the model year: ");
		this.modelYear = sc.nextInt();
		System.out.print("Enter the width: ");
		this.vehicleWedth = sc.nextDouble();
		System.out.print("Enter the length: ");
		this.vehicleLength = sc.nextDouble();
	}
	
	public VehicleSpec(String modelName, int modelYear, double vehicleWedth, double vehicleLength) {
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.vehicleWedth = vehicleWedth;
		this.vehicleLength = vehicleLength;
	}
	
	public String print() {
		return (getModelName() + "\t" + getModelYear() + "\t" + getVehicleWedth() + "\t" + getVehicleLength());
	}
	
	public double getVehicleWedth() {
		return this.vehicleWedth;
	}
	
	public double getVehicleLength() {
		return this.vehicleLength;
	}
	
	public String getModelName() {
		return this.modelName;
	}
	
	public int getModelYear() {
		return this.modelYear;
	}
}
