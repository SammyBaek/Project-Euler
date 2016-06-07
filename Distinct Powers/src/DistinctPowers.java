import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.math.BigInteger;

public class DistinctPowers {
	public static void main (String [] args){
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter a: ");
		int a = scan.nextInt();
		System.out.println("Enter b: ");
		int b = scan.nextInt();
		scan.close();
		
		ArrayList<String> list = new ArrayList <String> ();
		for (int i = 2 ; i <= a ; i ++){
			for (int j = 2 ; j <= b ; j ++){
				list.add(big(i).pow(j).toString());
				System.out.println(list.get(list.size()-1));
			}
		}
		Collections.sort(list);
		// Run the remove sequence 5 times to make sure
		for (int j = 0 ; j < 5 ; j ++){
			for (int i = 0 ; i < list.size()-1 ; i ++){
				if (list.get(i).equals(list.get(i+1))){
					list.remove(i+1);
				}
			}
		}	
		System.out.println("\n\n");
		for (int i = 0 ; i < list.size() ; i++){
			System.out.println(list.get(i));
		}
		System.out.println("total:  " + list.size());

	}
	
	public static BigInteger big(int x){
		BigInteger y = new BigInteger (Integer.toString(x));
		return y;
	}

}
