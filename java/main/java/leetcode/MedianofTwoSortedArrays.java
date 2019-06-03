package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 2019-06-03.
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return getAverage(nums2);
        if (nums2.length == 0) return getAverage(nums1);
        double avg1 = getAverage(nums1);
        double avg2 = getAverage(nums2);
        return (avg1 + avg2) / 2;
    }

    public static double getAverage(int[] nums) {
        if (nums.length == 0) return 0;
        return Arrays.stream(nums).sum() * 1.0 / nums.length;
    }

    public static class UnitTest {
        @Test
        public void test() {
            int[] nums1 = new int[] { 1, 3 };
            int[] nums2 = new int[] { 2 };
            assertEquals(2.0d, findMedianSortedArrays(nums1, nums2), 0.001);
        }

        @Test
        public void test2() {
            int[] nums1 = new int[] { 1, 2 };
            int[] nums2 = new int[] { 3, 4 };
            assertEquals(2.5d, findMedianSortedArrays(nums1, nums2), 0.001);
        }

        @Test
        public void test3() {
            int[] nums1 = new int[] {};
            int[] nums2 = new int[] { 2, 4 };
            assertEquals(3.0d, findMedianSortedArrays(nums1, nums2), 0.001);
        }

        @Test
        public void test4() {
            int[] nums1 = new int[] { 3 };
            int[] nums2 = new int[] { -2, -1 };
            assertEquals(-1.0d, findMedianSortedArrays(nums1, nums2), 0.001);
        }
    }
}
