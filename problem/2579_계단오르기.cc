#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

typedef unsigned long long ull;
const int INF = 987654321;
vector<int> stair;
vector<vector<ull> > cache;

// i번째 계단을 연속해서 n번 밟았을 때 최대값
ull go(int i, int n) {
    if (n == 3) return 0; // 연속 3번 밟았을 경우
    if (i <= -1) return 0; // 시작점에 도달한 경우

    ull &ret = cache[i][n];
    if (-1 != ret) return ret;

    int current = stair[i];
    ull oneStep = current + go(i - 1, n + 1);
    ull twoStep = current + go(i - 2, 1);
    ret = max(oneStep, twoStep);
    return ret;
}

int main() {
    int step, point;
    scanf("%d\n", &step);
    stair.assign(step, -1);
    cache.assign(step, vector<ull> (3, -1));
    for (int i = 0; i < step; ++i) {
        scanf("%d", &stair[i]);
    }

    int top = stair[step - 1];
    ull maxValue = top + max(go(step - 2, 2), go(step - 3, 1));
    printf("%lld\n", maxValue);

    return 0;
}
