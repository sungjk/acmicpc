package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/rotate-image/
 * Created by jeremy on 2019/11/15.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                int w = matrix[i][j];                       // -->: row i
                int x = matrix[j][size - 1 - i];            // Down: last column
                int y = matrix[size - 1 - i][size - 1 - j]; // <--: last row
                int z = matrix[size - 1 - j][i];            // Up: first column
                matrix[i][j] = z;
                matrix[j][size - 1 - i] = w;
                matrix[size - 1 - i][size - 1 - j] = x;
                matrix[size - 1 - j][i] = y;
            }
        }
    }

    public static void print(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("[" + matrix[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            int[][] given = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
            rotate(given);
            print(given);

            int[][] expected = new int[][] {
                {7,4,1},
                {8,5,2},
                {9,6,3}
            };
            Assert.assertArrayEquals(expected, given);
        }

        @Test
        public void test2() {
            int[][] given = new int[][] {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
            };
            rotate(given);
            print(given);

            int[][] expected = new int[][] {
                {15,13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7,10,11}
            };
            Assert.assertArrayEquals(expected, given);
        }
    }
}
