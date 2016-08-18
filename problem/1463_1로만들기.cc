#include <cstdio>
#include <vector>
using namespace std;

const int INF = 987654321;
vector<int> cache;

int operate(int n) {
    if (n == 1) return 0;

    int &ret = cache[n];
    if (-1 != ret) return ret;

    int minValue = INF;
    if (n % 3 == 0) minValue = min(minValue, operate(n / 3) + 1);
    if (n % 2 == 0) minValue = min(minValue, operate(n / 2) + 1);
    if (n - 1 >= 1) minValue = min(minValue, operate(n - 1) + 1);

    return ret = minValue;
}

int main() {
    int N;
    scanf("%d", &N);
    cache.assign(N + 1, -1);
    int minValue = operate(N);
    printf("%d", minValue);

    return 0;
}
