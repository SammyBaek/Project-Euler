import java.util.Scanner;

public class PyTrip {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
				
		for (int a = 1; a < 1000 ; a ++){
			for (int b = 1; b < 1000 ; b++){
				if (isPythTrip(a,b) && (a+b+findHyp(a,b) == 1000)){
					int c = findHyp(a,b);
					System.out.println("A: " + a + "\nB: " + b + "\nC: " + c);
					System.out.println("abc: " + a*b*c);
				}
			}
		}
		
		in.close();
	}
	
	public static boolean isPythTrip(int a, int b){
		for(int i = 1; i < a+b ; i ++){
			if (a*a + b*b == i*i){
				return true;
			}
		}
		return false;
	}
	
	public static int findHyp(int a , int b){
		for (int i = 1; i < a+b ; i ++){
			if (a*a + b*b == i * i){
				return i;
			}
		}
		return 0;
	}

}
