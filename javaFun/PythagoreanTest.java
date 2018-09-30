public class PythagoreanTest {
    public static void main(String[] args) {
        Pythagorean pyth = new Pythagorean();
        double firstHypotenuse = pyth.calculateHypotenuse(3, 4);
        double sceondHypotenuse = pyth.calculateHypotenuse(13, 12);
        System.out.println("Legs 3 and 4 give: "+firstHypotenuse);
        System.out.println("Legs 13 and 12 give: "+sceondHypotenuse);
    }
}