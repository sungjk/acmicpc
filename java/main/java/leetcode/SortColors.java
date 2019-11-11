package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/sort-colors/
 * Created by jeremy on 2019/11/11.
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            if (nums[i] == 1) count1++;
            if (nums[i] == 2) count2++;
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) nums[i] = 0;
            else if (i < count0 + count1) nums[i] = 1;
            else nums[i] = 2;
        }

//        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>() {{
//            put(0, 0);
//            put(1, 0);
//            put(2, 0);
//        }};
//        Arrays.stream(nums)
//            .forEach(num -> countMap.put(num, countMap.get(num) + 1));
//
//        int i = 0;
//        for (int color = 0; color < 3; color++) {
//            while (countMap.get(color) > 0) {
//                nums[i++] = color;
//                countMap.replace(color, countMap.get(color) - 1);
//            }
//        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            int[] nums = new int[] { 2,0,2,1,1,0 };
            sortColors(nums);
            Assert.assertArrayEquals(new int[] { 0,0,1,1,2,2 }, nums);
        }
    }
}
