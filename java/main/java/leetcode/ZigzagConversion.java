package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 2019-06-11.
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s.isEmpty()) return "";
        if (numRows <= 1) return s;

        int _numRows = Math.min(s.length(), numRows);
        return convert(s, new String[_numRows], _numRows - 1, 0, true);
    }

    public static String convert(String s, String[] zigzag, int numRows, int currentRow, boolean isDownDirection) {
        if (s.isEmpty()) return String.join("", zigzag);

        // 아래 방향 && 바닥 도달 O => 위 방향, currentRow - 1
        // 아래 방향 && 바닥 도달 X => 아래 방향, currentRow + 1
        // 위 방향 && 처음 도달 O => 아래 방향, currentRow + 1
        // 위 방향 && 처음 도달 X => 위 방향, currentRow - 1
        String nextS = s.substring(1);
        String[] nextZigzag = getNextZigzag(s, zigzag, currentRow);
        if (isDownDirection) {
            if (numRows == currentRow) {
                int nextRow = currentRow - 1;
                return convert(nextS, nextZigzag, numRows, nextRow, false);
            } else {
                int nextRow = currentRow + 1;
                return convert(nextS, nextZigzag, numRows, nextRow, true);
            }
        } else {
            if (0 == currentRow) {
                int nextRow = currentRow + 1;
                return convert(nextS, nextZigzag, numRows, nextRow, true);
            } else {
                int nextRow = currentRow - 1;
                return convert(nextS, nextZigzag, numRows, nextRow, false);
            }
        }
    }

    public static String[] getNextZigzag(String s, String[] zigzag, int currentRow) {
        if ( zigzag[currentRow] == null || zigzag[currentRow].isEmpty()) {
            zigzag[currentRow] = s.substring(0, 1);
        } else {
            zigzag[currentRow] += s.substring(0, 1);
        }
        return zigzag;
    }

    public static class UnitTest {
        @Test
        public void test() {
            String s = "PAYPALISHIRING";
            int numRows = 3;
            /*
            0 P   A   H   N
            1 A P L S I I G
            2 Y   I   R
             */
            Assert.assertEquals("PAHNAPLSIIGYIR", convert(s, numRows));
        }

        @Test
        public void test2() {
            String s = "PAYPALISHIRING";
            int numRows = 4;
            /*
            0 P     I    N
            1 A   L S  I G
            2 Y A   H R
            3 P     I
             */
            Assert.assertEquals("PINALSIGYAHRPI", convert(s, numRows));
        }

        @Test
        public void test3() {
            String s = "ABC";
            int numRows = 2;
            /*
            0 A C
            1 B
             */
            Assert.assertEquals("ACB", convert(s, numRows));
        }

        @Test
        public void test4() {
            String s = "ABCDE";
            int numRows = 4;
            /*
            0 A
            1 B
            2 C E
            3 D
             */
            Assert.assertEquals("ABCED", convert(s, numRows));
        }

        @Test
        public void test5() {
            String s = "abcdefghijklmnopqrstuvwxyz";
            int numRows = 6;
            Assert.assertEquals("akubjltvcimswdhnrxegoqyfpz", convert(s, numRows));
        }

        @Test
        public void test6() {
            String s = "abcdefghijklmnopqrstuvwxyz";
            int numRows = 7;
            Assert.assertEquals("amyblnxzckowdjpveiqufhrtgs", convert(s, numRows));
        }

        @Test
        public void test7() {
            String s = "";
            int numRows = 0;
            Assert.assertEquals("", convert(s, numRows));
        }

        @Test
        public void test8() {
            String s = "a";
            int numRows = 1;
            Assert.assertEquals("a", convert(s, numRows));
        }

        @Test
        public void test9() {
            String s = "a";
            int numRows = 0;
            Assert.assertEquals("a", convert(s, numRows));
        }

        @Test
        public void test10() {
            String s = "a";
            int numRows = -1;
            Assert.assertEquals("a", convert(s, numRows));
        }

        @Test
        public void test11() {
            String s = "AB";
            int numRows = 1;
            Assert.assertEquals("AB", convert(s, numRows));
        }

        @Test
        public void test12() {
            String s = "A";
            int numRows = 2;
            Assert.assertEquals("A", convert(s, numRows));
        }
    }
}
