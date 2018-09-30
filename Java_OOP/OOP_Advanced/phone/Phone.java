package oop.advanced.phone;

public abstract class Phone {
	protected String versionNumber;
	protected int batteryPercentage;
	protected String carrier;
	protected String ringTone;
	public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
		this.carrier = carrier;
		this.ringTone = ringTone;
		
	}
	
	public abstract void displayInfo();
	
	public String getNumber() {
		return versionNumber;
	}
	public int getBatteryP() {
		return batteryPercentage;
	}
	public String getCarrier() {
		return carrier;
	}
	public String getRingTone() {
		return ringTone;
	}
	public void setNumber(String number) {
		this.versionNumber = number;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public void setTone(String tone) {
		this.ringTone = tone;
	}
}
