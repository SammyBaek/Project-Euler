/**
 * Created by Sam Baek on 4/28/2017.
 */
public class NumLetterCount {
    private static final String[] DIGITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String HUNDRED = "hundred";
    private static final String AND = "and";

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            count += getCount(i);
        }
        count += "onethousand".length();
        System.out.println(count);
        System.out.println(getCount(100));
    }

    private static int getCount(int num) {
        int count = 0;
        int hundreds = num / 100;
        int tens = num / 10 % 10;
        int ones = num % 10;
        String result = "";

        if (tens < 2) {
            count += DIGITS[tens * 10 + ones].length();
            result = DIGITS[tens * 10 + ones];
        } else {
            count += TENS[tens].length() + DIGITS[ones].length();
            result = TENS[tens] + " " + DIGITS[ones];
        }

        if (hundreds != 0) {
            if (tens == 0 && ones == 0) {
                count += DIGITS[hundreds].length() + HUNDRED.length();
                result = DIGITS[hundreds] + " " + HUNDRED + " " + result;
            } else {
                count += DIGITS[hundreds].length() + HUNDRED.length() + AND.length();
                result = DIGITS[hundreds] + " " + HUNDRED + " " + AND + " " + result;
            }
        }
        System.out.println(hundreds + " " + tens + " " + ones + "    " + result);
        return count;
    }
}
