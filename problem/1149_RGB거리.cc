#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = 987654321;
vector<vector<int> > rgb;
vector<vector<int> > cache;

// i번째 집을 color로 칠할 때 최솟 값
int paint(int i, int color) {
    if (i > rgb.size() - 1) return 0;

    int &ret = cache[i][color];
    if (-1 != ret) return ret;

    ret = INF;
    for (int c = 0; c < 3; ++c) {
        int current = rgb[i][c];
        if (c != color) { // 이웃하지 않은 색이라면
            int next = current + paint(i + 1, c);
            ret = min(ret, next);
        }
    }
    return ret;
}

int main() {
    int N;
    scanf("%d", &N);
    rgb.assign(N, vector<int>(3, -1));
    cache.assign(N, vector<int>(3, -1));
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < 3; ++j) {
            scanf("%d", &rgb[i][j]);
        }
    }

    int minValue = INF;
    for (int i = 0; i < 3; ++i) {
        minValue = min(minValue, paint(0, i));
    }
    printf("%d\n", minValue);

    return 0;
}
