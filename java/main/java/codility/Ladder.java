package codility;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 03/13/2019.
 */
public class Ladder {
    public static int[] solution(int[] A, int[] B) {
        int[] answer = new int[A.length];
        int[] climbingCache = new int[A.length + 1];
//        for (int i = 0; i < A.length; i++) {
//            int pow = (int) Math.pow(2, B[i]);
//            int resultOfClimbing = climbing(climbingCache, A[i]);
//            answer[i] = resultOfClimbing % pow;
//        }
        int maxClimbingCount = 0;
        for (int climbingCount : A) {
            maxClimbingCount = Math.max(maxClimbingCount, climbingCount);
        }

        climbingCache[0] = 1;
        climbingCache[1] = 1;
        for (int i = 2; i < maxClimbingCount + 1; i++) {
            climbingCache[i] = (climbingCache[i - 1] + climbingCache[i - 2]) % (1 << 30);
        }

        for (int i = 0; i < A.length; i++) {
            answer[i] = climbingCache[A[i]] % (1 << B[i]);
        }
        return answer;
    }

    // extreme_large: StackOverflowError
    public static int climbing(int[] climbingCache, int current) {
        if (current <= 1) return 1;
        if (climbingCache[current] != 0L) return climbingCache[current];

        int oneStep = climbing(climbingCache, current - 1) % (1 << 30);
        int twoStep = climbing(climbingCache, current - 2) % (1 << 30);
        return climbingCache[current] = (oneStep + twoStep) % (1 << 30);
    }

    public static class UnitTest {
        @Test
        public void test() {
            Assert.assertArrayEquals(new int[] { 5, 1, 8, 0, 1 }, solution(new int[] { 4, 4, 5, 5, 1 }, new int[] { 3, 2, 4, 3, 1 }));
        }
    }
}
