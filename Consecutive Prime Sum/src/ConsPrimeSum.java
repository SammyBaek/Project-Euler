import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by kie827 on 6/8/2016.
 * Project Euler #50
 */
public class ConsPrimeSum {
    public static void main(String[] args) {

        // find all primes under million
        final long MILLION = 1000000;
        ArrayList<Long> primes = new ArrayList<Long>();
        primes.add(0l);
        for (long i = 2 ; i < MILLION ; i ++){
            System.out.println(i);
            if (isPrime(i))
                primes.add(i);
        }
        // store consecutive primes
        long[] consPrimes = new long [primes.size()];
        consPrimes[0] = primes.get(0);
        for (int i = 1 ; i < consPrimes.length ; i ++){
            consPrimes[i] = consPrimes[i-1] + primes.get(i);
        }
        System.out.println(Arrays.toString(consPrimes));
        // store primes in Set for fast access
        HashSet<Long> hashPrimes = new HashSet<Long>();
        for (long num : primes)
            hashPrimes.add(num);

        int max = 0;
        long maxPrime = 0;
        for (int a = 0 ; a < consPrimes.length-1 ; a++){
            for (int b = a+1 ; b < consPrimes.length ; b++){
                long temp = consPrimes[b] - consPrimes[a];
                if (hashPrimes.contains(temp) && b-a > max){
                    System.out.println(temp + " " + (b-a));
                    max = b-a;
                    maxPrime = temp;
                }
            }
        }
        System.out.println("MAX PRIME: " + maxPrime + "   " + max);
    }

    private static boolean isPrime(long num){
        for (long i = 2 ; i <= Math.sqrt(num) ; i ++)
            if (num % i == 0)
                return false;
        return true;
    }
}
