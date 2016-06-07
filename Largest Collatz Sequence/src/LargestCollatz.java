import java.util.Scanner;

public class LargestCollatz {
	public static void main (String [] args){
		
		Scanner in = new Scanner (System.in);
		System.out.println("Max test?");
		int max = in.nextInt();
		in.close();
		
		long m = 0;
		long largest = 0;
		for (long i = 1; i < max ; i++){
			long count = Collatz(i,1);
			if (count>m){
				m = count;
				largest = i;
			}
			System.out.println("i: " + i + " " + count);
		}
		System.out.println("Max Chain: " + largest + "\nCount: " + m);
	}
	
	public static long Collatz(long x, long total){
		if (x%2 == 0){
			total++;
			return Collatz(x/2, total);
		}
		if (x%2 ==1 && x!=1){
			total++;
			return Collatz(3*x+1, total);
		}
		return total;
	}
}