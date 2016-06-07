import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;

public class Fib {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Number of digits:");
		int dig = in.nextInt();
		in.close();
		
		
		ArrayList<BigInteger> fib = new ArrayList<BigInteger>();
		BigInteger one = new BigInteger("1");
		fib.add(one);
		fib.add(one);
		int count = 1;
		String s = "1";
		for (int i = 0; i < dig-1 ; i ++){
			s += "0";
		}
		
		while(fib.get(count).toString().length() < s.length()){
			fib.add(fib.get(count).add(fib.get(count-1)));
			count++;
			System.out.println(fib.get(count));
		}
		System.out.println("index: " + (count+1) + "\nfib number: " + fib.get(count));
		

		
	}

}
