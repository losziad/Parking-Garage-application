package Garage;

import java.util.HashMap;

public class BestFitConfig implements Configuration {
	public ParkingSlot apply(VehicleSpec spec, HashMap<String,ParkingSlot> slots) {
		ParkingSlot minSlot = null;
		for (String id : slots.keySet()) {
			if (!slots.get(id).isFree())
				continue;
			if (slots.get(id).getSlotWidth() < spec.getVehicleWedth())
				continue;
			if (slots.get(id).getSlotLength() < spec.getVehicleLength())
				continue;
			minSlot = slots.get(id);
		}
		return minSlot;
 	}
}
