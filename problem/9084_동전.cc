#include <cstdio>
using namespace std;

int numOfCoin, totalMoney;
int coin[21], cache[21][10001];

// here번째 동전을 선택할 때 금액 money를 만들 수 있는 방법의 수
int select(int here, int money) {
    if (money > totalMoney) return 0;
    if (money == totalMoney) return 1;

    int &ret = cache[here][money];
    if (-1 != ret) return ret;

    ret = 0;
    for (int begin = here; begin < numOfCoin; ++begin) {
        ret += select(begin, coin[begin] + money);
    }

    return ret;
}

int main() {
    int testCase; scanf("%d", &testCase);
    while (testCase--) {
        scanf("%d", &numOfCoin);
        for (int i = 0; i < numOfCoin; ++i) {
            scanf("%d", &coin[i]);
        }
        scanf("%d", &totalMoney);
        // init cache
        for (int i = 0; i <= numOfCoin; ++i) {
            for (int j = 0; j <= totalMoney; ++j) {
                cache[i][j] = -1;
            }
        }

        printf("%d\n", select(0, 0));
    }

    return 0;
}
