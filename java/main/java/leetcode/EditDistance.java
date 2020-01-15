package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 2020/01/15.
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if (word1.isEmpty() && word2.isEmpty()) return 0;
        if (word1.isEmpty() && word2.length() == 1) return 1;
        if (word2.isEmpty() && word1.length() == 1) return 1;

        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            distance[0][i] = i;
        }

        for (int i = 0 ; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    distance[i + 1][j + 1] = distance[i][j];
                } else {
                    distance[i + 1][j + 1] = 1 + Math.min(distance[i + 1][j], Math.min(distance[i][j], distance[i][j + 1]));
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(1, minDistance("", "a"));
        }

        @Test
        public void test1() {
            Assert.assertEquals(3, minDistance("horse", "ros"));
        }

        @Test
        public void test2() {
            Assert.assertEquals(5, minDistance("intention", "execution"));
        }

        @Test
        public void test3() {
            Assert.assertEquals(0, minDistance("intention", "intention"));
        }

        @Test
        public void test4() {
            Assert.assertEquals(1, minDistance("a", "b"));
        }

        @Test
        public void test5() {
            Assert.assertEquals(9, minDistance("distance", "springbok"));
        }

        @Test
        public void test6() {
            Assert.assertEquals(3, minDistance("abc", "def"));
        }
    }
}
