import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by jeremy on 03/13/2019.
 */
public class A7562 {
    public static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = new int[][] {
        { 1, -2 },
        { 2, -1 },
        { 2, 1 },
        { 1, 2 },
        { -1, 2 },
        { -2, 1 },
        { -2, -1 },
        { -1, -2 }
    };

    public static boolean canGo(int[][] chessMap, boolean[][] visited, Position current) {
        if (current.x < 0 || current.x > chessMap.length - 1) return false;
        if (current.y < 0 || current.y > chessMap.length - 1) return false;
        if (visited[current.y][current.x]) return false;
        return true;
    }

    public static void tour(int[][] chessMap, Position start, Position end) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[chessMap.length][chessMap.length];
        queue.add(start);
        visited[start.y][start.x] = true;
        chessMap[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dir[i][0];
                int nextY = current.y + dir[i][1];
                Position next = new Position(nextX, nextY);
                if (canGo(chessMap, visited, next)) {
                    queue.add(next);
                    visited[next.y][next.x] = true;
                    chessMap[next.y][next.x] = chessMap[current.y][current.x] + 1;
                    if (current.x == end.x && current.y == end.y) return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        IntStream.range(0, testCases)
            .map(i -> {
                int length = sc.nextInt();
                int startX = sc.nextInt();
                int startY = sc.nextInt();
                int endX = sc.nextInt();
                int endY = sc.nextInt();
                int[][] chessMap = new int[length][length];
                tour(chessMap, new Position(startX, startY), new Position(endX, endY));
                return chessMap[endY][endX];
            })
            .boxed()
            .forEach(System.out::println);
    }
}
