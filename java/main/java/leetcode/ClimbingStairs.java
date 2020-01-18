package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * Created by jeremy on 2020/01/19.
 */
public class ClimbingStairs {
    static int[] cache;

    public static int climbStairs(int n) {
        cache = new int[n + 1];
        return climb(n);
    }

    public static int climb(int n) {
         if (n < 0) return 0;
         if (n <= 1) return 1;
         if (cache[n] > 0) return cache[n];
         cache[n] = climb(n - 1) + climb(n - 2);
         return cache[n];
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(1, climbStairs(0));
        }

        @Test
        public void test1() {
            Assert.assertEquals(2, climbStairs(2));
        }

        @Test
        public void test2() {
            Assert.assertEquals(3, climbStairs(3));
        }

        @Test
        public void test3() {
            Assert.assertEquals(8, climbStairs(5));
        }
    }
}
