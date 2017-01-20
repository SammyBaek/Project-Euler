import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Sam Baek on 1/20/2017.
 */
public class LychrelNums {
    private static ArrayList<Integer> lychrels;
    public static void main(String[] args) {
        lychrels = new ArrayList<Integer>();
        for (int i = 1; i < 10000; i++) {
            if (isLychrel(new BigInteger(Integer.toString(i)), 0)) {
                lychrels.add(i);
            }
        }
        System.out.println("FINISHED!");
        for (Integer i : lychrels) {
            System.out.println(i);
        }
        System.out.println("SIZE: " + lychrels.size());
    }

    private static boolean isLychrel(BigInteger num, int iteration) {
        System.out.println(iteration + ": " + num);
        if (isPalin(num) && iteration != 0) {
            return false;
        }
        if (iteration > 50) {
            return true;
        }
        BigInteger temp = num.add(rev(num));
        return isLychrel(temp, ++iteration);
    }

    private static boolean isPalin(BigInteger num) {
        String str = num.toString();
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger rev(BigInteger num) {
        String s = num.toString();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(s.length() - i - 1);
        }
        return new BigInteger(result);
    }
}
