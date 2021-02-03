import java.util.Scanner;
import java.math.BigInteger;

public class CombSelec {
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter min number: ");
		int min = in.nextInt();
		in.close();
		
		int count = 0;	
		for (int i = 2 ; i <= 100 ; i++){
			for (int j = 1; j < i ; j++){
				if (Double.parseDouble(comb(big(i),big(j)).toString()) > min){
					count ++;
				}
				System.out.println(i + " " + j + " " + comb(big(i),big(j)));
			}
		}
		System.out.println("count: " + count);		
		
	}
	public static BigInteger comb(BigInteger x, BigInteger y){
		return perm(x).divide(perm(y)).divide(perm(x.subtract(y)));
	}
	
	public static BigInteger perm(BigInteger x){
		if (x.equals(big(1))){
			return big(1);
		}
		return x.multiply(perm(x.subtract(big(1))));
	}
	
	public static BigInteger big(int x){
		BigInteger y = new BigInteger (Integer.toString(x));
		return y;
	}

}
