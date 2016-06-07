import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class CodedTriNumbs {
	public static void main (String [] args) throws IOException{
		Scanner in = new Scanner (new File ("words"));
		ArrayList <Integer> triList = new ArrayList <Integer> ();
		for (int i = 1 ; i < 250 ; i++){
			triList.add(seq(i));
		}
		String biglist = in.next();
		in.close();
		String [] list = biglist.split("\",\"");
		int total = 0;
		for (int i = 0 ; i < list.length ; i++){
			int val = 0;
			for (int j = 0 ; j < list[i].length(); j++){
				val += list[i].charAt(j) - 'A' + 1;
			}
			for (int k = 0 ; k < triList.size(); k++){
				if (val == triList.get(k)){
					total ++;
					break;
				}
			}
		}
		System.out.println(total);
		
	}
	
	public static int seq(int x){
		double y = .5*(x)*(x+1);
		return (int)y;
	}

}