package oop.advanced.phone;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9",98,"Verizon", "Bring Brriiing");
		iPhone iphoneTen = new iPhone("X", 99, "AT%T","Dooladoodee");
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());
	}
}
