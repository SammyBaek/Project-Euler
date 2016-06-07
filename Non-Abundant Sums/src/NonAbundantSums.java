import java.util.ArrayList;

/**
 * Created by kie827 on 6/7/2016.
 * Project Euler #23
 */
public class NonAbundantSums {
    public static void main(String[] args) {
        // find all abundant numbers
        ArrayList<Integer> abundants = new ArrayList<Integer>();
        for (int i = 1 ; i < 30000 ; i ++)
            if (divisorSum(i) > i)
                abundants.add(i);
        System.out.println(abundants);

        // find all numbers that can be written as sum of two abundant numbers
        boolean[] isSumTwoAbundant = new boolean [60000];
        for (int a : abundants)
            for (int b : abundants)
                isSumTwoAbundant[a+b] = true;
        int sum = 0;
        for (int i = 1 ; i < 28123 ; i ++)
            if (!isSumTwoAbundant[i])
                sum += i;
        System.out.println(sum);
    }

    private static int divisorSum(int num){
        int sum = 0;
        for (int i = 1 ; i < num ; i ++){
            if (num % i == 0)
                sum += i;
        }
        return sum;
    }
}
