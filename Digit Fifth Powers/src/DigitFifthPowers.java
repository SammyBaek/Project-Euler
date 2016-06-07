public class DigitFifthPowers {
	public static void main (String [] args){
		int total = 0;
		for (int i = 2 ; i < 10_000_000 ; i ++){
			if (getPower(i) == i){
				System.out.println(i);
				total += i;
			}
		}
		System.out.println("Total: " + total);
	}
	
	public static int getPower(int x){
		String str = Integer.toString(x);
		int total = 0;
		for (int i = 0 ; i < str.length() ; i ++){
			total += Math.pow((str.charAt(i) - '0'),5);
		}
		return total;
	}

}