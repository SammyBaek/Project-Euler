/**
 * Created by kie827 on 6/8/2016.
 * Project Euler #24
 */
public class LexiPer {
    private static int count;
    private static String specific;
    public static void main(String[] args) {
        count = 1;
        permute("");
        System.out.println(specific);
    }

    private static void permute(String current){
        if (current.length() == 10) {
            if (count == 1000000)
                specific = current;
            System.out.println(count++ + " " + current);
            return;
        }

        for (int i = 0 ; i <= 9 ; i ++){
            String s = Integer.toString(i);
            if (!current.contains(s))
                permute(current+s);
        }
    }
}
