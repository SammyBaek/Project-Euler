import java.util.ArrayList;
import java.util.Collections;

public class Palin {
	public static void main(String[] args){
		ArrayList <Integer> palins = new ArrayList <Integer>();
		for (int i = 100; i<1000 ; i++){
			for (int j = 100 ; j<1000 ; j++){
				if(isPalin(i*j)){
					palins.add(i*j);
//					System.out.println(i*j);
				}
			}
		}
		Collections.sort(palins);
		System.out.println(palins.get(palins.size()-1));
	}
	
	public static boolean isPalin(int n){
		String s = Integer.toString(n);
		String [] x = s.split("");
		for (int i = 0; i < x.length/2 ; i ++){
			if (!(x[i].equals(x[x.length-i-1]))){
				return false;
			}
		}
		
		return true;
		
	}

}