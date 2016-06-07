
public class PandigitalPrime {
	public static void main (String [] args){
	
		/*
		 * The program might seem to stop working
		 * but there are hardly any primes and pandigital after 7_000_000
		 * so wait like 5 min
		 */
		int max = 0;
		for (int i = 1 ; i <1000000000 ; i ++){
			if (isPan(i) && isPrime(i)){
				System.out.println(i);
				max = i;
			}
		}
		System.out.println("max: " + max);
	}
	
	public static boolean isPan(int x){
		String str = Integer.toString(x);
		for (int i = 1 ; i <= str.length() ; i++){
			if (!str.contains(Integer.toString(i))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int x){
		for (int i = 2 ; i <= Math.sqrt(x) ; i ++){
			if (x%i  == 0){
				return false;
			}
		}
		return true;
	}
}