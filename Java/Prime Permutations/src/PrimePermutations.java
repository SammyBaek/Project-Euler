import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by kie827 on 6/8/2016.
 * Project Euler #49
 */
public class PrimePermutations {
    public static void main(String[] args) {
        // find all 4-digit primes
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 1000 ; i <= 9999 ; i ++)
            if (isPrime(i))
                primes.add(i);
        // put in hashSet for fast access
        HashSet<Integer> hashPrimes = new HashSet<Integer>();
        for (int i : primes)
            hashPrimes.add(i);

        for (int a = 0 ; a < primes.size()-1 ; a++){
            for (int b = a+1 ; b < primes.size() ; b++){
                int diff = primes.get(b) - primes.get(a);
                if (hashPrimes.contains(primes.get(b) + diff)){
                    // check if permutation of each other
                    if (isPermutation(primes.get(a), primes.get(b), primes.get(b)+diff))
                        System.out.println(primes.get(a) + " " + primes.get(b) + " " + (primes.get(b)+diff) + "   diff: " + diff);
                }
            }
        }
    }

    private static boolean isPermutation(int x, int y, int z){
        char[] a = Integer.toString(x).toCharArray();
        char[] b = Integer.toString(y).toCharArray();
        char[] c = Integer.toString(z).toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        return (new String(a)).equals(new String(b)) && (new String(b)).equals(new String(c));
    }

    private static boolean isPrime(int num){
        for (int i = 2 ; i <= Math.sqrt(num) ; i ++)
            if (num % i == 0)
                return false;
        return true;
    }
}
