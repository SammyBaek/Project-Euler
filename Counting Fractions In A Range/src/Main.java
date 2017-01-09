/**
 * Created by kie827 on 1/9/2017.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Fraction> fractions;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        fractions = new ArrayList<Fraction>();

        for (int denom = 2; denom <= 12000; denom++) {
            System.out.println(denom);
            for (int numer = 1; numer < denom; numer++) {
                if (gcd(numer, denom) == 1) {
                    fractions.add(new Fraction(numer, denom));
                }
            }
        }
        Collections.sort(fractions);
        int posStart = 0;
        int posEnd = 0;
        for (int i = 0; i < fractions.size(); i++) {
            Fraction f = fractions.get(i);
            if (f.numerator == 1) {
                if (f.denominator == 2) {
                    posEnd = i;
                    break;
                } else if (f.denominator == 3) {
                    posStart = i;
                }
            }
        }
        System.out.println("\n\n\n");
        System.out.println("1/3 index: " + posStart + "   1/2 index: " + posEnd);
        System.out.println(posEnd - posStart - 1);

        long endTime = System.currentTimeMillis();
        System.out.println("Time took: " + ((double) (endTime - startTime) / 1000) + " seconds");
    }

    private static class Fraction implements Comparable<Fraction> {
        private int numerator;
        private int denominator;
        public Fraction(int num, int den) {
            this.numerator = num;
            this.denominator = den;
        }

        @Override
        public int compareTo(Fraction o) {
            return Double.valueOf((double) this.numerator / this.denominator)
                    .compareTo((double) o.numerator / o.denominator);
        }

        @Override
        public String toString() {
            return numerator + " / " + denominator;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Fraction)) {
                return false;
            }
            Fraction other = (Fraction) o;
            return this.numerator == other.numerator
                    && this.denominator == other.denominator;
        }
    }

    /**
     * Euclidean Algorithm for finding Greatest Common Divisor
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}

