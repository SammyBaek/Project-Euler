import java.util.Scanner;

public class SquareDiff {
	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Enter: ");
		int i = in.nextInt();
		System.out.println(SquareOfSum(i)-SumOfSquare(i));
		
		in.close();
	}
	
	public static int SquareOfSum(int x){
		int total = 0;
		for(int i = 1; i <= x; i ++){
			total += i;
		}
		return total * total;
	}
	
	public static int SumOfSquare(int x){
		int total = 0;
		for (int i = 1; i <= x; i ++){
			total += i*i;
		}
		return total;
	}
}
