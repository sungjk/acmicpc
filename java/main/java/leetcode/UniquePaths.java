package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jeremy on 2019/11/01.
 */
public class UniquePaths {
    public static int width;
    public static int height;
    public static int[][] cache;

    public static int uniquePaths(int m, int n) {
        width = m;
        height = n;
        cache = new int[m][n];
        return go(0, 0);
    }

    public static int go(int x, int y) {
        if (x >= width || y >= height) return 0;
        if (x == width - 1 && y == height - 1) return 1;
        if (cache[x][y] > 0) return cache[x][y];

        int ret = go(x + 1, y) + go(x, y + 1);
        cache[x][y] = ret;
        return ret;
    }

//    public static class Location {
//        public int x;
//        public int y;
//
//        public Location(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static int[][] direction = new int[][] {
//        { 1, 0 },   // right
//        { 0, 1 }    // down
//    };
//
//    public static int uniquePaths(int m, int n) {
//        if (m == 1 && n == 1) return 1;
//
//        int[][] map = new int[n][m];
//        Queue<Location> queue = new LinkedList<>();
//        queue.add(new Location(0, 0));
//
//        int pathCount = 0;
//        while (!queue.isEmpty()) {
//            Location current = queue.poll();
//            for (int i = 0; i < 2; i++) {
//                int nextX = current.x + direction[i][0];
//                int nextY = current.y + direction[i][1];
//                Location next = new Location(nextX, nextY);
//
//                if (canGo(map, next)) {
//                    queue.add(next);
//                    if (next.x == m - 1 && next.y == n - 1) {
//                        pathCount++;
//                    }
//                }
//            }
//        }
//        return pathCount;
//    }
//
//    public static boolean canGo(int[][] map, Location current) {
//        if (current.x < 0 || current.y > map.length - 1) return false;
//        if (current.y < 0 || current.x > map[0].length - 1) return false;
//        return true;
//    }

    public static class UnitTest {
        @Test
        public void test0() {
            Assert.assertEquals(0, uniquePaths(0, 0));
        }

        @Test
        public void test1() {
            Assert.assertEquals(3, uniquePaths(3, 2));
        }

        @Test
        public void test2() {
            Assert.assertEquals(28, uniquePaths(7, 3));
        }

        @Test
        public void test3() {
            Assert.assertEquals(1, uniquePaths(1, 1));
        }

        @Test
        public void test4() {
            Assert.assertEquals(64512240, uniquePaths(23, 11));
        }
    }
}
