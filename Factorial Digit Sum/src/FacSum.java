import java.util.Scanner;
import java.math.*;

public class FacSum {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number: ");
		BigInteger digit = new BigInteger (in.next());
		in.close();
		
		String s = fac(digit).toString();
		String [] str = s.split("");
		int total = 0;
		for (int i = 0; i < str.length; i++){
			total += Integer.parseInt(str[i]);
		}
		System.out.println(s);
		System.out.println(total);
	}
	
	public static BigInteger fac(BigInteger x){
		BigInteger one = new BigInteger("1");
		if (x.equals(one)){
			return x;
		}
		return x.multiply(fac(x.subtract(one)));
	}

}
