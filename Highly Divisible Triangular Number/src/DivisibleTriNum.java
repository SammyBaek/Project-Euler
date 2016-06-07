import java.util.Scanner;

public class DivisibleTriNum {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("How many divisors?");
		int min = in.nextInt();
		in.close();
		
		//System.out.println(findDiv(28));
		int tri = 0;
		int i = 1;
		while (tri < Integer.MAX_VALUE){
			tri += i;
			int k = findDiv(tri);
			System.out.println("k: " + k + " " + tri);
			if (k>min){
				System.out.println("Result: " + tri);
				break;
			}
			i++;
		}
		/*
		for (int i =1 ; i < Integer.MAX_VALUE ; i ++){
			if (isTriangular(i)){
				int k = findDiv(i);
				System.out.println("k: " + k + " " + i);
				if(k > min){
					System.out.println("Result: " + i);
					break;
				}
			}
		}
		*/
		
	}
	
	/*
	public static boolean isTriangular(int x){
		int total = 0;
		for (int i = 1; i < x/2+1 ; i++){
			total += i;
			if (total == x){
				return true;
			}
		}
		return false;
	}
	*/
	
	public static int findDiv(int x){
		int total = 0;
		for (int i = 1 ; i <=Math.sqrt(x) ; i ++){
			if (x%i == 0){
				total ++;
			}
		}
		return total*2;
	}

}