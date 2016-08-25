#include <cstdio>
using namespace std;

typedef long long ll;
const int MOD = 1000000000;
int n;
ll cache[101][10];

// current 자리에서 num일 경우 계단의 수
// up: num보다 하나 작은 계단수 = check(current + 1, num - 1);
// down: num보다 하나 큰 계단수 = check(current + 1, num + 1);
ll check(int current, int num) {
    if (num > 9 || num < 0) return 0;
    if (current == n) return 1;

    ll &ret = cache[current][num];
    if (ret > 0) return ret;

    int up = check(current + 1, num - 1) % MOD;
    int down = check(current + 1, num + 1) % MOD;
    return ret = up + down;
}

int main() {
    scanf("%d", &n);

    ll result = 0;
    for (int i = 1; i < 10; ++i) {
        result += check(1, i) % MOD;
    }
    printf("%lld\n", result % MOD);

    return 0;
}
