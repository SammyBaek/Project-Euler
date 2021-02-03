
public class PandigitalMultiples {
	public static void main (String [] args){
		int m1 = 0;
		int m2 = 0;
		int max = 0;
		for (int i = 1 ; i <= 9876543 ; i++){
			String str = "";
			for (int j = 1 ; j < 10 ; j++){
				str += Integer.toString(i*j);
				if (str.length() > 9) break;
				if (j != 1 && str.length() == 9){
					if (isPan(str)){
						System.out.println(str);
						if (Integer.parseInt(str) > max){
							max = Integer.parseInt(str);
							m1 = j;
							m2 = i;
						}
					}
				}
			}
		//	System.out.println(str);
		}
		System.out.println("max:  " + max);
		System.out.println("m1: " + m1 + "\nm2: " + m2);
		
	}
	
	public static boolean isPan(String str){
		if (str.length() != 9){
			return false;
		}
		for (int i = 1 ; i <=9 ; i++){
			if (!str.contains(Integer.toString(i))){
				return false;
			}
		}
		return true;
	}
}