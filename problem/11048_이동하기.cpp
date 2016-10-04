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

// #include <iostream>
// #include <vector>
// #include <algorithm>
// using namespace std;
//
// const int DIR[3][2] = {
//     1, 0,
//     0, 1,
//     1, 1
// };
// vector<vector<int> > maze;
// vector<vector<int> > cache;
//
// // (x, y)에 있을 떄 사탕의 최대 개수
// int tour(int x, int y) {
//     if (x == maze[0].size() - 1 && y == maze.size() - 1) return maze[y][x];
//
//     int& ret = cache[y][x];
//     if (-1 != ret) return ret;
//
//     for (int d = 0; d < 3; ++d) {
//         int nextx = x + DIR[d][0];
//         int nexty = y + DIR[d][1];
//         if (nextx <= maze[0].size() - 1 && nexty <= maze.size() - 1) {
//             ret = max(ret, maze[y][x] + tour(nextx, nexty));
//         }
//     }
//     return ret;
// }
//
// int main() {
//     int width, height; cin >> height >> width;
//     maze.assign(height + 1, vector<int>(width + 1, 0));
//     cache.assign(height + 2, vector<int>(width + 2, -1));
//     for (int y = 1; y <= maze.size() - 1; ++y) {
//         for (int x = 1; x <= maze[0].size() - 1; ++x) {
//             cin >> maze[y][x];
//         }
//     }
//     cout << tour(1, 1) << endl;
//
//     return 0;
// }
