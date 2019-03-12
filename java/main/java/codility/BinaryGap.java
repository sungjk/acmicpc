package codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 03/12/2019.
 */
public class BinaryGap {
    static class Solution {
        public int solution(int N) {
            return divide(N, 0, 0, false);
        }

        public int divide(int n, int longest, int current, boolean started) {
            if (n == 0) {
                return longest;
            } else if (n % 2 == 0) {
                return divide(n / 2, longest, started ? current + 1 : current, started);
            } else {
                return divide(n / 2, Math.max(longest, current), 0, true);
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test() {
            Solution s = new Solution();
            assertEquals(2, s.solution(9));
            assertEquals(0, s.solution(15));
            assertEquals(1, s.solution(20));
            assertEquals(0, s.solution(32));
            assertEquals(4, s.solution(529));
            assertEquals(5, s.solution(1041));
        }
    }
}
