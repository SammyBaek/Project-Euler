import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kie827 on 1/9/2017.
 *
 * By listing the set of reduced proper fractions for
 * d ≤ 1,000,000 in ascending order of size,
 * find the numerator of the fraction immediately to the left of 3/7.
 */
public class Main {

    public static void main(String[] args) {
        Fraction closest = new Fraction(0, 1);
        // find close-enough fractions before 3/7
        for (int denom = 2; denom <= 1000000; denom++) {
            System.out.println(denom);
            int numer = (int) Math.ceil((double) 3 / 7 * denom);
            while ((double) numer / denom >= closest.valueOf()) {
                if (gcd(numer, denom) == 1 && (double) numer / denom < 3.0 / 7.0) {
                    closest = new Fraction(numer, denom);
                }
                numer--;
            }
        }
        System.out.println();
        System.out.println("Answer: " + closest);
    }

    private static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int num, int den) {
            this.numerator = num;
            this.denominator = den;
        }

        public double valueOf() {
            return (double) numerator / denominator;
        }

        @Override
        public String toString() {
            return numerator + " / " + denominator;
        }
    }

    /**
     * Euclidean Algorithm for finding Greatest Common Divisor
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}

