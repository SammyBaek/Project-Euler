import java.util.Scanner;
import java.util.ArrayList;

public class Prime {
	public static void main (String [] args){
		ArrayList <Integer> list = new ArrayList <Integer> ();
		Scanner in = new Scanner (System.in);
		System.out.println("Enter: ");
		int max = in.nextInt();
//		list.add(2);
		for (int i = 2; i <= Integer.MAX_VALUE ; i ++){
			if (isPrime(i)){
				list.add(i);
				/*System.out.print(list.size() + ": ");
				System.out.println(i);
				*/
				if(list.size() == max){
					break;
				}
			}
		}
		System.out.print(max + " prime is: \n" + list.get(max-1));		
		in.close();
	}
	
	public static boolean isPrime(int x){
		
		for (int i =2 ; i <= Math.sqrt(x) ; i ++ ){
			if (x%i==0){
				return false;
			}
		}
		return true;
	}
}
