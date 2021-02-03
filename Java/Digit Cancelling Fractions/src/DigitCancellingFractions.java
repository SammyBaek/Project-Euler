/**
 * Created by kie827 on 6/16/2016.
 * Project Euler #33
 */
public class DigitCancellingFractions {
    public static void main(String[] args) {

        for (int den = 11 ; den <= 99 ; den ++){
            for (int num = 10 ; num < den ; num ++){
                if ((double) num / den == cancel(num, den)){
                    System.out.println(num + "   " + den);
                }
            }
        }
        System.out.println();
        int top = 16 * 26 * 19 * 49;
        int bot = 64 * 65 * 95 * 98;
        int gcd = getGCD(bot, top);
        System.out.println(top + " " + bot + " " + gcd);
        System.out.println((top % gcd) +  " " + (bot % gcd));
        System.out.println((top / gcd) + " " + (bot / gcd));

    }

    private static double cancel(int num, int den){
        String origNum = Integer.toString(num);
        String origDen = Integer.toString(den);
        char[] n = Integer.toString(num).toCharArray();
        char[] d = Integer.toString(den).toCharArray();
        for (int i = 0 ; i < n.length ; i ++){
            for (int j = 0 ; j < d.length ; j ++){
                if (n[i] == d[j] && n[i] != 'X'){
                    n[i] = 'X';
                    d[j] = 'X';
                }
            }
        }
        String top = "";
        for (char c : n)
            if (c != 'X')
                top += c;
        String bot = "";
        for (char c : d)
            if (c != 'X')
                bot += c;
        if (top.isEmpty() || bot.isEmpty() || (origDen.equals(bot) && origNum.equals(top)))
            return -1;
        if (origDen.contains("0") && origNum.contains("0"))
            return -1;
        return Double.parseDouble(top) / Double.parseDouble(bot);
    }

    private static int getGCD(int a, int b){
        if (b == 0)
            return a;
        return getGCD(b, a%b);
    }
}