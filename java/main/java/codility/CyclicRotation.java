package codility;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jeremy on 03/12/2019.
 */
public class CyclicRotation {
    public static int[] solution(int[] A, int K) {
        if (A.length == 0 || K == 0) return A;

        int[] rotated = new int[A.length];
        int modK = K >= A.length ? K % A.length : K;
        int startIndex = A.length - modK;
        for (int i = 0; i < A.length; i++) {
            if (startIndex == A.length) startIndex = 0;
            rotated[i] = A[startIndex++];
        }
        return rotated;
    }

    public static class UnitTest {
        @Test
        public void test() {
            assertArrayEquals(new int[] { 9, 7, 6, 3, 8 }, solution(new int[] { 3, 8, 9, 7, 6 }, 3));
            assertArrayEquals(new int[] { 0, 0, 0 }, solution(new int[] { 0, 0, 0 }, 1));
            assertArrayEquals(new int[] { 1, 2, 3, 4 }, solution(new int[] { 1, 2, 3, 4 }, 4));
            assertArrayEquals(new int[] { 1, 2, 3, 4 }, solution(new int[] { 1, 2, 3, 4 }, 0));
            assertArrayEquals(new int[] { }, solution(new int[] { }, 4));
            assertArrayEquals(new int[] { }, solution(new int[] { }, 0));
        }
    }
}
