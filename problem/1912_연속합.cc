#include <cstdio>
using namespace std;

const int INF = -987654321;
int length;
int array[100001], cache[100001];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

// here번째 숫자를 선택하였을 때 최대 연속합
// array[here]: 새로 연속합을 시작하는 부분
// select(here + 1): 다음 수를 연속합에 포함시킬 경우
int select(int here) {
    if (here >= length) return 0;

    int &ret = cache[here];
    if (ret > 0) return ret;
    ret = array[here];
    ret = max(ret, select(here + 1) + array[here]);
    return ret;
}

int main() {
    scanf("%d", &length);
    for (int i = 0; i < length; ++i) {
        scanf("%d", &array[i]);
    }
    int maxValue = INF;
    for (int i = 0; i < length; ++i) {
        maxValue = max(maxValue, select(i));
    }
    printf("%d\n", maxValue);

    return 0;
}
