#include <cstdio>
#include <vector>
using namespace std;

typedef long long ll;
vector<vector<int> > arr;
vector<vector<ll> > cache;
int endX, endY;

ll calculate(int i, int j) {
    if (i > endX || j > endY) return 0;

    ll &ret = cache[i][j];
    if (-1 != ret) return 0;

    int here = arr[i][j];
    int down = calculate(i + 1, j);
    int right = calculate(i, j + 1);
    ret = here + down + right;
    return ret;
}

int main() {
    int N, M;
    scanf("%d %d\n", &N, &M);
    arr.assign(N, vector<int> (M, 0));
    for (int i = 0; i < arr.size(); ++i) {
        for (int j = 0; j < arr[0].size(); ++j) {
            scanf("%d", &arr[i][j]);
        }
    }

    int numOfTestCase;
    scanf("%d\n", &numOfTestCase);
    int startX, startY;
    for (int i = 0; i < numOfTestCase; ++i) {
        cache.assign(N, vector<ll> (M, -1));
        scanf("%d %d %d %d", &startX, &startY, &endX, &endY);
        --endX; --endY;
        printf("%lld\n", calculate(startX - 1, startY - 1));
    }

    return 0;
}
