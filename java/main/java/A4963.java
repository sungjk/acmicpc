import java.util.Scanner;

/**
 * Created by jeremy on 03/11/2019.
 */
public class A4963 {

    private static boolean[][] visited;

    private static int[][] direction = {
        { 0, -1 },  // UP
        { 1, -1 },  // RIGHTUP
        { 1, 0 },   // RIGHT
        { 1, 1 },   // RIGHTDOWN
        { 0, 1 },   // DOWN
        { -1, 1 },  // LEFTDOWN
        { -1, 0 },  // LEFT
        { -1, -1 }  // LEFTUP
    };

    public static boolean canGo(int[][] island, int nextX, int nextY) {
        if (nextX < 0 || nextX > island[0].length - 1) return false;
        if (nextY < 0 || nextY > island.length - 1) return false;
        if (visited[nextY][nextX]) return false;
        return island[nextY][nextX] == 1;
    }

    public static void tour(int[][] island, int currentX, int currentY) {
        visited[currentY][currentX] = true;
        for (int i = 0; i < 8; i++) {
            int nextX = currentX + direction[i][0];
            int nextY = currentY + direction[i][1];
            if (canGo(island, nextX, nextY) && island[nextY][nextX] == 1) {
                tour(island, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int width = sc.nextInt();
            int height = sc.nextInt();
            if (width == 0 && height == 0) return;

            int[][] island = new int[height][width];
            visited = new boolean[height][width];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    island[y][x] = sc.nextInt();
                }
            }

            int numOfIsland = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (!visited[y][x] && island[y][x] == 1) {
                        numOfIsland++;
                        tour(island, x, y);
                    }
                }
            }

            System.out.println(numOfIsland);
        }
    }

}
