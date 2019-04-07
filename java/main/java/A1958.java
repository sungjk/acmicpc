import java.util.Scanner;

/*
input:
abcdefghijklmn
bdefg
efg

output:
3
*/
public class A1958 {

    private static String aaa;
    private static String bbb;
    private static String ccc;

    public static int recursiveLCS(int currA, int currB, int currC, int[][][] cache) {
        if (aaa.length() == currA || bbb.length() == currB || ccc.length() == currC) return 0;
        if (cache[currA][currB][currC] != 0) return cache[currA][currB][currC];

        if (aaa.charAt(currA) == bbb.charAt(currB) && bbb.charAt(currB) == ccc.charAt(currC)) {
            return cache[currA][currB][currC] = 1 + recursiveLCS(currA + 1, currB + 1, currC + 1, cache);
        } else {
            int first = nextRecursiveLCS(currA + 1, currB, currC, cache);
            int second = nextRecursiveLCS(currA, currB + 1, currC, cache);
            int third = nextRecursiveLCS(currA, currB, currC + 1, cache);
            return cache[currA][currB][currC] = Math.max(first, Math.max(second, third));
        }
    }

    public static int nextRecursiveLCS(int nextA, int nextB, int nextC, int[][][] cache) {
        if (cache[nextA][nextB][nextC] != 0) return cache[nextA][nextB][nextC];
        return cache[nextA][nextB][nextC] = recursiveLCS(nextA, nextB, nextC, cache);
    }

    // hits: cache[i][j][k] = 1 + cache[i - 1][j - 1][k - 1]
    // miss: cache[i][j][k] = max(cache[i - 1][j][k], cache[i][j - 1][k], cache[i][j][k - 1])
    public static void iterateLCS(int[][][] cache) {
        for (int i = 1; i <= aaa.length(); i++) {
            for (int j = 1; j <= bbb.length(); j++) {
                for (int k = 1; k <= ccc.length(); k++) {
                    if (aaa.charAt(i - 1) == bbb.charAt(j - 1) && bbb.charAt(j - 1) == ccc.charAt(k - 1)) {
                        cache[i][j][k] = 1 + cache[i - 1][j - 1][k - 1];
                    }
                    cache[i][j][k] = Math.max(cache[i - 1][j][k], cache[i][j][k]);
                    cache[i][j][k] = Math.max(cache[i][j - 1][k], cache[i][j][k]);
                    cache[i][j][k] = Math.max(cache[i][j][k - 1], cache[i][j][k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        aaa = sc.next();
        bbb = sc.next();
        ccc = sc.next();
        int[][][] cache = new int[aaa.length() + 1][bbb.length() + 1][ccc.length() + 1];
//        System.out.println(recursiveLCS(aaa, bbb, ccc, 0, 0, 0, cache));
        iterateLCS(cache);
        System.out.println(cache[aaa.length()][bbb.length()][ccc.length()]);
    }

}