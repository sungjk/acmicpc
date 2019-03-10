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

    // https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
    public static int test2(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int current = 0; current < n; current++) {
            if (!visited[current]) {
                answer++;
                rec2(computers, visited, current);
            }
        }
        return answer;
    }

    public static void rec2(int[][] computers, boolean[] visited, int current) {
        visited[current] = true;
        for (int next = 0; next < computers.length; next++) {
            if (current == next) continue;
            if (!visited[next] && computers[current][next] == 1) {
                rec2(computers, visited, next);
            }
        }
    }

    public static class UnitTest {
        @Test
        public void _test1() {
            int[] numbers = new int[] { 1, 1, 1, 1, 1 };
            int target = 3;
            assertEquals(test1(numbers, target), 5);
        }

        @Test
        public void _test2() {
            int n1 = 3;
            int[][] computers1 = new int[][] {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
            };
            int n2 = 3;
            int[][] computers2 = new int[][] {
                { 1, 1, 0 },
                { 1, 1, 1 },
                { 0, 1, 1 }
            };
            assertEquals(test2(n1, computers1), 2);
            assertEquals(test2(n2, computers2), 1);
        }
    }
}
