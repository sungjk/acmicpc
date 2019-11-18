package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/word-break/
 * Created by jeremy on 2019/11/18.
 */
public class WordBreak {
    static List<String> wordDictionary;
    static HashSet<String> cacheForFailure;

    public static boolean wordBreak(String s, List<String> wordDict) {
        wordDictionary = wordDict;
        cacheForFailure = new HashSet<>();
        return find(s);
    }

    public static boolean find(String s) {
        if (s.isEmpty()) return false;
        if (wordDictionary.contains(s)) return true;
        if (cacheForFailure.contains(s)) return false;

        boolean canSegmented = IntStream.range(0, s.length() - 1)
            .mapToObj(i -> s.substring(0, s.length() - 1 - i))
            .filter(wordDictionary::contains)
            .map(segmented -> s.substring(segmented.length()))
            .anyMatch(segmented -> find(segmented));
        if (!canSegmented) {
            cacheForFailure.add(s);
            return false;
        }
        return true;
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertTrue(wordBreak("a", Collections.singletonList("a")));
        }

        @Test
        public void test1() {
            Assert.assertTrue(wordBreak("leetcode", Arrays.asList("leet", "code")));
        }

        @Test
        public void test2() {
            Assert.assertTrue(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        }

        @Test
        public void test3() {
            Assert.assertFalse(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        }

        @Test
        public void test4() {
            Assert.assertFalse(wordBreak("ccbb", Arrays.asList("bc","cb")));
        }

        @Test
        public void test5() {
            Assert.assertFalse(wordBreak("cbca", Arrays.asList("bc","ca")));
        }
    }
}
