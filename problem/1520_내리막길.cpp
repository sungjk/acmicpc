#include <cstdio>
using namespace std;

typedef unsigned long long ull;
const int INF = 987654321;
const int DIR[4][2] = {
	0, -1,
	1, 0,
	0, 1,
	-1, 0
};

int endX, endY;
int height[501][501];
int cache[501][501];

// (x,y)부터 도착 지점까지 경로의 개수
ull tour(int x, int y) {
	if (x < 0 || x >= endX || y < 0 || y >= endY) return 0;
	if (x == endX - 1 && y == endY - 1) return 1;

	int &ret = cache[x][y];
	if (ret > 0) return ret;

	ret = 0;
	int here = height[x][y];
	for (int i = 0; i < 4; ++i) {
		int nextX = x + DIR[i][0];
		int nextY = y + DIR[i][1];
		int next = height[nextX][nextY];
		if (here > next) {
			ret += tour(nextX, nextY);
		}
	}
	return ret;
}

int main() {
	scanf("%d %d", &endX, &endY);
	for (int i = 0; i < endX; ++i) {
		for (int j = 0; j < endY; ++j) {
			scanf("%d", &height[i][j]);
		}
	}
	printf("%lld\n", tour(0, 0));

	return 0;
}