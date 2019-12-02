package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/coin-change/
 * Created by jeremy on 2019/11/26.
 */
public class CoinChange {
    static int[] _coins;
    static int[] count;

    public static int coinChange(int[] coins, int amount) {
        _coins = coins;
        if (_coins == null) return -1;
        if (_coins.length == 0 && amount == 0) return 0;
        if (_coins.length == 0) return -1;

        count = new int[amount + 1];
        int result = compute(amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int compute(int amount) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;
        if (count[amount] != 0) return count[amount];

        int minCount = Integer.MAX_VALUE;
        for (int coin : _coins) {
            int candidate = compute(amount - coin);
            if (candidate < minCount) {
                minCount = candidate + 1;
            }
        }
        count[amount] = minCount;
        return count[amount];
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Assert.assertEquals(3, coinChange(new int[] {1,2,5}, 11));
        }

        @Test
        public void test2() {
            Assert.assertEquals(4, coinChange(new int[] {2,5}, 11));
        }

        @Test
        public void test3() {
            Assert.assertEquals(-1, coinChange(new int[] {2}, 3));
        }

        @Test
        public void test4() {
            Assert.assertEquals(25, coinChange(new int[] {3,7,405,436}, 8839));
        }
    }
}
