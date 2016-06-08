import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by kie827 on 6/8/2016.
 * Project Euler #44
 */
public class PentagonNumbers {
    public static void main(String[] args) {
        // find pentagonal numbers
        ArrayList<Long> pentagonals = new ArrayList<Long>();
        for (int i = 1 ; i < 10000 ; i ++)
            pentagonals.add((i * (3*i-1)) / 2l);
        HashSet<Long> hashPents = new HashSet<Long>();
        for (long i : pentagonals)
            hashPents.add(i);
        long min = Integer.MAX_VALUE;
        for (int a = 0 ; a < pentagonals.size()-1 ; a++)
            for (int b = a+1 ; b < pentagonals.size() ; b++){
                long x = pentagonals.get(a);
                long y = pentagonals.get(b);
                if (hashPents.contains(x+y) && hashPents.contains(y-x)){
                    if (Math.abs(y-x) < min){
                        min = Math.abs(y-x);
                        System.out.println(x + " " + y + " " + min);
                    }
                }
            }
    }
}
