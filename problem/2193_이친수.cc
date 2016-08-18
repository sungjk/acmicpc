#include <cstdio>
#include <vector>
using namespace std;

typedef long long ll;
int N;
vector<vector<ll> > cache;

// i번째의 이전 자리 수가 b일 때 이친수의 개수
ll get(int i, int b) {
    if (i == N) {
        if (b == 0) return 2;
        else if (b == 1) return 1;
    }

    ll &ret = cache[i][b];
    if (-1 != ret) return ret;

    if (b == 0) ret = get(i + 1, 0) + get(i + 1, 1);
    else if (b == 1) ret = get(i + 1, 0);
    return ret;
}

int main() {
    scanf("%d", &N);
    if (N == 1) {
        printf("%d\n", 1);
        return 0;
    }
    cache.assign(N + 1, vector<ll> (N + 1, -1));
    ll numOfPrimary = get(2, 1); // 이친수는 1부터 시작
    printf("%lld\n", numOfPrimary);

    return 0;
}
