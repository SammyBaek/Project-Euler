import java.util.ArrayList;

public class PandigitalProducts {
	public static void main (String [] args){
		ArrayList <Integer> list = new ArrayList <Integer> ();
		/*
		 * check every number up to 100,000
		 */
		for (int i = 4 ; i < 100_000 ; i++){
			/*
			 * check each multiplier 
			 */
			for (int j = 2 ; j <= Math.sqrt(i) ; j++){
				if (i%j == 0){
					String str = "";
					str = Integer.toString(j);
					str += Integer.toString(i/j);
					str += Integer.toString(i);
					if (isPan(str)){
						System.out.println(j + " * " + (i/j) + " : " + i);
						list.add(i);
					}
				}
			}
		}
	/*	SO THE ANSWER IS 45228
	 *  BUT THE COUNTING SYSTEM IS WRONG
	 *  SO I JUST ADDED ALL THE NON-IDENTIAL ELEMENTS
	 *  ON A CALCULATOR
	 */
		/*
		int sum = 0;
		for (int i = 0 ; i < list.size() -1 ; i++){
			if (list.get(i) != list.get(i+1)){
				sum += list.get(i);
			}
		}
		System.out.println(sum);
		/*
		 * last element
		 */
	/*	
		if (list.get(list.size()-2) != list.get(list.size()-1)){
			sum += list.get(list.size()-1);
		}
		System.out.println("size: " + list.size());

		System.out.println("sum: " + sum);
	*/	
	}
	
	public static boolean isPan(String x){
		if (x.length() != 9){
			return false;
		}
		for (int i = 1 ; i <= 9 ; i++){
			if (!x.contains(Integer.toString(i))){
				return false;
			}
		}
		return true;
	}

}