import java.util.Scanner;

public class SquareDigitChains {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Enterg max value: ");
		int max = in.nextInt();
	/*	
		boolean loop = true;
		int end = 0;
		while (loop){
			System.out.println("Enter end value (1 or 89): ");
			int e = in.nextInt();
			if (e == 1 || e == 89){
				loop = false;
				end = e;
			}
			else{
				System.out.println("Enter again: ");
			}
		}
	*/	
		in.close();
		int sum1 = 0;
		int sum89 = 0;
		for (int i = 1 ; i < max ; i ++){
			int j = chain(i);
			System.out.println(i + " " + j);
			if (j == 1){
				sum1 ++;
			}
			else if (j == 89){
				sum89++;
			}
		}
		System.out.println("Total 1: " + sum1 + "\nTotal 89: " + sum89);
		
	}
	
	public static int chain(int x){
		if (x == 1 || x == 89){
			return x;
		}
		else{
			return chain(square(x));
		}
	}
	
	public static int square(int x){
		String str = Integer.toString(x);
		String [] s = str.split("");
		int sum = 0;
		for (int i = 0 ; i < s.length ; i++){
			sum += Integer.parseInt(s[i])*Integer.parseInt(s[i]);
		}
		return sum;
	}
}