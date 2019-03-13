package codility;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 03/13/2019.
 */
public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        Map<Integer, Integer> oddCountMap = new HashMap<>();
        for (int key : A) {
            if (oddCountMap.containsKey(key)) {
                oddCountMap.replace(key, oddCountMap.get(key) + 1);
            } else {
                oddCountMap.put(key, 1);
            }
        }

        return oddCountMap.keySet().stream()
            .filter(key -> oddCountMap.get(key) % 2 == 1)
            .findFirst()
            .get();
    }

    public static class UnitTest {
        @Test
        public void test() {
            assertEquals(7, solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));
        }
    }
}
