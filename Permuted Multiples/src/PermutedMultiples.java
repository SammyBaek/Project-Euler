import java.util.Arrays;

/**
 * Created by kie827 on 6/8/2016.
 * Project Euler #52
 */
public class PermutedMultiples {
    public static void main(String[] args) {

        for (int i = 1 ; true ; i ++){
            System.out.println(i);
            if (isPermuted(i)){
                System.out.println("FOUND: " + i);
                break;
            }
        }
    }

    private static boolean isPermuted(int num){
        for (int i = 2 ; i <= 6 ; i ++)
            if (!isPermuted(num, num*i))
                return false;
        return true;
    }

    private static boolean isPermuted(int a, int b){
        char[] x = Integer.toString(a).toCharArray();
        char[] y = Integer.toString(b).toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return (new String(x)).equals(new String(y));
    }
}
