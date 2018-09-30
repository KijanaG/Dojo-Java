package liv.humans.types;

public class HumanTest {

	public static void main(String[] args) {
		Wizard wiz = new Wizard();
		Samurai sam = new Samurai();
		Samurai sammy = new Samurai();
		sam.meditate();
		wiz.fireball(sam);
		System.out.println(sammy.howMany());
	}

}
