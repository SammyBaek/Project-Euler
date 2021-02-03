import java.math.BigInteger;

public class DigitSum {
	public static void main(String[] args){
		
		int max = 0;
		
		for (int i = 1 ; i < 100 ; i++){
			for (int j = 1 ; j < 100 ; j++){
				String str = big(i).pow(j).toString();
				String [] s = str.split("");
				int sum = 0;
				for (int k = 0 ; k < s.length ; k++){
					sum += Integer.parseInt(s[k]);
				}
				if (sum > max){
					max = sum;
				}
				System.out.println(str);

			}
		}
		System.out.println("max: " + max);
		
	}
	
	public static BigInteger big(int x){
		BigInteger y = new BigInteger (Integer.toString(x));
		return y;
	}

}
