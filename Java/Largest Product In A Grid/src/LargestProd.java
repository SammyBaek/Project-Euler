import java.util.Scanner;
import java.io.*;

public class LargestProd {
	public static void main (String [] args) throws IOException{
		
		Scanner in = new Scanner (new File("grid"));
		int [][] grid = new int [20][20];
		
		for (int i = 0 ; i < 20 ; i++){
			for (int j = 0 ; j < 20 ; j++){
				grid [j][i] = in.nextInt();
			}
		}
		in.close();
		
		for (int i = 0 ; i < 20 ; i++){
			for (int j = 0 ; j < 20 ; j++){
				System.out.print(grid[j][i]+ " ");
			}
			System.out.println();
		}
		int product = 1;
		/*
		 * checks the left / right
		 */
		for (int i = 0 ; i < 20 ; i++){
			for (int j = 0 ; j < 16 ; j++){
				int n = grid[j][i]*grid[j+1][i]*grid[j+2][i]*grid[j+3][i];
				if(n>product){
					product = n;
					System.out.println(n);
				}
			}
		}
		/*
		 * checks up / down
		 */
		for (int i = 0 ; i < 16 ; i++){
			for (int j = 0 ; j < 20 ; j++){
				int n = grid[j][i]*grid[j][i+1]*grid[j][i+2]*grid[j][i+3];
				if(n>product){
					product = n;
					System.out.println(n);
				}
			}
		}
		/*
		 * checks diagonally top left to bottom right
		 */
		for (int i = 0 ; i < 16 ; i++){
			for (int j = 0 ; j < 16 ; j++){
				int n = grid[j][i]*grid[j+1][i+1]*grid[j+2][i+1]*grid[j+3][i+1];
				if(n>product){
					product = n;
					System.out.println(n);
				}
			}
		}
		/*
		 * checks diagonally top right to bottom left
		 */
		for (int i = 0 ; i < 16 ; i++){
			for (int j = 3 ; j < 20 ; j++){
				int n = grid[j][i]*grid[j-1][i+1]*grid[j-2][i+2]*grid[j-3][i+3];
				if(n>product){
					product = n;
					System.out.println(n);
				}
			}
		}
		
		System.out.println(product);
	}

}
