package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 * Created by jeremy on 2019/12/02.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;

        for (int i = 0; i < A.length - 1; i++) {
            A[i] = A[i + 1] - A[i];
        }
        return count(A, 0, 1);
    }

    public int count(int[] A, int index, int pair) {
        if (A.length - 2 == index) return 0;

        if (A[index] == A[index + 1]) {
            return pair + count(A, index + 1, pair + 1);
        } else {
            return count(A, index + 1, 1);
        }
    }

    @Test
    public void test0() {
        Assert.assertEquals(0, numberOfArithmeticSlices(new int[] {}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 9 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, numberOfArithmeticSlices(new int[] { 7, 7, 7, 7 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, numberOfArithmeticSlices(new int[] { 3, -1, -5, -9 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, numberOfArithmeticSlices(new int[] { 1, 1, 2, 5, 7 }));
    }

    @Test
    public void test6() {
        Assert.assertEquals(1, numberOfArithmeticSlices(new int[] { 1, 1, 2, 5, 8 }));
    }

    @Test
    public void test7() {
        Assert.assertEquals(3, numberOfArithmeticSlices(new int[] { 1, 1, 2, 5, 8, 11 }));
    }

    @Test
    public void test8() {
        Assert.assertEquals(10, numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 9, 11 }));
    }

    @Test
    public void test9() {
        Assert.assertEquals(15, numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 9, 11, 13 }));
    }

    @Test
    public void test10() {
        Assert.assertEquals(21, numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 9, 11, 13, 15 }));
    }

    @Test
    public void test11() {
        Assert.assertEquals(4, numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 8, 11, 13, 15 }));
    }
}
