#include <cstdio>
using namespace std;

const int MOD = 10007;
int cache[1001];

// 길이가 length인 타일을 채우는 방법의 수
// oneXtwo: 마지막에 | 모양 하나를 추가하는 방법
// twoXone: 마지막에 -- 모양 두 개를 위 아래로 추가하는 방법
int divide(int length) {
    if (length <= 2) return length;

    int &ret = cache[length];
    if (ret > 0) return ret;

    int oneXtwo = divide(length - 1) % MOD;
    int twoXone = divide(length - 2) % MOD;
    return ret = oneXtwo + twoXone;
}

int main() {
    int length; scanf("%d", &length);
    printf("%d\n", divide(length) % MOD);
    return 0;
}
