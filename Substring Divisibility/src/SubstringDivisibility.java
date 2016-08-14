public class SubstringDivisibility {
	
//	private static ArrayList<String> list;
	private static int count;
	private static long sum;
	private static final int[] divisor = {0, 2, 3, 5, 7, 11, 13, 17};
	
	public static void main (String[] args){
		System.out.println(hasSubstringDivisibilityProperty("1406357289"));
//		list = new ArrayList <String> ();
		generateAll("", "0123456789");
		/*
		for (String str : list){
			if (hasSubstringDivisibilityProperty(str)){
				count++;
			}
			System.out.println(str + " " + count);
		}
		System.out.println(list.size());
		*/
		System.out.println(count);
		System.out.println(sum);
	}
	
	private static boolean hasSubstringDivisibilityProperty(String str){
		for (int i = 1 ; i <= 7 ; i ++){
			if (Integer.parseInt(str.substring(i, i+3)) % divisor[i] != 0)
				return false;
		}
		return true;

	}
	
	private static void generateAll(String current, String remain){
		if (remain.length() == 0){
			if (hasSubstringDivisibilityProperty(current)){
				count++;
				sum += Long.parseLong(current);
			}
//			list.add(current);
		}
		else{
			for (int i = 0 ; i < remain.length() ; i++){
				generateAll(current+remain.charAt(i) , remain.substring(0, i) + remain.substring(i+1));
			}
		}
	}
	
	/*
	private static boolean isPan(String str){
		for (int i = 0 ; i <= 9 ; i ++){
			if (!str.contains(Integer.toString(i)))
				return false;
		}
		return true;
	}
	*/

}
