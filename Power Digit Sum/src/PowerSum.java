import java.math.*;
import java.util.Scanner;

public class PowerSum {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base: ");
		BigInteger base = new BigInteger(in.next());
		System.out.println("Enter exponent: ");
		int ex = in.nextInt();
		in.close();
		
		System.out.println(base + " " + ex);
		BigInteger result = base.pow(ex);
		String s = result.toString();
		String [] str = s.split("");
		int total = 0;
		for (int i = 0 ; i <s.length(); i++){
			total += Integer.parseInt(str[i]);
		}
		System.out.println("Result: " + total);
	}

}
