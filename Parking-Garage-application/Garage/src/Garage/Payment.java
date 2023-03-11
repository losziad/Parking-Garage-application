package Garage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Payment {
	private double amount;

	private void setAmount(Vehicle vehicle) {
		amount = new PaymentControl().calculateFees(vehicle);
	}
	
	class PaymentControl {
		public double calculateFees(Vehicle vehicle) {
			long stayTime = (vehicle.getDepartureTime().getTime()-vehicle.getArrivalTime().getTime())/3600000;
			return Math.ceil(stayTime)*5;
		}
	}
	
	class PaymentForm {
		public void addPaymentToFile(Vehicle vehicle, Payment payment) {
			try {
				BufferedWriter br = new BufferedWriter(new FileWriter(new File("Payments.txt"), true));
				br.write(String.valueOf(vehicle.getVehicleID()) + "\t");
				br.write(String.valueOf(vehicle.getVehicleSlot()) + "\t");
				br.write(String.valueOf(vehicle.getVehicleSpec().print())+ "\t");
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				br.write(formatter.format(vehicle.getArrivalTime().getTime()) + "\t");
				br.write(formatter.format(vehicle.getDepartureTime().getTime()) + "\t");
				br.write(String.valueOf(payment.getAmount()));
				br.write("\n");
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void displayAmount(Vehicle vehicle) {
		setAmount(vehicle);
		System.out.println("The parking fees = " + amount + "EGP");
	}
	
	public double getAmount() {
		return amount;
	}
	
}
