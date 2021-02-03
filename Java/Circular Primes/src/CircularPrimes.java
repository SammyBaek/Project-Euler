
public class CircularPrimes {
	public static void main (String [] args){
		int count = 0;

		for (int i = 2 ; i < 1_000_000 ; i++){
			if (isPrime(i) && isRotational(i)){
				System.out.print("YES: ");
				count++;
			}
			else{
				System.out.print("NO: ");
			}
			System.out.println(i);
		}
		System.out.println("Count: " + count);
	}
	
	public static boolean isPrime(int x){
		for (int i = 2 ; i <= Math.sqrt(x) ; i++){
			if (x%i ==0) return false;
		}
		return true;
	}
	
	public static boolean isRotational(int x){
		String str = Integer.toString(x);
		String [] s = str.split("");
		for (int i = 0 ; i < s.length ; i++){
			String check = "";
			for (int j = 0 ; j < s.length ; j++){
				int index = i+j;
				if (i+j >= s.length){
					index = (i+j)%s.length;
				}
				check += s[index];
			}
			if (!isPrime(Integer.parseInt(check))) return false;
		}
		return true;
	}

}
