import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jeremy on 03/12/2019.
 */
/*
input:
6
5
1 2
1 3
3 4
2 3
4 5

3
1
2 3

2
1
1 2

3
2
2 1
3 2

10
10
4 10
7 10
3 7
6 8
1 7
1 6
1 5
1 9
2 4
3 8

output:
3
0
1
2
7
 */
public class A5567 {
    public static int invite(boolean[][] relations, int n) {
        boolean[][] visited = new boolean[n + 1][n + 1];

        // 1촌만 초기화
        List<Integer> ilchons = IntStream.range(2, n + 1)
            .boxed()
            .filter(person -> {
                if (relations[1][person]) {
                    visited[1][person] = true;
                    visited[person][1] = true;
                    return true;
                }
                return false;
            })
            .collect(Collectors.toList());

        return IntStream.range(2, n + 1)
            .boxed()
            .filter(person -> {
                for (int ilchon : ilchons) {
                    if (ilchon == person) return true;
                    // 상근이와 1촌X && 순회X && 나와 1촌인 경우
                    if (!ilchons.contains(person) && !visited[person][ilchon] && relations[person][ilchon]) {
                        visited[person][ilchon] = true;
                        visited[ilchon][person] = true;
                        return true;
                    }
                }
                return false;
            })
            .collect(Collectors.toList())
            .size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] relations = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int person1 = sc.nextInt();
            int person2 = sc.nextInt();
            relations[person1][person2] = true;
            relations[person2][person1] = true;
        }

        System.out.println(invite(relations, n));
    }
}
