import java.util.ArrayList;
import java.util.Collections;

public class PrimePowerTrips {
	public static void main (String [] args){
		ArrayList <Integer> primes = new ArrayList <Integer> ();
		/**
		 * Inputing all the primes under 10_000
		 */
		for (int i = 2 ; i < 10_000 ; i ++){
			if (isPrime (i)){
				primes.add(i);
			}
		}
		
		ArrayList <Integer> list = new ArrayList <Integer> ();
		for (int a = 0 ; a < primes.size() ; a++){
			for (int b = 0 ; b < primes.size() ; b++){
				for (int c = 0 ; c < primes.size() ; c++){
					int test = (int) (Math.pow(primes.get(a),2) + Math.pow(primes.get(b),3) + Math.pow(primes.get(c),4));
					if (test < 50_000_000 && test >0){
						list.add(test);
						System.out.println(a+" "+b+" "+c+"   " + test);
					}
					else break;
				}
			}
		}
		
		System.out.println("Size: " + list.size());
		Collections.sort(list);
		for (int x = 0 ; x < 10 ; x++){
			for (int i = 0 ; i < list.size()-1; i++){
				if (list.get(i).equals(list.get(i+1))){
					list.remove(i+1);
				}
			}
		}
		
		System.out.println("Size: " + list.size());

	}
	
	/**
	 * Check if int is prime
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x){
		for (int i = 2 ; i < x ; i ++){
			if (x%i==0) return false;
		}
		return true;
	}

}
