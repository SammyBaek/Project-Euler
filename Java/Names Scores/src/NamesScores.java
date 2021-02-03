import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class NamesScores {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new File("names"));
		String str = in.next();
		in.close();
		String [] names = str.split("\",\"");
		Arrays.sort(names);
		long scores = 0;
		for (int i = 0 ; i < names.length ; i ++){
			scores += getScore(names[i], i+1);
			System.out.println((i+1) + ": " + names[i] + " " + getScore(names[i],i+1));
		}
		System.out.println("Total Score: " + scores);
		
	}
	
	public static int getScore(String str, int x){
		int sum = 0;
		for (int i = 0 ; i < str.length() ; i ++){
			sum += str.charAt(i) - 'A' +1;
		}
		return x*sum;
	}

}
