/**
 * Created by Salin on 6/7/2016.
 */


public class IntRightTriangles {
    public static void main(String[] args) {
        int[] numTriangles = new int[1001];
        for (int a = 1 ; a < 1000 ; a++){
            for (int b = a+1 ; b < 1000 ; b++){
                double c = Math.sqrt(a*a + b*b);
                // check if pythagorean theorem applies
                if (c - ((int)c) < 1e-5){
                    System.out.println(a + " " + b + " " + c);
                    // check if it is triangle
                    int d = (int) c;
                    if (a+b > d && a+d > b && b+d > a){
                        int perimeter = a + b + d;
                        if (perimeter <= 1000)
                            numTriangles[perimeter]++;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1 ; i < numTriangles.length ; i ++){
            if (numTriangles[i] > numTriangles[max])
                max = i;
        }
        System.out.println(max + ": " + numTriangles[max]);
    }

}
