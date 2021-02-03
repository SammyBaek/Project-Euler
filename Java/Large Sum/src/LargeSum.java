import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;
import java.io.*;

public class LargeSum {
	public static void main (String[] args) throws IOException{
	
		Scanner in = new Scanner (new File("numbers"));
		ArrayList <BigInteger> numbers = new ArrayList <BigInteger>();
		while(in.hasNextLine()){
			numbers.add(bigS(in.next()));
		}
		in.close();
		BigInteger sum = new BigInteger("0");
		for(int i = 0 ; i < numbers.size(); i ++){
			sum = sum.add(numbers.get(i));
		}
		System.out.println("Sum: " + sum);
		String s = sum.toString();
		int digits = s.length();
		System.out.println("First 10 digits: " + sum.divide(bigS("10").pow(digits-10)));
		
	}
	
	public static BigInteger bigS(String str){
		BigInteger x = new BigInteger(str);
		return x;
	}
}