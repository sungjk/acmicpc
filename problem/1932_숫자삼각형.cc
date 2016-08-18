#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = -987654321;
vector<vector<int> > triangle;
vector<vector<int> > cache;

int calculate(int x, int y) {
    if (x < y) return 0;
    if (x > triangle.size() - 1 || y > triangle.size() - 1) return 0;

    int &ret = cache[x][y];
    if (-1 != ret) return ret;

    int current = triangle[x][y];
    int leftDown = calculate(x + 1, y);
    int rightDown = calculate(x + 1, y + 1);
    ret = max(ret, current + leftDown);
    ret = max(ret, current + rightDown);

    return ret;
}

int main() {
    int size;
    scanf("%d\n", &size);
    triangle.assign(size, vector<int> (size, 0));
    cache.assign(size, vector<int> (size, -1));
    for (int i = 0; i < triangle.size(); ++i) {
        for (int j = 0; j <= i; ++j) {
            scanf("%d", &triangle[i][j]);
        }
    }

    printf("%d\n", calculate(0, 0));

    return 0;
}
