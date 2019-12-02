package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jeremy on 27/11/2019.
 */
public class MinimumCostForTickets {
    int[] pass = new int[] {1, 7, 30};
    int[] cache;

    public int mincostTickets(int[] days, int[] costs) {
        cache = new int[days.length];
        return buy(days, costs, 0);
    }

    public int buy(int[] days, int[] costs, int index) {
        if (index >= days.length) return 0;
        if (cache[index] > 0) return cache[index];

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < pass.length; i++) {
            int nextIndex = index;
            while (nextIndex < days.length && days[index] + pass[i] > days[nextIndex]) {
                nextIndex++;
            }
            minCost = Math.min(minCost, costs[i] + buy(days, costs, nextIndex));
        }
        cache[index] = minCost;
        return cache[index];
    }

    @Test
    public void test1() {
        int[] days = new int[] {1,4,6,7,8,20};
        int[] costs = new int[] {2,7,15};
        Assert.assertEquals(11, mincostTickets(days, costs));
    }

    @Test
    public void test2() {
        int[] days = new int[] {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = new int[] {2,7,15};
        Assert.assertEquals(17, mincostTickets(days, costs));
    }
}
