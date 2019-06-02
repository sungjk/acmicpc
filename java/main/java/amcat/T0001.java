package amcat;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 2019-06-02.
 *
 * The greatest common divisor (GCD), also called highest common factor (HCF) of N number is the largest positive integer
 * that divides all numbers without giving a remainder.
 *
 * Write an algorithm to determine the GCD of N positive integers.
 *
 * Input
 * The input to the function/method consists of two arguments -
 * num, an integer representing the number of positive integers (N).
 * arr, a list of positive integers.
 *
 * Output
 * Return an integer representing the GCD of the given positive integers.
 */
public class T0001 {
    public static int generalizedGCD(int num, int[] arr) {
        if (num == 0) return 0;
        if (num == 1) return arr[0];

        return getRecursiveGCD(getGCD(arr[0], arr[1]), Arrays.copyOfRange(arr, 2, arr.length));
    }

    public static int getRecursiveGCD(int gcd, int[] arr) {
        if (arr.length == 0) return gcd;

        int nextGCD = getGCD(gcd, arr[0]);
        int[] nextArr = Arrays.copyOfRange(arr, 1, arr.length);
        return getRecursiveGCD(nextGCD, nextArr);
    }

    public static int getGCD(int num1, int num2) {
        if (num2 == 0) return num1;
        return getGCD(num2, num1 % num2);
    }

    public static class UnitTest {
        @Test
        public void _test1() {
            int num = 5;
            int[] arr = new int[] { 2, 3, 4, 5, 6 };
            assertEquals(generalizedGCD(num, arr), 1);
        }

        @Test
        public void _test3() {
            int num = 1;
            int[] arr = new int[] { 10 };
            assertEquals(generalizedGCD(num, arr), 10);
        }

        @Test
        public void _test4() {
            int num = 2;
            int[] arr = new int[] { 2, 3 };
            assertEquals(generalizedGCD(num, arr), 1);
        }

        @Test
        public void _test5() {
            int num = 2;
            int[] arr = new int[] { 2, 4 };
            assertEquals(generalizedGCD(num, arr), 2);
        }
    }
}
