#include <cstdio>
using namespace std;

const int MOD = 10007;
int cache[1001][10];
int length;

// i번째 자리 숫자가 num인 오르막 수의 갯수
int count(int i, int num) {
    if (i == length) return 1;

    int &ret = cache[i][num];
    if (ret > 0) return ret;

    ret = 0;
    // i번째 자리 숫자와 같은 수부터 9까지 카운팅
    for (int j = num; j < 10; ++j) {
        ret += count(i + 1, j) % MOD;
    }
    return ret % MOD;
}

int main() {
    scanf("%d", &length);
    printf("%d\n", count(0, 0));

    return 0;
}
