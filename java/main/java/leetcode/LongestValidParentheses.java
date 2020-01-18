package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * Created by Jeremy on 17/01/2020.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int longest = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current);
                current = 0;
            } else {
                if (stack.isEmpty()) {
                    current = 0;
                } else {
                    current = current + stack.pop() + 2;
                    longest = Math.max(longest, current);
                }
            }
        }
        return longest;
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Assert.assertEquals(2, longestValidParentheses("(()"));
        }

        @Test
        public void test2() {
            Assert.assertEquals(4, longestValidParentheses(")()())"));
        }

        @Test
        public void test3() {
            Assert.assertEquals(10, longestValidParentheses("((()))(())"));
        }

        @Test
        public void test4() {
            Assert.assertEquals(6, longestValidParentheses("((()))((())"));
        }
    }
}
