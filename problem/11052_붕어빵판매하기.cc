#include <cstdio>
#include <vector>
using namespace std;

int bread[1001];
int cache[1001][1001];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

// n개의 붕어빵을 i개 팔았을 때 최대 수익
// select: i개 가격 + 나머지 = bread[i] + sell(n - i, i)
// notSelect: sell(n, i + 1)
int sell(int n, int i) {
    if (n == 1) return bread[n];
    if (i > n) return 0;

    int &ret = cache[n][i];
    if (ret > 0) return ret;

    ret = max(ret, bread[i] + sell(n - i, i)); // select
    ret = max(ret, sell(n, i + 1)); // notSelect
    return ret;
}

int main() {
    int n; scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &bread[i]);
    }

    printf("%d\n", sell(n, 1));

    return 0;
}
