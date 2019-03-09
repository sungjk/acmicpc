import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by jeremy on 03/07/2019.
 */
public class Hash {
    // https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
    public static String test1(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        for (String p : participant) participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        for (String c : completion) participantMap.put(c, participantMap.get(c) - 1);
        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) > 0) {
                return key;
            }
        }
        return "";
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
    public static boolean test2(String[] phone_book) {
        for (String p1 : phone_book) {
            for (String p2 : phone_book) {
                if (p1.equals(p2)) continue;
                if (p1.startsWith(p2) || p2.startsWith(p1)) return false;
            }
        }
        return true;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42578
    public static int test3(String[][] clothes) {
        Map<String, Set<String>> checkMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        Arrays.stream(clothes).forEach(c -> {
            String key = c[1];  // 의상 종류
            String value = c[0];// 의상 이름
            if (checkMap.containsKey(key)) {
                countMap.replace(key, countMap.get(key) + 1);
            } else {
                checkMap.put(key, new HashSet<String>() {{ add(value); }});
                countMap.put(key, 2);
            }
        });
        return countMap.values().stream().mapToInt(c -> c).reduce(1, (a, b) -> a * b) - 1;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
    public static int[] test4(String[] genres, int[] plays) {
        // 장르별 재생순서
        Map<String, List<Integer>> genresPlayOrderMap = new HashMap<>();
        // 장르별 총 재생횟수
        Map<String, Integer> genresPlayCountMap = new HashMap<>();
        IntStream.range(0, genres.length)
            .forEach(i -> {
                String key = genres[i]; // 장르명
                if (genresPlayCountMap.containsKey(key)) {
                    genresPlayCountMap.replace(key, genresPlayCountMap.get(key) + plays[i]);
                    List<Integer> order = genresPlayOrderMap.get(key);
                    order.add(i);
                    genresPlayOrderMap.replace(key, order);
                } else {
                    genresPlayCountMap.put(key, plays[i]);
                    List<Integer> order = new ArrayList<>();
                    order.add(i);
                    genresPlayOrderMap.put(key, order);
                }
            });
        return genresPlayOrderMap.values()
            .stream()
            .flatMap(playOrder -> playOrder.stream()
                .sorted((o1, o2) -> {
                    int count1 = plays[o1];
                    int count2 = plays[o2];
                    // 장르도 같고 재생된 노래수도 같으면 고유 번호 오름차순
                    if (count1 == count2) {
                        return Integer.compare(o1, o2);
                    } else {
                        return Integer.compare(count2, count1);
                    }
                })
                .limit(2))
            .sorted((o1, o2) -> {
                String genre1 = genres[o1];
                String genre2 = genres[o2];
                // 장르가 같으면 재생된 노래 내림차순
                if (genre1.equals(genre2)) {
                    int count1 = plays[o1];
                    int count2 = plays[o2];
                    // 장르도 같고 재생된 노래수도 같으면 고유 번호 오름차순
                    if (count1 == count2) {
                        return Integer.compare(o1, o2);
                    } else {
                        return Integer.compare(count2, count1);
                    }
                } else {
                    int genreCount1 = genresPlayCountMap.get(genre1);
                    int genreCount2 = genresPlayCountMap.get(genre2);
                    if (genreCount1 == genreCount2) {
                        return Integer.compare(o1, o2);
                    } else {
                        return Integer.compare(genreCount2, genreCount1);
                    }
                }
            })
            .mapToInt(x -> x)
            .toArray();
    }

    public static class UnitTest {
        @Test
        public void _test1() {
            String[] participant1 = new String[] { "leo", "kiki", "eden" };
            String[] completion1 = new String[] { "eden", "kiki" };
            String[] participant2 = new String[] { "marina", "josipa", "nikola", "vinko", "filipa" };
            String[] completion2 = new String[] { "josipa", "filipa", "marina", "nikola" };
            String[] participant3 = new String[] { "mislav", "stanko", "mislav", "ana" };
            String[] completion3 = new String[] { "stanko", "ana", "mislav" };
            assertEquals(test1(participant1, completion1), "leo");
            assertEquals(test1(participant2, completion2), "vinko");
            assertEquals(test1(participant3, completion3), "mislav");
        }

        @Test
        public void _test2() {
            String[] contactNumbers1 = new String[] { "119", "97674223", "1195524421" };
            String[] contactNumbers2 = new String[] { "123", "456", "789" };
            String[] contactNumbers3 = new String[] { "12", "123", "1235", "567", "88" };
            assertFalse(test2(contactNumbers1));
            assertTrue(test2(contactNumbers2));
            assertFalse(test2(contactNumbers3));
        }

        @Test
        public void _test3() {
            String[][] input1 = new String[][] {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
            };
            String[][] input2 = new String[][] {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
            };
            assertEquals(test3(input1), 5);
            assertEquals(test3(input2), 3);
        }

        @Test
        public void _test4() {
            String[] genres = new String[] { "classic", "pop", "classic", "classic", "pop" };
            int[] plays = new int[] { 500, 600, 150, 800, 2500 };
            assertArrayEquals(test4(genres, plays), new int[] { 4, 1, 3, 0 });
        }
    }
}
