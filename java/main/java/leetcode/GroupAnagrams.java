package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/group-anagrams/
 * Created by jeremy on 2019/11/15.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String groupKey = String.valueOf(chars);

            if (anagramMap.containsKey(groupKey)) {
                List<String> anagrams = anagramMap.get(groupKey);
                anagrams.add(str);
                anagramMap.replace(groupKey, anagrams);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                anagramMap.put(groupKey, anagrams);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static class UnitTest {
        @Test
        public void test1() {
            String[] given = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
            List<List<String>> expected = Arrays.asList(
                Stream.of("eat", "tea", "ate").collect(Collectors.toList()),
                Stream.of("bat").collect(Collectors.toList()),
                Stream.of("tan", "nat").collect(Collectors.toList())
            );
            Assert.assertEquals(expected, groupAnagrams(given));
        }
    }
}
