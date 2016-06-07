import java.math.BigInteger;
import java.util.Scanner;

public class LatticePaths {
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter x: ");
		BigInteger x = new BigInteger(in.next());
		System.out.println("Enter y: ");
		BigInteger y = new BigInteger(in.next());
		in.close();
		
		System.out.println("There are " + numberPaths(x,y) + " paths");
		
	}
	
	public static BigInteger numberPaths(BigInteger x, BigInteger y){
		return fib(x.add(y)).divide(fib(x)).divide(fib(y));
	}
	public static BigInteger fib(BigInteger l){
		BigInteger one = new BigInteger("1");
		if (l.equals(one)){
			return l;
		}
		return fib(l.subtract(one)).multiply(l);
	}
	

}