#include <cstdio>
using namespace std;

typedef long long ll;
int length;
ll cache[65][10];

// here번째 자리의 숫자가 num인 줄어들지 않는 수의 개수
ll find(int here, int num) {
    if (here == length - 1) return 1;

    ll &ret = cache[here][num];
    if (-1 != ret) return ret;

    ret = 0;
    for (int begin = 0; begin <= num; ++begin) {
        ret += find(here + 1, begin);
    }
    return ret;
}

int main() {
    int testCase; scanf("%d", &testCase);
    while (testCase--) {
        scanf("%d", &length);
        for (int i = 0; i <= length; ++i) {
            for (int j = 0; j <= 9; ++j) {
                cache[i][j] = -1;
            }
        }
        ll ret = 0;
        for (int begin = 0; begin <= 9; ++begin) {
            ret += find(0, begin);
        }
        printf("%lld\n", ret);
    }



    return 0;
}
