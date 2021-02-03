
public class DoubleBasePalins {
	public static void main (String [] args){

		int count = 0;
		for (int i = 1; i < 1_000_000 ; i++){
			if (isPal(Integer.toString(i)) && isPal(Integer.toBinaryString(i))){
				System.out.println(i);
				count += i;
			}
		}
		System.out.println("Count: " + count);
	}
	
	public static boolean isPal(String str){
		for (int i = 0 ; i < str.length()/2 ; i ++){
			if (str.charAt(i) != str.charAt(str.length()-i-1)){
				return false;
			}
		}
		return true;
	}

}
