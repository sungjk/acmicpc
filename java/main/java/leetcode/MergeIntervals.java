package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Created by jeremy on 2019/11/16.
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] candidate = intervals[0];
        result.add(candidate);
        for (int[] interval : intervals) {
            if (interval[0] <= candidate[1]) {
                candidate[1] = Math.max(candidate[1], interval[1]);
            } else {
                candidate = interval;
                result.add(candidate);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertArrayEquals(new int[][] {}, merge(new int[][] {}));
        }

        @Test
        public void test1() {
            int[][] given = new int[][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
            };
            int[][] expected = new int[][] {
                {1,6},
                {8,10},
                {15,18}
            };
            Assert.assertArrayEquals(expected, merge(given));
        }

        @Test
        public void test2() {
            int[][] given = new int[][] {
                {1,4},
                {4,5}
            };
            int[][] expected = new int[][] {
                {1,5}
            };
            Assert.assertArrayEquals(expected, merge(given));
        }
    }
}
