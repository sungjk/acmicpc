package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * Created by jeremy on 2020/02/16.
 */
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Initialize [0]: src, [1]: dist, [2]: cost
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            graph[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        // Check start point
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, src, K + 1 });

        // Tour
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == dst) return curr[0];
            if (curr[2] > 0) {
                for (int[] next : graph[curr[1]]) {
                    pq.offer(new int[] { curr[0] + next[1], next[0], curr[2] - 1 });
                }
            }
        }

        return -1;
    }

    public static class UnitTest {
        @Test
        public void test1() {
            int[][] flights = new int[][] {
                {0,1,100},
                {1,2,100},
                {0,2,500}
            };
            Assert.assertEquals(200, findCheapestPrice(3, flights, 0, 2, 1));
        }

        @Test
        public void test2() {
            int[][] flights = new int[][] {
                {0,1,100},
                {1,2,100},
                {0,2,500}
            };
            Assert.assertEquals(500, findCheapestPrice(3, flights, 0, 2, 0));
        }
    }
}
