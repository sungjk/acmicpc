package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 2020/12/05.
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */
public class SmallestStringWithGivenNumericValue {
    // Accepted	75ms 39.2MB
    public static String getSmallestString(int n, int k) {
        char[] str = new String(new char[n])
            .replace("\0", "a")
            .toCharArray();

        int index = n - 1;
        int remainder = k - n; // aaa 제외한 나머지

        while (remainder > 0) {
            if (str[index] >= 'z') {
                index--; // 큰 문자가 작은 문자 앞에 올 수 없으므로 index만 감소
            } else {
                str[index] = (char) (str[index] + 1);
                remainder--;
            }
        }

        return new String(str);
    }

    // Runtime Error(StackOverflowError)
    public static String getSmallestStringRec(int n, int k) {
        char[] str = new String(new char[n])
            .replace("\0", "a")
            .toCharArray();

        // k - n: a로만 이루어진 문자열 제외
        char[] smallestStr = getSmallestString(str, n - 1, k - n);
        return new String(smallestStr);
    }

    public static char[] getSmallestString(char[] str, int index, int remainder) {
        if (remainder == 0) {
            return str;
        }

        if (str[index] >= 'z') {
            // 큰 문자가 작은 문자 앞에 올 수 없으므로 index만 감소
            return getSmallestString(str, index - 1, remainder);
        }

        str[index] = (char) (str[index] + 1);
        return getSmallestString(str, index, remainder - 1);
    }

    public static class UnitTest {
        @Test
        public void test0() {
            assertEquals("a", getSmallestString(1, 1));
        }

        @Test
        public void test1() {
            assertEquals("aay", getSmallestString(3, 27));
        }

        @Test
        public void test2() {
            assertEquals("aaszz", getSmallestString(5, 73));
        }
    }
}
