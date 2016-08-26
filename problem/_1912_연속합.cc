#include <cstdio>
using namespace std;

int length;
int array[100001], cache[100001];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

// here번째 숫자를 선택하였을 때 최대 합
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
    int maxValue = 0;
    for (int i = 0; i < length; ++i) {
        maxValue = max(maxValue, select(i));
    }
    printf("%d\n", maxValue);

    return 0;
}
