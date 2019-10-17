package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 2019/10/17.
 */
public class LetterCombinationsOfPhoneNumber {
    static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        return letterCombinations("", digits);
    }

    public static List<String> letterCombinations(String combination, String digits) {
        if (digits == null || digits.isEmpty()) return Collections.singletonList(combination);

        List<String> combinations = new ArrayList<>();
        String letters = map.get(digits.charAt(0));
        for (int i = 0; i < letters.length(); i++) {
            String letter = map.get(digits.charAt(0)).substring(i, i + 1);
            combinations.addAll(letterCombinations(combination + letter, digits.substring(1)));
        }

        return combinations;
    }

    public static class UnitTest {
        @Test
        public void testSubstring() {
            assertEquals("3", "23".substring(1));
        }

        @Test
        public void test0() {
            assertEquals(Arrays.asList("a", "b", "c"), letterCombinations("2"));
        }

        @Test
        public void test1() {
            assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("23"));
        }

        @Test
        public void test2() {
            assertEquals(Arrays.asList("aa","ab","ac","ba","bb","bc","ca","cb","cc"), letterCombinations("22"));
        }
    }
}
