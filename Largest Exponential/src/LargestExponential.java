import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

public class LargestExponential{
	public static void main (String [] args) throws IOException{
		Scanner in = new Scanner ( new File ("base_exp"));
		double maxCompare = 0;
		int maxBase = 0;
		int maxExp = 0;
		int i = 1;
		int linei = 1;
		while (in.hasNextLine()){
			String str = in.nextLine();
			String [] s = str.split(",");
			double base = Double.parseDouble(s[0]);
			double exp = Double.parseDouble(s[1]);
			double compare = exp*Math.log(base);
			if (compare > maxCompare){
				maxCompare = compare;
				maxBase = (int)base;
				maxExp = (int)exp;
				linei = i;
			}
			System.out.println(i + " " + str);
			i++;
		}
		in.close();
		System.out.println("max: " + maxBase + " " + maxExp);
		System.out.println(linei);

	}
	
	public static BigInteger big(int x){
		return new BigInteger(Integer.toString(x));
	}
}