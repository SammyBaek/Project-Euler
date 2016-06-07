import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrimeFac {

	public static void main(String[] args) {
		
		ArrayList <Long> factors = new ArrayList<Long>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number: ");
		long num = input.nextLong();
		long i = 2;
		while (num >1){
			
			if ( num %i == 0){
				factors.add(i);
				num = num / i;
				i = 2; 
			}
			else {
				i++;
			}
		}
		
/*		for (Integer n: factors){
			System.out.println(n);
		}
*/		
		Collections.sort(factors);
		System.out.println(factors.get(factors.size()-1));
		input.close();
		
	}

}
