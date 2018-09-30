package liv.humans.types;

public class Wizard extends Human {

	public Wizard() {
		super.health = 50;
		super.intelligence = 8;
	}
	public void heal(Human human) {
		System.out.println(human+" health increasing.");
		human.health +=this.intelligence;
	}
	public void fireball(Human human) {
		System.out.println("Fireball!!");
		human.health -= (this.intelligence*3);
	}

}
