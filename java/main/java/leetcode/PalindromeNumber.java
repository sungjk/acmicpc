package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jeremy on 2019-06-13.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) return true;
        if (x < 0 || x % 10 == 0) return false;
        return isPalindrome(x, 0);
    }

    // 12321 % 10 = 1   | 0 * 10 + 1 = 1
    // 1232 % 10 = 2    | 1 * 10 + 2 = 12
    // 123 % 10 = 3     | 12 * 10 + 3 = 123
    public static boolean isPalindrome(int x, int reversed) {
        if (x < reversed) return false;
        if (x == reversed) return true;

        int lastDigit = x % 10;
        int nextReversed = reversed * 10 + lastDigit;
        if (x == nextReversed) return true;
        return isPalindrome(x / 10, nextReversed);
    }

    public static class UnitTest {
        @Test
        public void test() {
            Assert.assertFalse(isPalindrome(-121));
        }

        @Test
        public void test2() {
            Assert.assertFalse(isPalindrome(10));
        }

        @Test
        public void test3() {
            Assert.assertFalse(isPalindrome(100));
        }

        @Test
        public void test4() {
            Assert.assertTrue(isPalindrome(0));
        }

        @Test
        public void test5() {
            Assert.assertTrue(isPalindrome(9));
        }

        @Test
        public void test6() {
            Assert.assertTrue(isPalindrome(11));
        }

        @Test
        public void test7() {
            Assert.assertTrue(isPalindrome(1001));
        }

        @Test
        public void test8() {
            Assert.assertTrue(isPalindrome(12321));
        }
    }
}
