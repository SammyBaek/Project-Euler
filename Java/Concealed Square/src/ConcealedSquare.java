import java.math.BigInteger;


public class ConcealedSquare {
	public static void main (String[] args){

		/*
		 * Since the last digit is always 0
		 * increase it by 10?
		 * 
		 * Length of 19 starts: 999_999_000
		 * Max possible at: 1_450_000_000
		 * ... GOAL: 1_389_019_170
		 * 
		 * Already checked up to: 1_005_995_899
		 */
		for (BigInteger i = big(1_005_995_800) ;
			i.subtract(big(1_450_000_000)).signum() == -1;
			i = i.add(big(10)))
		{
			String x = i.pow(2).toString();
			System.out.print(i + ": " + x);
			if (isLength(x)){
				System.out.print("   Length Same");
				if (isMatching(x)){
					System.out.println("\nGOAL: \n" + i + ": " + x);
					break;
				}
			}
			System.out.println();
		}
	}
	
	public static boolean isLength(String str){
		if(str.length() == 19) return true;
		return false;
	}
	
	public static boolean isMatching (String str){
		if (str.charAt(0) != '1') return false;
		if (str.charAt(2) != '2') return false;
		if (str.charAt(4) != '3') return false;
		if (str.charAt(6) != '4') return false;
		if (str.charAt(8) != '5') return false;
		if (str.charAt(10) != '6') return false;
		if (str.charAt(12) != '7') return false;
		if (str.charAt(14) != '8') return false;
		if (str.charAt(16) != '9') return false;
		if (str.charAt(18) != '0') return false;
		return true;
	}
	
	public static BigInteger big(int x){
		BigInteger y = new BigInteger(Integer.toString(x));
		return y;
	}
}