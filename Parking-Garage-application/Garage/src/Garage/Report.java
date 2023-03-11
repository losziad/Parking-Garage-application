package Garage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Report {
	private double totalIncome = 0;
	private int leftVehicles = 0;
	private int existVehicles = Garage.getVehicles().size();
	
	class ReportForm {
		public void displayReport(Report report) {
			System.out.println("The total income = " + report.getTotalIncome() + "EGP");
			System.out.println("The number of vehicles who parked out of the garage = " + report.getLeftVehicles());
			System.out.println("The nnumber of vehicles who already parked in the garage = " + report.getExistVehicles());
		}
	}
	
	public Report getReport() {
		if (new File("Payments.txt").exists()) {  
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File("Payments.txt")));
				String line;     
				String[] info = null;
				try {
					while((line=br.readLine())!=null) {
						info = line.split("\t");
						totalIncome += Double.parseDouble(info[8]);
						leftVehicles++;
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
		return this;
	}
	
	public double getTotalIncome() {
		return totalIncome;
	}
	
	public int getLeftVehicles() {
		return leftVehicles;
	}
	
	public int getExistVehicles() {
		return existVehicles;
	}
}
