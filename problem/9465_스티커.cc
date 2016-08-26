#include <cstdio>
using namespace std;

int n;
int stickers[100001][3];
int cache[100001][3];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

// i번째 스티커를 selected 했을 때 점수의 최대값
// 0: 아무것도 선택하지 않음 = i+1번째에 위 또는 아래 선택 가능
// 1: 위쪽 스티커 선택 = i+1번째에 아래쪽 선택 가능
// 2: 아래쪽 스티커 선택 = i+1번째에 위쪽 선택 가능
int select(int i, int selected) {
    if (i >= n + 1) return 0;

    int &ret = cache[i][selected];
    if (-1 != ret) return ret;

    ret = 0;
    if (selected == 0) {
        ret = max(ret, stickers[i][1] + select(i + 1, 1));
        ret = max(ret, stickers[i][2] + select(i + 1, 2));
    }
    else if (selected == 1) {
        ret = max(ret, stickers[i][2] + select(i + 1, 2));
    }
    else if (selected == 2) {
        ret = max(ret, stickers[i][1] + select(i + 1, 1));
    }
    ret = max(ret, select(i + 1, 0));

    return ret;
}

int main() {
    int testCase; scanf("%d", &testCase);
    while (testCase--) {
        scanf("%d", &n);
        for (int i = 0; i <= 2; ++i) {
            for (int j = 0; j <= n; ++j) {
                cache[j][i] = -1;
            }
        }

        for (int i = 1; i <= 2; ++i) {
            for (int j = 1; j <= n; ++j) {
                scanf("%d", &stickers[j][i]);
            }
        }
        printf("%d\n", select(0, 0));
    }

    return 0;
}
