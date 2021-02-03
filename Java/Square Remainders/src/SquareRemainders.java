public class SquareRemainders {
	public static void main (String [] args){

		long total = 0;
		for (long a = 3 ; a <= 1_000 ; a++){
			long max = 0;
			for (long n = 1; n <= 5_000 ; n++){
				long val = findRem(a,n)%(a*a);
				System.out.println(a + " " + n + "   " + val);
				if (val > max){
					max = val;
				}
			}
			total += max;
		}
		System.out.println("Total: " + total);
		
	}
	
	public static long findRem (long a, long n){
		return pow(a-1, n, a*a) + pow(a+1, n, a*a);
	}
	
	public static long pow(long a, long b, long c){
		if (b == 1) return a%c;
		return ((a%c) * pow(a, b-1, c))%c;
	}

}