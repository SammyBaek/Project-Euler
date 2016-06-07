
public class NonMersennePrime {
	public static void main (String [] args){
		long total = 1;
		for (int i = 1 ; i <= 7_830_457 ; i ++){
			total *= 2;
			if (total > 1_000_000_000){
				String str = Long.toString(total);
				String s = str.substring(str.length() - 10);
				total = Long.parseLong(s);	

			}
			System.out.println(i + " " + total);
		}
		total *= 28_433;
		total += 1;
		String str = Long.toString(total);
		String s = str.substring(str.length() - 10);
		total = Long.parseLong(s);	
		System.out.println("FINAL: " + total);
	}
}