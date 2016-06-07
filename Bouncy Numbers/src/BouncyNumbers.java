import java.util.Scanner;

public class BouncyNumbers {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Enter proportion: ");
		double prop = in.nextDouble();
		in.close();
		
		int nonBouncy = 0;
		int bouncy = 0;
		int lastNum = 0;
		for (int i = 1 ; i< Integer.MAX_VALUE ; i++){
			if (isIncreasing(i)){
				nonBouncy++;
			}
			else if (isDecreasing(i)){
				nonBouncy++;
			}
			else{
				bouncy++;
			}
			
			if ((double)bouncy/(nonBouncy+bouncy) >= prop){
				lastNum = i;
				break;
			}
		}
		
		System.out.println("Last Num: " + lastNum);
	
	}
	
	public static boolean isIncreasing(int x){
		String str = Integer.toString(x);
		for (int i = 0; i < str.length()-1; i++){
			if (str.charAt(i) > str.charAt(i+1)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isDecreasing(int x){
		String str = Integer.toString(x);
		for (int i = 0; i < str.length()-1; i++){
			if (str.charAt(i) < str.charAt(i+1)){
				return false;
			}
		}
		return true;
	}


}
