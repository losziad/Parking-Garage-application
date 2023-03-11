package Garage;

import java.util.HashMap;

public interface Configuration {
	public ParkingSlot apply(VehicleSpec spec, HashMap<String,ParkingSlot> slots);
}
