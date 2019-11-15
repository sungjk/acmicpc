package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/subsets/
 * Created by jeremy on 2019/11/11.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, new ArrayList<>(), 0);
    }

    public static List<List<Integer>> subsets(int[] nums, List<Integer> candidate, int index) {
        if (index >= nums.length) {
            return Collections.singletonList(candidate);
        } else {
            List<Integer> nextCandidate = Stream.of(candidate, Collections.singletonList(nums[index]))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
            return Stream.of(subsets(nums, candidate, index + 1), subsets(nums, nextCandidate, index + 1))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        }
    }

    public static class UnitTest {
        @Test
        public void test0() {
            List<List<Integer>> expected = Collections.singletonList(Collections.emptyList());;
            Assert.assertEquals(expected, subsets(new int[] {}));
        }

        @Test
        public void test1() {
            List<List<Integer>> expected = new ArrayList<>();
            expected.add(Collections.emptyList());
            expected.add(Collections.singletonList(3));
            expected.add(Collections.singletonList(2));
            expected.add(Stream.of(2, 3).collect(Collectors.toList()));
            expected.add(Collections.singletonList(1));
            expected.add(Stream.of(1, 3).collect(Collectors.toList()));
            expected.add(Stream.of(1, 2).collect(Collectors.toList()));
            expected.add(Stream.of(1, 2, 3).collect(Collectors.toList()));

            Assert.assertEquals(expected, subsets(new int[] { 1, 2, 3 }));
        }
    }
}
