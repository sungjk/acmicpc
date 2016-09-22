#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

const int INF = 987654321;
const int DIR[4][2] = {
	0, 1,
	1, 0,
	0, -1,
	-1, 0
};
int height, width, cache = INF;
vector<vector<int> > map;
vector<vector<bool> > visited;

bool canGo(int x, int y) {
	if (x < 1 || x > width) return false;
	if (y < 1 || y > height) return false;
	if (visited[y][x]) return false;
	return true;
}

// (x, y)에서 이동한 거리가 here이고, 벽을 통과하거나 할 수 없을 때 최단 거리
int tour(int x, int y, int here, bool canBreak) {
	if (cache <= here) return here; // 시간초과 해결!!
	if (here > width * height) {
		return INF;
	}
	if (x == width && y == height) {
		return cache = here;
	}

	int dist = INF;
	visited[y][x] = true;
	for (int d = 0; d < 4; ++d) {
		int nextx = x + DIR[d][0];
		int nexty = y + DIR[d][1];
		if (canGo(nextx, nexty)) {
			if (0 == map[nexty][nextx]) {
				dist = min(dist, tour(nextx, nexty, 1 + here, canBreak));
			}
			if (1 == map[nexty][nextx] && canBreak) {
				dist = min(dist, tour(nextx, nexty, 1 + here, false));
			}
		}
	}
	visited[y][x] = false;

	return dist;
}

int main() {
	cin >> height >> width;
	map.assign(height + 2, vector<int>(width + 2, 1));
	visited.assign(height + 2, vector<bool>(width + 2, false));
	for (int h = 1; h <= height; ++h) {
		for (int w = 1; w <= width; ++w) {
			scanf("%1d", &map[h][w]);
		}
	}

	int dist = tour(1, 1, 1, true);
	if (INF == dist) {
		cout << -1 << endl;
	}
	else {
		cout << dist << endl;
	}

	return 0;
}