package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jeremy on 03/12/2019.
 */
public class PerfectSquares {
    int[] cache;

    public int numSquares(int n) {
        cache = new int[n + 1];
        return count(n);
    }

    public int count(int n) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if (cache[n] != 0) return cache[n];

        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            minCount = Math.min(minCount, 1 + count(n - i * i));
        }
        cache[n] = minCount;
        return cache[n];
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, numSquares(12));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, numSquares(13));
    }
}
