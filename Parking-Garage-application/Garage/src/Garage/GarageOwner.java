package Garage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GarageOwner {
	private static GarageOwner owner;
	private String ownerName;
	private String pass;
	private GarageOwner(String ownerName, String pass) {
		this.ownerName = ownerName;
		this.pass = pass;
		try {
			FileWriter ownerWriter = new FileWriter("Owner File.txt");
			ownerWriter.write(this.ownerName);
			ownerWriter.write("\n");
			ownerWriter.write(String.valueOf(this.pass));
			ownerWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static GarageOwner createOwner(String ownerName, String pass) {
		if (!new File("Owner File.txt").exists()) {
			owner = new GarageOwner(ownerName, pass);
		}
		return owner;
	}
	
	public static GarageOwner getOwner() {
		if (owner == null) {
			File ownerFile = new File("Owner File.txt");
			if (ownerFile.exists()) {
				try {
					Scanner ownerReader = new Scanner(ownerFile);
					String name = ownerReader.nextLine();
					String pass = ownerReader.nextLine();
					ownerReader.close();
					ownerFile.delete();
					return GarageOwner.createOwner(name, pass);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return owner;
	}
	
	public String getPass() {
		return pass;
	}
	
}
