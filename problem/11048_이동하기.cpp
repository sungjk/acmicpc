#include <cstdio>
using namespace std;

const int DIR[3][2] = {
	1, 0,
	0, 1,
	1, 1
};
int candy[1001][1001], cache[1003][1003];
int endX, endY;

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

// (x, y)에서 도착 지점까지 가져올 수 있는 사탕 개수의 최대값
int tour(int x, int y) {
	if (x < 0 || x >= endX || y < 0 || y >= endY) return 0;
	if (x == endX - 1 && y == endY - 1) return candy[x][y];

	int &ret = cache[x][y];
	if (-1 != ret) return ret;

	ret = 0;
	for (int i = 0; i < 3; ++i) {
		int nextX = x + DIR[i][0];
		int nextY = y + DIR[i][1];
		ret = max(ret, candy[x][y] + tour(nextX, nextY));
	}
	return ret;
}

int main() {
	scanf("%d %d", &endX, &endY);
	// init cache;
	for (int i = 0; i < endX; ++i) {
		for (int j = 0; j < endY; ++j) {
			cache[i][j] = -1;
		}
	}
	// init candy
	for (int i = 0; i < endX; ++i) {
		for (int j = 0; j < endY; ++j) {
			scanf("%d", &candy[i][j]);
		}
	}
	printf("%d\n", tour(0, 0));

	return 0;
}