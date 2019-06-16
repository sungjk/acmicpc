package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jeremy on 2019-06-16.
 */
public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) set.add(j);
        for (char s : S.toCharArray()) count += set.contains(s) ? 1 : 0;
        return count;
    }

    public static class UnitTest {
        @Test
        public void test() {
            Assert.assertEquals(0, (numJewelsInStones("a", "AA")));
        }

        @Test
        public void test2() {
            Assert.assertEquals(0, (numJewelsInStones("a", "")));
        }

        @Test
        public void test3() {
            Assert.assertEquals(0, (numJewelsInStones("", "a")));
        }

        @Test
        public void test4() {
            Assert.assertEquals(3, (numJewelsInStones("a", "aaa")));
        }

        @Test
        public void test5() {
            Assert.assertEquals(3, (numJewelsInStones("aA", "aAAbbbb")));
        }

        @Test
        public void test6() {
            Assert.assertEquals(7, (numJewelsInStones("aAbB", "aAAbbbb")));
        }
    }

}
