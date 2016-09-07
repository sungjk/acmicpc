#include <cstdio>
using namespace std;

const int DIR[2][2] = {
	1, 0,
	0, 1
};
int lengthX, lengthY;
int circle, circleX, circleY;
int cache[16][16][16][16];

void getCirclePosition() {
	int pos[2];
	for (int y = 1; y <= lengthY; ++y) {
		for (int x = 1; x <= lengthX; ++x) {
			if (circle == (y * lengthX - (lengthX - x))) {
				circleX = x; circleY = y;
				return;
			}
		}
	}
}

int tour(int startX, int startY, int endX, int endY) {
	if (startX == endX && startY == endY) return 1;

	int &ret = cache[startX][startY][endX][endY];
	if (-1 != ret) return ret;

	ret = 0;
	for (int i = 0; i < 2; ++i) {
		int nextX = startX + DIR[i][0];
		int nextY = startY + DIR[i][1];
		if (nextX >= 1 && nextX <= endX && nextY >= 1 && nextY <= endY) {
			ret += tour(nextX, nextY, endX, endY);
		}
	}
	return ret;
}

int main() {
	scanf("%d %d %d", &lengthY, &lengthX, &circle);
	for (int i = 1; i <= lengthX; ++i)
		for (int j = 1; j <= lengthY; ++j)
			for (int n = 1; n <= lengthX; ++n)
				for (int m = 1; m <= lengthY; ++m)
					cache[i][j][n][m] = -1;
	int numOfPath;
	if (circle == 0) {
		numOfPath = tour(1, 1, lengthX, lengthY);
	}
	else {
		getCirclePosition();
		int beforeCircle = tour(1, 1, circleX, circleY);
		int afterCircle = tour(circleX, circleY, lengthX, lengthY);
		numOfPath = beforeCircle * afterCircle;
	}
	printf("%d\n", numOfPath);

	return 0;
}