package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Created by Jeremy on 04/12/2019.
 */
public class LongestIncreasingSubsequence {
    int[][] cache;

    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length + 1][nums.length];
        return select(nums, -1, 0);
    }

    public int select(int[] nums, int prev, int curr) {
        if (nums.length == curr) return 0;
        if (cache[prev + 1][curr] > 0) return cache[prev + 1][curr];

        int longest = 0;
        if (prev < 0 || nums[prev] < nums[curr]) {
            longest = Math.max(longest, 1 + select(nums, curr, curr + 1));
        }
        longest = Math.max(longest, select(nums, prev, curr + 1));

        cache[prev + 1][curr] = longest;
        return cache[prev + 1][curr];
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, lengthOfLIS(new int[] {}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(7, lengthOfLIS(new int[] {10,9,2,5,3,7,101,18,174,1,60,67,888,3,5,878}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, lengthOfLIS(new int[] {2,2,2,2}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(2, lengthOfLIS(new int[] {2,2,2,3}));
    }

    @Test
    public void test6() {
        Assert.assertEquals(1, lengthOfLIS(new int[] {42}));
    }

    @Test
    public void test7() {
        Assert.assertEquals(5, lengthOfLIS(new int[] {2,15,3,7,8,6,18}));
    }

    @Test
    public void test8() {
        Assert.assertEquals(6, lengthOfLIS(new int[] {3,5,6,2,5,4,19,5,6,7,12}));
    }

    @Test
    public void test9() {
        Assert.assertEquals(2500, lengthOfLIS(IntStream.range(1, 2501).boxed().mapToInt(i -> i).toArray()));
    }
}
