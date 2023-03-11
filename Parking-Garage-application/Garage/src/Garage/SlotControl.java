package Garage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SlotControl {
	public void updateSlots() {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("Slots.txt"));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String id : Garage.getSlots().keySet()) {
			Garage.addSlot(Garage.getSlots().get(id));
		}
	}
}
