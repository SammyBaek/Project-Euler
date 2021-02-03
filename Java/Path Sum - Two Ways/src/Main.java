import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kie827 on 1/6/2017.
 */
public class Main {
    private static int SIZE = 80;
    private static long[][] matrix;
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("matrix.txt"));
            matrix = new long[SIZE+1][SIZE+1];

            for (int i = 0; scan.hasNext(); i++) {
                String[] s = scan.nextLine().split(",");
                for (int j = 0; j < s.length; j++) {
                    matrix[i+1][j+1] = Integer.parseInt(s[j]);
                }
            }
            // pad exterior with Integer.MAX_VALUE
            for (int i = 0; i < SIZE+1; i++) {
                matrix[0][i] = Integer.MAX_VALUE;
                matrix[i][0] = Integer.MAX_VALUE;
            }
            matrix[0][1] = 0;
            print();

            for (int i = 2; i <= SIZE+1; i++) {
                for (int j = 1; j < i; j++) {
                    // calc
                    matrix[i-j][j] += Math.min(matrix[i-j-1][j], matrix[i-j][j-1]);
                }
            }
            for (int i = SIZE + 2; i <= SIZE*2; i++) {
                for (int j = 0; j < SIZE*2 - i + 1; j++) {
                    int a = SIZE - j;
                    int b = i - (SIZE - j);
                    matrix[a][b] += Math.min(matrix[a-1][b], matrix[a][b-1]);
                }
            }
            print();
            System.out.println();
            System.out.println("ANSWER: "  + matrix[SIZE][SIZE]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calc(int a, int b) {
        if (a == SIZE+1 || b == SIZE+1) {
            return;
        }
        matrix[a][b] += Math.min(matrix[a-1][b], matrix[a][b-1]);
        calc(a+1, b);
        calc(a, b+1);
    }

    private static void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", " );
            }
            System.out.println();
        }
        System.out.println();
    }
}
