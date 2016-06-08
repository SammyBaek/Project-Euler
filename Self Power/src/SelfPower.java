/**
 * Created by kie827 on 6/7/2016.
 * Project Euler #48
 */
public class SelfPower {
    public static void main(String[] args) {
        long LAST_TEN = 10000000000l;
        int LIMIT = 1000;
        long sum = 0;
        for (int i = 1 ; i <= LIMIT ; i ++){
            long temp = 1;
            for (int j = 0 ; j < i ; j ++)
                temp = (temp * i) % LAST_TEN;
            sum = (sum + temp) % LAST_TEN;
        }
        System.out.println(sum);
    }
}
