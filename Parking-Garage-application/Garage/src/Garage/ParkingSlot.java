package Garage;

class ParkingSlot {
	private static int count = 0;
	private int slotID;
	private double slotWidth;
	private double slotLength;
	private boolean free;
	
	public ParkingSlot(double slotWidth, double slotLength) {
		this.slotWidth = slotWidth;
		this.slotLength = slotLength;
		free = true;
		count++;
		slotID = count;
	}
	
	public ParkingSlot(int slotID, double slotWidth, double slotLength, boolean free) {
		this.slotID = slotID;
		this.slotWidth = slotWidth;
		this.slotLength = slotLength;
		this.free = free;
	}
	
	public void reserve(Vehicle vehicle) {
		free = false;
		vehicle.setVehicleSlot(slotID);
		vehicle.addVehicleToFile();
		Garage.addVehicle(vehicle);
		new SlotControl().updateSlots();
	}
	
	public void free(Vehicle vehicle) {
		free = true;
		new SlotControl().updateSlots();
		Garage.removeVehicle(vehicle);
		Vehicle.updateVehicles();
	}
	
	public double getSlotWidth() {
		return this.slotWidth;
	}
	
	public double getSlotLength() {
		return this.slotLength;
	}
	
	public boolean isFree() {
		return this.free;
	}
	
	public int getSlotID() {
		return slotID;
	}
	
	public void print() {
		System.out.print("ID:" + getSlotID() + "\t\t");
		System.out.print("Width: " + getSlotWidth() + " meter" + "\t" );
		System.out.print("Length: " + getSlotLength() + " meter" + "\n");
	}
	
	public static void setSlotCount(int num) {
		count = num;
	}
}
