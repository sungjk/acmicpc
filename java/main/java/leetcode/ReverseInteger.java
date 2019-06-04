package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 2019-06-04.
 */
public class ReverseInteger {

    // Assume that your function returns 0 when the reversed integer overflows.
    public static int reverse(int x) {
        if (isOverflow(x)) {
            return 0;
        }

        long reversed = reverse(Math.abs(x), getDigits(Math.abs(x)));
        if (isOverflow(reversed)) {
            return 0;
        }
        return x > 0 ? (int) reversed : -1 * (int) reversed;
    }

    // digits: 10의 자리수(1, 10, 100, 1000, ...)
    public static long reverse(long x, int digits) {
        if (digits == 0) return x;
        return (x % 10) * digits + reverse(x / 10, digits / 10);
    }

    public static int getDigits(int x) {
        if (x < 10) return 1;
        return 10 * getDigits(x / 10);
    }

    public static boolean isOverflow(long x) {
        return x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE;
    }

    public static class UnitTest {
        @Test
        public void test() {
            int x = 123;
            assertEquals(321, reverse(x));
        }

        @Test
        public void test2() {
            int x = -123;
            assertEquals(-321, reverse(x));
        }

        @Test
        public void test3() {
            int x = 120;
            assertEquals(21, reverse(x));
        }

        @Test
        public void test4() {
            int x = 0;
            assertEquals(0, reverse(x));
        }

        @Test
        public void test5() {
            int x = 1056389759;
            assertEquals(0, reverse(x));
        }

        @Test
        public void test6() {
            int x = -2147483648;
            assertEquals(0, reverse(x));
        }
    }

}
