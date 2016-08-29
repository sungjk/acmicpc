#include <cstdio>
using namespace std;

typedef long long ll;
const int INF = 987654321;
int numOfCoin, total;
int coin[101], cache[10005];

ll min(int a, int b) {
    if (a > b) return b;
    return a;
}

// i번째 동전을 선택했을 때, 가치의 합이 value인 동전의 수
// notSelect: i번째 동전을 선택하지 않았을 때
// select: i번째 동전을 선택하였을 때
ll count(int i, int value) {
    if (i > numOfCoin || value > total) return INF;
    if (i == numOfCoin) {
        if (value == total) return 0;
        return INF;
    }

    int ret = INF;
    ret = min(ret, count(i + 1, value));  // notSelect
    ret = min(ret, 1 + count(i, coin[i] + value)); // select
    return ret;
}

// 가치의 합이 value인 동전의 최소 개수
ll count2(int value) {
    if (value > total) return INF;
    if (value == total) return 0;

    int &ret = cache[value];
    if (ret > 0) return ret;

    ret = INF;
    for (int i = 0; i < numOfCoin; ++i) {
        ret = min(ret, 1 + count2(value + coin[i]));
    }
    return ret;
}

int main () {
    scanf("%d %d", &numOfCoin, &total);
    for (int i = 0; i < numOfCoin; ++i) {
        scanf("%d", &coin[i]);
    }
    printf("%lld\n", count2(0));

    return 0;
}
