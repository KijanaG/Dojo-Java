package liv.humans.types;


public class Samurai extends Human {
	private static int counter = 0;
	public Samurai() {
		super.health = 200;
		counter += 1;
	}
	public void deathBlow(Human human) {
		human.health = 0;
		this.health /=2;
	}
	public void meditate() {
		this.health = 200;
	}
	public String howMany() {
		return "There are "+counter+" Samurais.";
	}
}
