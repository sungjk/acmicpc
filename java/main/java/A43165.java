import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jeremy on 2020/02/04.
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class A43165 {
    public static int solution(int[] numbers, int target) {
        List<Integer> numberList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        return calc(numberList , target, 0);
    }

    public static int calc(List<Integer> numbers, int target, int current) {
        if (numbers.isEmpty() && target == current) return 1;
        if (numbers.isEmpty()) return 0;

        List<Integer> tail = numbers.subList(1, numbers.size());
        int plus = calc(tail, target, current + numbers.get(0));
        int minus = calc(tail, target, current - numbers.get(0));
        return plus + minus;
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(1, solution(new int[] {1}, 1));
        }

        @Test
        public void test1() {
            Assert.assertEquals(5, solution(new int[] {1,1,1,1,1}, 3));
        }

        @Test
        public void test2() {
            Assert.assertEquals(1, solution(new int[] {1,1,1,1,1}, 5));
        }

        @Test
        public void test3() {
            Assert.assertEquals(1, solution(new int[] {1,3,5,7}, 2));
        }
    }
}
