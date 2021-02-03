import java.util.Scanner;

public class SumPrimes {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Enter max: ");
		int max = in.nextInt();
		long total = 0;
		for (int i = 2; i < max ; i++){
			if (isPrime(i)){
				total += i;
				System.out.println(i);
			}
		}
		System.out.println("Total is: " + total);
		
		in.close();
	}
	
	public static boolean isPrime (int x){
		for (int i = 2 ; i <= Math.sqrt(x) ; i ++){
			if (x%i == 0){
				return false;
			}
		}
		return true;
	}
}
