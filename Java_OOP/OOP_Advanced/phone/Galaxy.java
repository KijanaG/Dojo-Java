package oop.advanced.phone;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayInfo() {
		System.out.println("Galaxy S9 from "+this.carrier);
	}
	
	public String ring() {
		return ringTone;
	}
	public String unlock() {
		return "Phone is unlocked";
	}
}
