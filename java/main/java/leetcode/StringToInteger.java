package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jeremy on 2019-06-14.
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        if (str.trim().isEmpty()) return 0;

        String intsWithSign = getInts(str, "");
        if (intsWithSign.isEmpty()) return 0;

        int sign = extractSign(intsWithSign);
        String abs = extractAbs(intsWithSign);
        return (int) atol(sign, abs, 0);
    }

    public static int extractSign(String intsWithSign) {
        if (isSign(intsWithSign.charAt(0)) && intsWithSign.charAt(0) == '-') return -1;
        return 1;
    }

    public static String extractAbs(String intsWithSign) {
        if (isSign(intsWithSign.charAt(0))) {
            return intsWithSign.substring(1);
        }
        return intsWithSign;
    }

    public static long atol(int sign, String abs, long digits) {
        if (abs.isEmpty()) return sign * digits;
        char character = abs.charAt(0);

        long nextDigits = digits * 10 + (character - '0');
        if (sign == 1 && nextDigits > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && sign * nextDigits < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (abs.length() == 1) {
            return atol(sign, "", nextDigits);
        }
        return atol(sign, abs.substring(1), nextDigits);
    }

    public static String getInts(String str, String ints) {
        if (str == null || str.isEmpty()) return ints;

        char character = str.charAt(0);
        if (!ints.isEmpty() && !isDigit(character)) return ints;

        if (ints.isEmpty()) {
            if (isDigit(character) || isSign(character) || character == ' ') {
                // "4...", "+...", "-...", " ..."
                String nextInts = character == ' ' ? ints : ints + character;
                return getInts(str.substring(1), nextInts);
            } else {
                // "a..."
                return ints;
            }
        } else {
            if (isDigit(character)) {
                // "4..."
                return getInts(str.substring(1), ints + character);
            } else {
                // "a...", " ...", " +...", " -...."
                return ints;
            }
        }
    }

    public static boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static boolean isSign(char ch) {
        return ch == '+' || ch == '-';
    }

    public static class UnitTest {
        @Test
        public void test() {
            Assert.assertEquals(0, myAtoi("words and 987"));
        }

        @Test
        public void test2() {
            Assert.assertEquals(0, myAtoi(" "));
        }

        @Test
        public void test3() {
            Assert.assertEquals(0, myAtoi("-0"));
        }

        @Test
        public void test4() {
            Assert.assertEquals(0, myAtoi("a"));
        }

        @Test
        public void test6() {
            Assert.assertEquals(-42, myAtoi("  -42"));
        }

        @Test
        public void test7() {
            Assert.assertEquals(42, myAtoi("  42"));
        }

        @Test
        public void test8() {
            Assert.assertEquals(4193, myAtoi("4193 with words"));
        }

        @Test
        public void test9() {
            System.out.println(Integer.MIN_VALUE);
            Assert.assertEquals(Integer.MIN_VALUE, myAtoi("-91283472332"));
        }

        @Test
        public void test10() {
            Assert.assertEquals(Integer.MAX_VALUE, myAtoi("91283472332"));
        }

        @Test
        public void test11() {
            Assert.assertEquals(-4, myAtoi(" -4 2ab42"));
        }

        @Test
        public void test12() {
            Assert.assertEquals(-42, myAtoi(" -42 ab 42"));
        }

        @Test
        public void test13() {
            Assert.assertEquals(-4, myAtoi(" -4 2 "));
        }

        @Test
        public void test14() {
            Assert.assertEquals(-42, myAtoi(" -42-42 "));
        }

        @Test
        public void test15() {
            Assert.assertEquals(42, myAtoi("+42"));
        }

        @Test
        public void test16() {
            Assert.assertEquals(0, myAtoi("++42"));
        }

        @Test
        public void test17() {
            Assert.assertEquals(0, myAtoi("--42"));
        }

        @Test
        public void test18() {
            Assert.assertEquals(42, myAtoi("042"));
        }

        @Test
        public void test19() {
            Assert.assertEquals(-42, myAtoi("-042"));
        }

        @Test
        public void test20() {
            Assert.assertEquals(Integer.MAX_VALUE, myAtoi("9223372036854775808"));
        }

        @Test
        public void test21() {
            Assert.assertEquals(Integer.MIN_VALUE, myAtoi("-9223372036854775808"));
        }

        @Test
        public void test22() {
            Assert.assertEquals(Integer.MAX_VALUE, myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
        }

        @Test
        public void test23() {
            Assert.assertEquals(0, myAtoi("+++42"));
        }
    }

}
