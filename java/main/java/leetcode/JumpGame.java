package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/jump-game/
 * Created by Jeremy on 06/01/2020.
 */
public class JumpGame {
    static int[] cache;

    public static boolean canJump(int[] nums) {
        cache = new int[nums.length];
        return jump(nums, 0);
    }

    public static boolean jump(int[] nums, int current) {
        if (current > nums.length - 1) return false;
        if (current == nums.length - 1) return true;
        if (cache[current] > 0) return cache[current] == 2;

        boolean canJump = false;
        for (int i = nums[current]; i > 0; i--) {
            canJump |= jump(nums, current + i);
        }
        cache[current] = canJump ? 2 : 1;
        return cache[current] == 2;
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertTrue(canJump(new int[] {0}));
        }

        @Test
        public void test1() {
            Assert.assertTrue(canJump(new int[] {2, 3, 1, 1, 4}));
        }

        @Test
        public void test2() {
            Assert.assertFalse(canJump(new int[] {3,2,1,0,4}));
        }

        @Test
        public void test3() {
            Assert.assertTrue(canJump(new int[] {3}));
        }

        @Test
        public void test4() {
            Assert.assertTrue(canJump(new int[] {1,1}));
        }
    }
}
