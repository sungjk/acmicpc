#include <cstdio>
using namespace std;

typedef long long ll;
ll array[101] = { 0, 1, 1, 1, 2, 2, };
ll cache[101];

// n번째 파도반 수열의 길이
ll surf(int n) {
    if (n < 6) return array[n];

    ll &ret = cache[n];
    if (ret > 0) return ret;
    return ret = surf(n - 5) + surf(n - 1);
}

int main() {
    int testCase; scanf("%d", &testCase);
    for (int i = 0; i < testCase; ++i) {
        int n; scanf("%d", &n);
        printf("%lld\n", surf(n));
    }

    return 0;
}
