/**
 * Created by kie827 on 6/8/2016.
 * Project Euler #37
 */
public class TruncatablePrimes {
    static int count;
    public static void main(String[] args) {
        count = 0;
        int num = 11;
        int sum = 0;
        while (count < 11){
            if (rightTruncatable(Integer.toString(num)) && leftTruncatable(Integer.toString(num))){
                System.out.println(++count + " " + num);
                sum += num;
            }
            num += 2;
//            System.out.println(num);
        }
        System.out.println(sum);
    }

    private static boolean leftTruncatable(String num){
        if (num.length() == 0)
            return true;
        if (!isPrime(Integer.parseInt(num)))
            return false;
        return leftTruncatable(num.substring(1));
    }

    private static boolean rightTruncatable(String num){
        if (num.length() == 0)
            return true;
        if (!isPrime(Integer.parseInt(num)))
            return false;
        return rightTruncatable(num.substring(0, num.length()-1));
    }

    private static boolean isPrime(int num){
        if (num < 2)
            return false;
        for (int i = 2 ; i <= Math.sqrt(num) ; i ++)
            if (num % i == 0)
                return false;
        return true;
    }
}
