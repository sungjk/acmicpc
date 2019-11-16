package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/word-search/
 * Created by jeremy on 2019/11/16.
 */
public class WordSearch {
    static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        visited = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (word.charAt(0) == board[y][x] && search(board, x, y, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] board, int x, int y, String word) {
        if (word.isEmpty()) return true;
        if (!canGo(board, x, y, word.charAt(0))) return false;

        visited[y][x] = true;
        boolean right = search(board, x + 1, y, word.substring(1));
        boolean down = search(board, x, y + 1, word.substring(1));
        boolean left = search(board, x - 1, y, word.substring(1));
        boolean up = search(board, x, y - 1, word.substring(1));
        if (right || down || left || up) return true;
        visited[y][x] = false;
        return false;
    }

    public static boolean canGo(char[][] board, int x, int y, char letter) {
        if (y < 0 || y >= board.length) return false;
        if (x < 0 || x >= board[0].length) return false;
        if (visited[y][x]) return false;
        if (board[y][x] != letter) return false;
        return true;
    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(false, exist(new char[][] {}, ""));
        }

        @Test
        public void test1() {
            char[][] given = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
            };
            Assert.assertEquals(true, exist(given, "ABCCED"));
        }

        @Test
        public void test2() {
            char[][] given = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
            };
            Assert.assertEquals(true, exist(given, "SEE"));
        }

        @Test
        public void test3() {
            char[][] given = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
            };
            Assert.assertEquals(false, exist(given, "ABCB"));
        }
    }
}
