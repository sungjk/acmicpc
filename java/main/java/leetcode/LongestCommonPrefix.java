package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Created by jeremy on 2019/11/12.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0);
    }

    public static String longestCommonPrefix(String[] strs, int index) {
        if (index >= strs[0].length()) return "";

        char c = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() <= index) return "";
            if (c != strs[i].charAt(index)) return "";
        }
        return c + longestCommonPrefix(strs, index + 1);
    }

    public static class UnitTest {
        @Test
        public void test0() {
            String[] given = new String[] { };
            Assert.assertEquals("", longestCommonPrefix(given));
        }

        @Test
        public void test1() {
            String[] given = new String[] { "flower","flow","flight" };
            Assert.assertEquals("fl", longestCommonPrefix(given));
        }

        @Test
        public void test2() {
            String[] given = new String[] { "dog","racecar","car" };
            Assert.assertEquals("", longestCommonPrefix(given));
        }

        @Test
        public void test3() {
            String[] given = new String[] { "afla","bflb","cflc" };
            Assert.assertEquals("", longestCommonPrefix(given));
        }
    }
}
