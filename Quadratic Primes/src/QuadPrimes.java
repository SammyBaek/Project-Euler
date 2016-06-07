
public class QuadPrimes {
	public static void main (String [] args){
		int [] count = new int [3];
		for (int a = -999 ; a < 1000 ; a++){
			for (int b = -999 ; b < 1000 ; b++){
				boolean bol = true;
				int i = 0;
				int c = 0;
				while (bol){
					System.out.print("a: " + a + "  " + "b: " + b + "  " + (i*i + a*i + b));
					System.out.println("   " + count[0] + " " + count[1] + " " + count[2]);
					if (!isPrime(i*i + a*i + b)){
						bol = false;
					}
					else {
						c++;
						i++;
						if (c > count[0] ){
							count[0] = c;
							count[1] = a;
							count[2] = b;
						}
					}
				}
			}
		}
	}
	
	public static boolean isPrime (int x){
		if (x < 0) return false;
		for (int i = 2 ; i <= Math.sqrt(x) ; i++){
			if (x%i == 0) return false;
		}
		return true;
	}

}
