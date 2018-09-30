import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(int a, int b) {
        int aSquared = a * a;
        int bSquared = b * b;
        int sum = aSquared + bSquared;
        return Math.sqrt(sum);
    }
}