package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Created by jeremy on 2020/01/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        return getLongestUniqueLength(s, 0, 0, new HashMap<>());
    }

    public static int getLongestUniqueLength(String s, int current, int cursor, Map<Character, Integer> unique) {
        if (current == s.length()) return 0;

        // get next cursor if already existed key
        int nextCursor = unique.containsKey(s.charAt(current)) ? Math.max(unique.get(s.charAt(current)), cursor) : cursor;
        unique.put(s.charAt(current), current + 1);
        return Math.max(current - nextCursor + 1, getLongestUniqueLength(s, current + 1, nextCursor, unique));
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(0, lengthOfLongestSubstring(""));
        }

        @Test
        public void test1() {
            Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        }

        @Test
        public void test2() {
            Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        }

        @Test
        public void test3() {
            Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        }

        @Test
        public void test4() {
            Assert.assertEquals(1, lengthOfLongestSubstring(" "));
        }
    }
}
