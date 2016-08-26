#include <cstdio>
using namespace std;

int length;
int array[1001], cache[1001];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

// here번째 부터 시작하는 증가 수열의 길이
int go(int here) {
    int &ret = cache[here];
    if (ret > 0) return ret;

    ret = 1;
    for (int i = here + 1; i < length; ++i) {
        if (array[here] < array[i])
            ret = max(ret, go(i) + 1);
    }
    return ret;
}

int main() {
    scanf("%d", &length);
    for (int i = 0; i < length; ++i) {
        scanf("%d", &array[i]);
    }

    int maxLength = 0;
    for (int i = 0; i < length; ++i) {
        maxLength = max(maxLength, go(i));
    }
    printf("%d\n", maxLength);

    return 0;
}
