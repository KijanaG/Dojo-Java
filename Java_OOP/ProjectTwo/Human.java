package liv.humans.types;

public class Human {
	public int strength = 3;
	public int intelligence = 3;
	public int stealth = 3;
	public int health = 100;
	protected int SamuraiCount = 0;
	public void attack(Human human) {
		human.health -= this.strength;
	}
	public void showHealth() {
		System.out.println("Health is: "+this.health);
	}
	
}
