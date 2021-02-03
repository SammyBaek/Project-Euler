import java.util.HashSet;

/**
 * Created by kie827 on 6/9/2016.
 * Project Euler #95
 */
public class AmicableChains {
    static final int MILLION = 1000000;
    public static void main(String[] args) {
        int maxCount = 0;
        int refer = 0;
        System.out.println(getNewNum(220));
        for (int i = 2 ; i < MILLION ; i ++){
            int count = getChainCount(i);

            if (count > maxCount){
                refer = i;
                maxCount = count;
                System.out.println(i + " " + count);
            }
        }
        System.out.println(refer + " " + maxCount);
        HashSet<Integer> set = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;
        while (!set.contains(refer)){
            set.add(refer);
            if (refer <  min)
                min = refer;
            refer = getNewNum(refer);
        }
        System.out.println(min);
        System.out.println(set);
    }

    private static int getChainCount(int num){
        int count = 0;
        int temp = num;
        HashSet<Integer> set = new HashSet<Integer>();
        while (!set.contains(temp)){
            set.add(temp);
            temp = getNewNum(temp);
            if (temp == 1 || temp > MILLION)
                return -1;
            count++;
        }
        if (temp == num)
            return count;
        else
            return -1;
    }

    private static int getNewNum(int num){
        int result = 1;
        for (int i = 2 ; i < Math.sqrt(num) ; i++)
            if (num % i == 0)
                result += i + (num / i );
        return result;
    }
}
