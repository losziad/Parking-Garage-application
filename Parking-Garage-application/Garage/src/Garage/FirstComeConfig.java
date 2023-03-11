package Garage;

import java.util.HashMap;

public class FirstComeConfig implements Configuration {
	public ParkingSlot apply(VehicleSpec spec, HashMap<String,ParkingSlot> slots) {
		for (String id : slots.keySet()) {
			if (!slots.get(id).isFree())
				continue;
			if (slots.get(id).getSlotWidth() < spec.getVehicleWedth())
				continue;
			if (slots.get(id).getSlotLength() < spec.getVehicleLength())
				continue;
			return slots.get(id);
		}
		return null;
	}
}
