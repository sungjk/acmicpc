import java.util.Scanner;

/**
 * Created by jeremy on 03/11/2019.
 */
/*
input:
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

output:
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0
 */
public class A11404 {

    public static int[][] initCityMap(Scanner sc, int numOfCity, int numOfBus) {
        int[][] cityMap = new int[numOfCity + 1][numOfCity + 1];
        for (int y = 1; y <= numOfCity; y++) {
            for (int x = 1; x <= numOfCity; x++) {
                cityMap[y][x] = 0;
            }
        }
        for (int i = 0 ; i < numOfBus; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            cityMap[from][to] = cityMap[from][to] == 0 ? cost : Math.min(cityMap[from][to], cost);
        }
        sc.close();
        return cityMap;
    }

    public static void tour(int[][] cityMap, int numOfCity) {
        // from -> mid -> to: from에서 to로 가는 경로 중 mid를 거쳐서 가는 경우
        for (int mid = 1; mid <= numOfCity; mid++) {
            for (int from = 1; from <= numOfCity; from++) {
                if (cityMap[from][mid] == 0) continue;
                for (int to = 1; to <= numOfCity; to++) {
                    if (cityMap[mid][to] == 0 || from == to) continue;
                    int withMid = cityMap[from][mid] + cityMap[mid][to];
                    cityMap[from][to] = cityMap[from][to] == 0 ? withMid : Math.min(cityMap[from][to], withMid);
                }
            }
        }
    }

    public static void print(int[][] cityMap, int numOfCity) {
        for (int y = 1; y <= numOfCity; y++) {
            for (int x = 1; x <= numOfCity; x++) {
                 System.out.print((cityMap[y][x] == Integer.MAX_VALUE ? 0 : cityMap[y][x]) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCity = sc.nextInt();
        int numOfBus = sc.nextInt();
        int[][] cityMap = initCityMap(sc, numOfCity, numOfBus);
        tour(cityMap, numOfCity);
        print(cityMap, numOfCity);
    }

}
