package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 2019/11/21.
 */
public class Search2DMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        if (target < matrix[0][0]) return false;
        if (target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;

        return searchMatrix(matrix, target, matrix.length - 1, 0);
    }

    public static boolean searchMatrix(int[][] matrix, int target, int a, int b) {
        int current = matrix[a][b];
        if (current == target) {
            return true;
        }

        if (a > 0 && current > target) {
            return searchMatrix(matrix, target, a - 1, b);
        }

        if (b < matrix[0].length - 1 && current < target) {
            return searchMatrix(matrix, target, a, b + 1);
        }

        return false;
    }

    public static class UnitTest {
        @Test
        public void test0() {
            int[][] matrix = new int[][] {};
            Assert.assertFalse(searchMatrix(matrix, 1));
        }

        @Test
        public void test1() {
            int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24, 41},
                {18, 21, 23, 26, 30, 41}
            };
            Assert.assertTrue(searchMatrix(matrix, 5));
        }

        @Test
        public void test2() {
            int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            };
            Assert.assertFalse(searchMatrix(matrix, 20));
        }

        @Test
        public void test3() {
            int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            };
            Assert.assertTrue(searchMatrix(matrix, 16));
        }

        @Test
        public void test4() {
            int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            };
            Assert.assertFalse(searchMatrix(matrix, 0));
        }

        @Test
        public void test5() {
            int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            };
            Assert.assertFalse(searchMatrix(matrix, 33));
        }

        @Test
        public void test6() {
            int[][] matrix = new int[][] {
                {1, 1},
            };
            Assert.assertFalse(searchMatrix(matrix, 2));
        }

        @Test
        public void test7() {
            int[][] matrix = new int[][] {
                {1},
                {2}
            };
            Assert.assertTrue(searchMatrix(matrix, 2));
        }
    }
}
