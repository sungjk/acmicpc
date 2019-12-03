package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/gas-station/
 * Created by jeremy on 2019/11/24.
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;

        for (int i = 0; i < gas.length; i++) {
            int result = tour(gas, cost, i, i, gas[i]);
            if (result != -1) {
                return i;
            }
        }
        return -1;
    }

    public static int tour(int[] gas, int[] cost, int start, int current, int currentGas) {
        int next = current + 1 >= gas.length ? 0 : current + 1;
        int nextGas = currentGas - cost[current] + gas[next];

        if (currentGas < cost[current] || nextGas <= 0) return -1;
        if (next == start) return start;
        return tour(gas, cost, start, next, nextGas);
    }

    public static class UnitTest {
        @Test
        public void test0() {
            int[] gas = new int[] {};
            int[] cost = new int[] {};
            Assert.assertEquals(-1, canCompleteCircuit(gas, cost));
        }

        @Test
        public void test1() {
            int[] gas = new int[] { 1,2,3,4,5 };
            int[] cost = new int[] { 3,4,5,1,2 };
            Assert.assertEquals(3, canCompleteCircuit(gas, cost));
        }

        @Test
        public void test2() {
            int[] gas = new int[] { 2,3,4 };
            int[] cost = new int[] { 3,4,3 };
            Assert.assertEquals(-1, canCompleteCircuit(gas, cost));
        }
    }
}
