package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Created by Jeremy on 06/01/2020.
 */
public class UniqueBinarySearchTrees {
    static int[] cache;

    public static int numTrees(int n) {
        cache = new int[n + 1];
        return makeTree(n);
    }

    public static int makeTree(int n) {
        if (n == 0 || n == 1) return 1;
        if (cache[n] > 0) return cache[n];

        int sum = 0;
        for (int root = n; root > 0; root--) {
            sum += makeTree(root - 1) * makeTree(n - root);
        }
        cache[n] = sum;
        return cache[n];
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(1, numTrees(0));
        }

        @Test
        public void test1() {
            Assert.assertEquals(5, numTrees(3));
        }

        @Test
        public void test2() {
            Assert.assertEquals(1, numTrees(1));
        }

        @Test
        public void test3() {
            Assert.assertEquals(14, numTrees(4));
        }

        @Test
        public void test4() {
            Assert.assertEquals(42, numTrees(5));
        }
    }
}
