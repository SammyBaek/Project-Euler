import java.util.Scanner;

public class AmicableNums {
	public static void main(String []args){
		
		Scanner in = new Scanner (System.in);
		System.out.println("Enter max amicable num: ");
		int max = in.nextInt();
		in.close();
		int sum = 0;
		for (int i = 2; i < max ; i ++){
			if (div(div(i)) == i && div(i) != i){
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println("Sum: " + sum);
		
	}
	
	public static int div(int x){
		int sum = 0;
		for (int i = 1 ; i < x ; i ++){
			if (x%i == 0){
				sum += i;
			}
		}
		return sum;
	}
}
