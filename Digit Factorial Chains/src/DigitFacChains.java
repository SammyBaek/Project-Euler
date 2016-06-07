import java.util.ArrayList;
public class DigitFacChains {
	public static void main (String [] args){
		int target = 0;
		for (int i = 69 ; i < 1_000_000 ; i ++){
			ArrayList <Integer> list = new ArrayList <Integer> ();
			boolean flag = true;
			int x = i;
			int count = 0;
			list.add(i);
			main:
			while (flag){
				int check = sumFac(x);
				list.add(check);
				count++;
				for (int j = 0 ; j < list.size()-1; j ++){
					if (check == list.get(j)){
						break main;
					}
				}
			x = check;
			}
			System.out.println(i + ": " + count);
			if (count == 60){
				target++;
			}
		}
		System.out.println("GOAL: There are " + target + " numbers with 60 terms");
		
	}
	
	public static int chain (int org, int x, int count){
		int check = sumFac(x);
		count++;
		if (check == org){
			return ++count;
		}
		return chain(org, check, count);
	}
	
	public static int getChain (int x){
		return 0;
	}
	
	/**
	 * Breaks up the integer into each digits
	 * then sum up the factorial of each digits
	 * @param x
	 * @return
	 */
	public static int sumFac(int x){
		String str = Integer.toString(x);
		int total = 0;
		for (int i = 0 ; i < str.length() ; i ++){
			total += fac(Integer.parseInt(str.substring(i, i+1)));
		}
		return total;
	}
	
	/**
	 * Calculate the factorial of an integer
	 * @param x
	 * @return
	 */
	public static int fac(int x){
		if (x == 0) return 1;
		if (x == 1) return 1;
		return x*fac(x-1);
	}

}
