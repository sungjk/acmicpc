package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jeremy on 2020/12/22.
 */
public class DailyTemperatures {
//    	1001 ms	47.2 MB
    public int[] dailyTemperatures(int[] T) {
        int[] days = new int[T.length];
        Arrays.fill(days, 0);

        for (int i = 0; i < T.length; i++) {
            int count = 0;
            int end = 0;
            for (int j = i + 1; j < T.length; j++) {
                count++;
                if (T[j] > T[i]) {
                    end = 1;
                    break;
                }
            }
            if (end == 1) {
                days[i] = count;
            }
        }

        return days;
    }

    public void print(int[] t) {
        for (int tt : t) {
            System.out.print(tt + " ");
        }
        System.out.println();
    }

    public static class UnitTest {
        private final DailyTemperatures dt = new DailyTemperatures();

        @Test
        public void test() {
            int[] given = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
            int[] expected = new int[] {1, 1, 4, 2, 1, 1, 0, 0};
            assertArrayEquals(expected, dt.dailyTemperatures(given));
        }
    }
}
