package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 2021/01/26.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }

    public static class UnitTest {
        ProductOfArrayExceptSelf a = new ProductOfArrayExceptSelf();

        @Test
        public void test1() {
            int[] given = new int[]{1,2,3,4};
            int[] expected = new int[]{24,12,8,6};
            int[] actual = a.productExceptSelf(given);

            Assert.assertArrayEquals(expected, actual);
        }
    }
}
