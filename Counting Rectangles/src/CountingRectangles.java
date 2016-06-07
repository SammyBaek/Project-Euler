import java.util.Scanner;

public class CountingRectangles {
	public static void main (String[] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Enter the closest number of rectangles: ");
		int rect = in.nextInt();
		in.close();
		int min = Integer.MAX_VALUE;
		String str = "";
		for (int x = 1 ; x < 200 ; x++){
			for (int y = 1 ; y < 200 ; y++){
				int k = numberOfRect(x,y);
				if (Math.abs(k-rect) < min){
					min = Math.abs(k-rect);
					str = Integer.toString(x) + " " + Integer.toString(y);
				}
				System.out.println(x +"X" + y + ": " + k);
			}
		}
		System.out.println("Closest Area: " + str);
	
	}
	
	public static int numberOfRect( int x , int y){
		int total = 0;
		for (int i = x ; i >=1 ; i--){
			for (int j = y ; j >=1 ; j--){
				total += i*j;
			}
		}
		return total;
	}

}
