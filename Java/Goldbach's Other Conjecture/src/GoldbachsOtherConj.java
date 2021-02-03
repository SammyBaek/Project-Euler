import java.util.ArrayList;
public class GoldbachsOtherConj {
	public static void main (String [] args){
		
		ArrayList <Integer> primes = new ArrayList < Integer > ();
		/**
		 * Enter primes < 100_000
		 */
		for (int i = 2 ; i < 100_000 ; i++){
			if (isPrime(i)){
				primes.add(i);
			}
		}
		
		// First odd composite number
		int i = 9;
		/**
		 * Keeps on running through all the odd numbers
		 * until the innermost loop can't find a match of the pattern
		 */
		main:
		while (true){
			if (!isPrime(i)){
				/**
				 * Second:
				 */
				second:
				for (int j = 0 ; j < 1000; j++){
					for (int k = 1 ; k < primes.size() ; k++){
						/**
						 * if matched, then get out of the "Second" loop
						 */
						if (i == primes.get(k) + 2*j*j){
							System.out.println(i);
							break second;
						}
						/**
						 * if the matching prime gets too big,
						 * break out of primes loop
						 * and go to increase the "j" by one
						 */
						if (primes.get(k) > i){
							break;
						}
					}
					/**
					 * if 2*j*j is greater than i,
					 * by this point, both the the prime and 2*j*j are
					 * both larger than i,
					 * and also hasn't been matched,
					 * therefore the i is the lowest that can't be matched
					 */
					if (2*j*j > i){
						System.out.println(i);
						break main;
					}
				}
			}
			i += 2;
		}
	}
	
	public static boolean isPrime(int x){
		for (int i = 2 ; i <= Math.sqrt(x) ; i++){
			if (x%i ==0) return false;
		}
		return true;
	}

}