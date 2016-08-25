#include <cstdio>
using namespace std;

int n, k;
int coin[101] = { 0, };
vector<vector<int> > cache;

int sol(int i, int value) {
    if (i > n) return 0;
    if (value > k) return 0;
    if (i == n) {
        if (value == k) {
            return 1;
        }
        return 0;
    }

    int& ret = cache[i][value];
    if (-1 != ret) return ret;

    ret = sol(i + 1, value) + sol(i, value + coin[i]);

    return ret;
}

int main() {
    scanf("%d %d", &n, &k);
    for (int i = 0; i < n; ++i)
        scanf("%d", &coin[i]);

    cache.assign(n + 1, vector<int>(k + 1, -1));
    printf("%d\n", sol(0, 0));

    return 0;
}
