#include <cstdio>
using namespace std;

const int DIR[4][2] = {
	0, -1,
	1, 0,
	0, 1,
	-1, 0
};
int day;
int forest[501][501], cache[501][501];

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

// 판다가 (x, y)에서 살아갈 때 일수
int tour(int x, int y) {
	if (x < 0 || x >= day || y < 0 || y >= day) return 0;

	int &ret = cache[x][y];
	if (ret > 0) return ret;

	ret = 1;
	for (int i = 0; i < 4; ++i) {
		int nextX = x + DIR[i][0];
		int nextY = y + DIR[i][1];
		if (forest[x][y] < forest[nextX][nextY]) {
			ret = max(ret, 1 + tour(nextX, nextY));
		}
	}
	return ret;
}

int main() {
	scanf("%d", &day);
	for (int i = 0; i < day; ++i) {
		for (int j = 0; j < day; ++j) {
			scanf("%d", &forest[i][j]);
		}
	}

	int maxValue = 1;
	for (int i = 0; i < day; ++i) {
		for (int j = 0; j < day; ++j) {
			maxValue = max(maxValue, tour(i, j));
		}
	}
	printf("%d\n", maxValue);

	return 0;
}