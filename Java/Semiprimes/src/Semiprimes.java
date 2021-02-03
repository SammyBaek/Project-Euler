//import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
//import java.math.BigInteger;

public class Semiprimes {
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter max base: ");
		long base = in.nextLong();
		System.out.println("Enter power: ");
		int pow = in.nextInt();
		double max = Math.pow(base, pow);
		in.close();
		
		/**
		 *  Collect all primes below max in ArrayList
		 */
		ArrayList <Long> primes = new ArrayList <Long>();
		primes.add((long) 2);
		System.out.println(primes.get(0));
		for (long i = 3; i< max/2 ; i+=2){
			if (isPrime(i)){
				primes.add(i);
				System.out.println("Prime: " + i);
			}
		}
		
		/**
		 * Collect semiprimes in ArrayList
		 * by multiplying two primes
		 */
		//ArrayList <Long> semiprimes = new ArrayList <Long> ();
		//		ArrayList ran out of memory / just gonna keep track of the total
		long total = 0;
		for (int i = 0 ; i<primes.size() ; i ++){
			int j = i;
			while(j < primes.size()){
			long k = primes.get(i)*(primes.get(j));
			if (k < max){
				total++;
				//semiprimes.add(k);
				System.out.println("Semiprime: " + k);
			}
			else if (k > max){
				break;
			}
			j++;
			}
		}
		//	Collections.sort(semiprimes);
		/**
		 * print semiprimes
		 */
	/*	
		for (int i = 0 ; i < semiprimes.size() ; i++){
			System.out.println(semiprimes.get(i));
		}
	*/	
		System.out.println("Primes: " + primes.size());
		System.out.println("Total: " + total);
	}
	
	/**
	 * create generic BigInteger from int x
	 * @param x
	 * @return
	 */
	/*
	public static BigInteger big(int x){
		BigInteger y = new BigInteger (Integer.toString(x));
		return y;
	}
	*/
	
	/**
	 * check if prime
	 */
	public static boolean isPrime(long x){
		if (x%2==0){
			return false;
		}
		for (long i = 3 ; i <= Math.sqrt(x) ; i+=2){
			if (x%i == 0){
				return false;
			}
		}
		return true;
		
		/*
		if(x.isProbablePrime(1000000)){
			return true;
		}
		return false;
		*/
	}

}
