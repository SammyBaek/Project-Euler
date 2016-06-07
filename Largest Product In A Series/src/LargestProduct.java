import java.util.Scanner;
import java.io.*;

public class LargestProduct {
	public static void main (String [] args) throws IOException {
		Scanner in = new Scanner (new File ("series"));
		String st = "";
		while (in.hasNext()){
			st += in.next();
		}
		String [] s = st.split("");
		long max = 0;
		
		for (int i = 0; i < s.length-13 ; i++){
			long k = 1;
			for (int j = 0; j < 13; j++){
				k *= Integer.parseInt(s[i+j]);
			}
			if (k > max){
				max = k;
			}
		}
		System.out.println(max);
		in.close();
	}

}
