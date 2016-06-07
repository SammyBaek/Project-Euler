import java.util.ArrayList;

public class ChampernowneConstant {
	public static void main (String [] args){
		ArrayList <Integer> list = new ArrayList <Integer> ();
		for (int i = 0 ; i < 1000000 ; i ++){
			String str = Integer.toString(i);
			String [] s = str.split("");
			for (int j = 0 ; j < str.length(); j++){
				list.add(Integer.parseInt(s[j]));
			}
		}
		
		int mult = 1;
		mult *= list.get(1);
		mult *= list.get(10);
		mult *= list.get(100);
		mult *= list.get(1000);
		mult *= list.get(10000);
		mult *= list.get(100000);
		mult *= list.get(1000000);
		System.out.println(mult);


	}

}