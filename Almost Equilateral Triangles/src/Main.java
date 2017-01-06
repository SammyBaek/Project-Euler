/**
 * Created by kie827 on 1/6/2017.
 */

/**
 * It is easily proved that no equilateral triangle exists with
 * integral length sides and integral area. However, the almost equilateral
 * triangle 5-5-6 has an area of 12 square units.
 *
 * We shall define an almost equilateral triangle to be a triangle for which
 * two sides are equal and the third differs by no more than one unit.
 *
 * Find the sum of the perimeters of all almost equilateral triangles with
 * integral side lengths and area and whose perimeters do not exceed
 * one billion (1,000,000,000).
 */

public class Main {
    private static long BILLION = 1000000000;
    static long test = 100;
    public static void main(String[] args) {
        // sides must be either {a,a,a-1} or {a,a,a+1}
        // therefore, the area is either A = ((a-1)/4)(sqrt((3a-1)(a+1)))
        // or A = ((a+1)/4)(sqrt((3a+1)(a-1)))
        long perimeter = 0;
        for (long a = 3; a <= (BILLION - 1)/3; a += 2) {
            // we skip even a's since they won't be factored out of sqrt
            long sqrt1 = getIntSqrt((3*a-1)*(a+1));
            long area1 = 1;
            if (sqrt1 != -1) {
                area1 = sqrt1 * (a-1) / 4;
                perimeter += 3*a - 1;
            }

            long sqrt2 = getIntSqrt((3*a+1)*(a-1));
            long area2 = 1;
            if (sqrt2 != -1) {
                area2 = sqrt2 * (a+1) / 4;
                perimeter += 3*a + 1;
            }

            if (area1 != 1) {
                System.out.println(a + ": " + area1);
            }
            if (area2 != 1) {
                System.out.println(a + ": " + area2);
            }
        }
        System.out.println(perimeter);
    }

    private static long getIntSqrt(long num) {
        long comp = (long) Math.sqrt(num);
        if (comp*comp == num) {
            return comp;
        }
        return -1;
    }
}
