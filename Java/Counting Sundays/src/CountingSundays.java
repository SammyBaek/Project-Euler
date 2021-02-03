/**
 * Created by Sam Baek on 1/17/2017.
 */
public class CountingSundays {
    private static final int START_YEAR = 1901;
    private static final int END_YEAR = 2000;

    public static void main(String[] args) {
        int count = 0;
        for (int year = START_YEAR; year <= END_YEAR; year++) {
            for (int month = 1; month <= 12; month++) {
                if (dayOfWeek(year, month, 1) == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * Tomohiko Sakamoto's algorithm in finding the day of the week
     * @param y - year
     * @param m - month
     * @param d - day
     * @return day of week {Sunday = 0, Monday = 1, ..., Saturday = 6}
     */
    private static int dayOfWeek(int y, int m, int d) {
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        y = y - (m < 3 ? 1 : 0);
        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
    }
}
