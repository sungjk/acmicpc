package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 * Created by jeremy on 2019/11/13.
 */
public class NextPermutation {
    // [4,2,5,3]
    // select: 2, candidate: 3
    // swap: [4,3,5,2]
    // sort: [4,3,2,5]

    // [4,2,5,2]
    // select: 2, candidate: 5
    // swap: [4,5,2,2]
    // sort: [4,5,2,2]
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // 처음으로 다음값보다 작은 위치
        int selectedIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                selectedIndex = i;
                break;
            }
        }

        // 모든 원소가 다음값보다 큰 경우
        if (selectedIndex == -1) {
            Arrays.sort(nums);
            return;
        }

        // 전체 원소 중 selectedIndex에 위치한 원소 다음으로 큰 수 찾기(candidate)
        int selected = nums[selectedIndex];
        int candidate = Integer.MAX_VALUE;
        int candidateIndex = selectedIndex + 1;
        for (int i = selectedIndex + 1; i < nums.length; i++) {
            // candidate 보다 작으면서 selected 보다 큰 경우
            if (candidate > nums[i] && nums[i] > selected) {
                candidate = nums[i];
                candidateIndex = i;
            }
        }

        // selectedIndex와 candidateIndex를 swap
        int temp = nums[selectedIndex];
        nums[selectedIndex] = nums[candidateIndex];
        nums[candidateIndex] = temp;

        // selectedIndex 다음 원소들을 오름차순 정렬
        int[] temps = Arrays.copyOfRange(nums, selectedIndex + 1, nums.length);
        Arrays.sort(temps);
        for (int i = 0; i < temps.length; i++) {
            nums[i + selectedIndex + 1] = temps[i];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            int[] given = new int[] {1,2,3};
            int[] expected = new int[] {1,3,2};
            nextPermutation(given);

            Assert.assertArrayEquals(expected, given);
        }

        @Test
        public void test2() {
            int[] given = new int[] {3,2,1};
            int[] expected = new int[] {1,2,3};
            nextPermutation(given);

            Assert.assertArrayEquals(expected, given);
        }

        @Test
        public void test3() {
            int[] given = new int[] {1,1,5};
            int[] expected = new int[] {1,5,1};
            nextPermutation(given);

            Assert.assertArrayEquals(expected, given);
        }

        @Test
        public void test4() {
            int[] given = new int[] {4,2,3,1};
            int[] expected = new int[] {4,3,1,2};
            nextPermutation(given);

            Assert.assertArrayEquals(expected, given);
        }

        @Test
        public void test5() {
            int[] given = new int[] {4,2,5,3};
            int[] expected = new int[] {4,3,2,5};
            nextPermutation(given);

            Assert.assertArrayEquals(expected, given);
        }

        @Test
        public void test6() {
            int[] given = new int[] {4,2,5,2};
            int[] expected = new int[] {4,5,2,2};
            nextPermutation(given);

            Assert.assertArrayEquals(expected, given);
        }
    }
}
