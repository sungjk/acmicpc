package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 2019/11/10.
 */
public class MinimumPathSum {
    static int[][] cache;

    public static int minPathSum(int[][] grid) {
        cache = new int[grid.length][grid[0].length];
        return go(grid, 0, 0);
    }

    public static int go(int[][] grid, int x, int y) {
        if (y >= grid.length || x >= grid[0].length) return Integer.MAX_VALUE;
        if (y == grid.length - 1 && x == grid[0].length - 1) return grid[y][x];
        if (cache[y][x] > 0) return cache[y][x];

        int goRight = go(grid, x + 1, y);
        int goDown = go(grid, x, y + 1);
        cache[y][x] = grid[y][x] + Math.min(goRight, goDown);
        return cache[y][x];
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Assert.assertEquals(7, minPathSum(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
            }));
        }
    }
}
