import java.util.Arrays;

/**
 * Created by Sam Baek on 1/21/2017.
 */
public class DiceGame {
    private static int[] pyramidalCount;
    private static int[] pyramidalCumulative;
    private static int[] cubicCount;
    private static int[] cubicCumulative;
    private static int pyramidalMax;
    private static int cubicMax;

    public static void main(String[] args) {
        pyramidalCount = new int[4 * 9 + 1];
        cubicCount = new int[6 * 6 + 1];
        pyramidalCumulative = new int[pyramidalCount.length];
        cubicCumulative = new int[cubicCount.length];

        fillPyramidal(0, 9);
        fillCubic(0, 6);

        for (int i = 1; i < pyramidalCount.length; i++) {
            pyramidalCumulative[i] = pyramidalCount[i] + pyramidalCumulative[i - 1];
        }

        for (int i = 1; i < cubicCount.length; i++) {
            cubicCumulative[i] = cubicCount[i] + cubicCumulative[i - 1];
        }

        pyramidalMax = pyramidalCumulative[pyramidalCumulative.length - 1];
        cubicMax = cubicCumulative[cubicCumulative.length - 1];

        double prob = 0.0;
        for (int i = 1; i < pyramidalCount.length; i++) {
            if (pyramidalCount[i] == 0) {
                continue;
            }
            prob += (1.0 * pyramidalCount[i] / pyramidalMax) * (1.0 * cubicCumulative[i - 1] / cubicMax);
        }
        System.out.println(prob);
    }

    private static void fillPyramidal(int total, int cycle) {
        if (cycle == 0) {
            pyramidalCount[total]++;
            return;
        }
        for (int i = 1; i <= 4; i++) {
            fillPyramidal(total + i, cycle - 1);
        }
    }

    private static void fillCubic(int total, int cycle) {
        if (cycle == 0) {
            cubicCount[total]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            fillCubic(total + i, cycle - 1);
        }
    }
}