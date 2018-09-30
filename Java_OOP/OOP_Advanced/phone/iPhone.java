package oop.advanced.phone;

public class iPhone extends Phone implements Ringable {

	public iPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber,batteryPercentage, carrier, ringTone);
	}
	
	@Override
	public void displayInfo() {
		System.out.println("iPhone from "+this.carrier);
	}
	public String ring() {
		return ringTone;
	}
	public String unlock() {
		return "Phone is unlcoked";
	}
}
