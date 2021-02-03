import java.util.Scanner;

public class NumSpiralDiags {
	public static void main (String [] args){
		/*
		 * This problem goes in the pattern of 
		 * every group of i*4 and i += 2
		 */
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter max: ");
		int max = scan.nextInt();
		scan.close();
		/*
		 * Problem max = 1_002_001
		 */
		int i = 1;
		int total = 1;
		int b = 2;

		main:
		while (i <= max){
			for (int a = 1 ; a <= 4 ; a++){
				System.out.println(i);
				if (i >= max) break main;

				total += i + b;
				i += b;
			}
			b += 2;
		}
		System.out.println(total);
	}

}
