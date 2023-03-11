package Garage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GarageOperator {
	private static int count = 20200;
	private String operatorName;
	private int operatorID;
	private void addToFile() {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(new File("Operator File.txt"), true));
			br.write(operatorName + "\t");
			br.write(String.valueOf(operatorID) + "\n");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GarageOperator(String operatorName) {
		this.operatorName = operatorName;
		this.operatorID = count;
		count++;
		this.addToFile();
	}
	
}
