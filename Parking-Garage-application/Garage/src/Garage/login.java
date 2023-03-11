package Garage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class login {
	
	class loginControl {
		public boolean checkOwner(String pass) {
			if (pass.equals(GarageOwner.getOwner().getPass())) 
				return true;
			return false;
		}
		
		public boolean checkOperator(String ID) {
			if (new File("Operator File.txt").exists()) {  
				try {
					BufferedReader br = new BufferedReader(new FileReader(new File("Operator File.txt")));
					String line;     
					String[] info = null;
					try {
						while((line=br.readLine())!=null) {
							info = line.split("\t");
							if (info[1].equals(ID))
								return true;
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
			return false;
		}

	}
	
	public void signin() {
		System.out.print("Enter your password or ID: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (new loginControl().checkOwner(str)) {
			new OwnerControl().validateChoice();
			return;
		}
		if (new loginControl().checkOperator(str)) {
			new OperatorControl().validateChoice();
			return;
		}
		System.out.println("The password or ID that you entered is invalid");
	}
}
