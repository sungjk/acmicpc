package amcat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremy on 2019-06-02.
 *
 * Eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its adjacent
 * cells(neighbors). An integer value of 1 represents an active cell and a value of 0 represents an inactive cell. If
 * the neighbors on both the sides of a cell are either active or inactive, the cell becomes inactive on the next day;
 * otherwise the cell becomes active. The two cells on each and have a single adjacent cell, so assume that the unoccupied
 * space on the opposite side is an inactive cell. Even after updating the cell state, consider its previous state when
 * updating the state of other cells. The state information of all cells should be update4d simultaneously.
 *
 * Write an algorithm to output the state of the cells after the given number of days.
 *
 * Input
 * The input to the function/method consists of two arguments:
 * states, a list of integers representing the current state of cells;
 * days, an integer representing the number of days.
 *
 * Output
 * Return a list of integers representing the state of the cells after the given number of days
 *
 * Note
 * The elements of the list states contains 0s and 1s only.
 */
public class T0002 {

    public static List<Integer> cellCompete(int[] states, int days) {
        if (days == 0) return Arrays.stream(states).boxed().collect(Collectors.toList());

        int[] tempStates = new int[states.length];
        for (int i = 0; i < states.length; i++) {
            if (i == 0) {
                tempStates[i] = states[i + 1] == 0 ? 0 : 1;
            } else if (i == states.length - 1) {
                tempStates[i] = states[i - 1] == 0 ? 0 : 1;
            } else {
                tempStates[i] = states[i - 1] == states[i + 1] ? 0 : 1;
            }
        }

        return cellCompete(Arrays.copyOf(tempStates, tempStates.length), days - 1);
    }

    public static class UnitTest {
        @Test
        public void _test1() {
            int[] states = new int[] { 1, 0, 0, 0, 0, 1, 0, 0 };
            int days = 1;
            assertEquals(cellCompete(states, days), Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0));
        }

        @Test
        public void _test2() {
            int[] states = new int[] { 1, 1, 1, 0, 1, 1, 1, 1 };
            int days = 2;
            assertEquals(cellCompete(states, days), Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        }
    }
}
