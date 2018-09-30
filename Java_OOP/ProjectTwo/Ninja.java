package liv.humans.types;

public class Ninja extends Human {

	public Ninja() {
		super.stealth = 10;
	}
	public void steal(Human human) {
		human.health -= this.stealth;
	}
	public void run() {
		this.health -= 10;
		System.out.println("Health decreasing to "+this.health);
	}

}
