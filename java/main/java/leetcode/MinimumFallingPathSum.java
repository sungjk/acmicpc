package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jeremy on 28/11/2019.
 */
public class MinimumFallingPathSum {
    int[][] cache;

    public int minFallingPathSum(int[][] A) {
        cache = new int[A.length][A.length];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            minSum = Math.min(minSum, fall(A, i, 0));
        }
        return minSum;
    }

    public int fall(int[][] A, int x, int y) {
        if (A.length == y) return 0;
        if (x < 0 || x == A[0].length) return Integer.MAX_VALUE;
        if (cache[y][x] != 0) return cache[y][x];

        int leftBottomValue = fall(A, x - 1, y + 1);
        int currentBottomValue = fall(A, x, y + 1);
        int rightBottomValue = fall(A, x + 1, y + 1);

        cache[y][x] = A[y][x] + Math.min(leftBottomValue, Math.min(currentBottomValue, rightBottomValue));
        return cache[y][x];
    }

    @Test
    public void test0() {
        int[][] given = new int[][] {
            {1}
        };
        Assert.assertEquals(1, minFallingPathSum(given));
    }

    @Test
    public void test1() {
        int[][] given = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        Assert.assertEquals(12, minFallingPathSum(given));
    }

    @Test
    public void test2() {
        int[][] given = new int[][] {
            {-80,-13,22},
            {83,94,-5},
            {73,-48,61}
        };
        Assert.assertEquals(-66, minFallingPathSum(given));
    }
}
