import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 03/10/2019.
 */
public class DFSBFS {
    //https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
    public static int test1(int[] numbers, int target) {
        return rec1(Arrays.stream(numbers).boxed().collect(Collectors.toList()), 0, target);
    }

    public static int rec1(List<Integer> numbers, int acc, int target) {
        if (numbers.isEmpty()) {
            return acc == target ? 1 : 0;
        }

        int nextValue = numbers.get(0);
        List<Integer> next = numbers.size() == 1 ? Collections.emptyList() : numbers.subList(1, numbers.size());
        int plus = rec1(next, acc + nextValue, target);
        int minus = rec1(next, acc - nextValue, target);
        return plus + minus;
    }

    public static class UnitTest {
        @Test
        public void _test1() {
            int[] numbers = new int[] { 1, 1, 1, 1, 1 };
            int target = 3;
            assertEquals(test1(numbers, target), 5);
        }
    }
}
