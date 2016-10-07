#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

enum {
	EMPTY, BUG
};
const int VISIT = 1;
const int DIR[4][2] = {
	-1, 0,
	0, -1,
	1, 0,
	0, 1
};
struct Node {
	int x, y;
	Node() : x(0), y(0) {}
	Node(int x, int y) : x(x), y(y) {}
};
vector<vector<int> > land;
vector<vector<int> > visited;

bool canGo(int x, int y) {
	if (x < 0 || x > land[0].size() - 1) return false;
	if (y < 0 || y > land.size() - 1) return false;
	if (VISIT == visited[y][x]) return false;
	if (EMPTY == land[y][x]) return false;
	return true;
}

void bfs(Node start) {
	queue<Node> que;
	que.push(start);
	visited[start.y][start.x] = VISIT;

	Node here;
	while (!que.empty()) {
		here = que.front(); que.pop();
		for (int d = 0; d < 4; ++d) {
			Node next(here.x + DIR[d][0], here.y + DIR[d][1]);
			if (canGo(next.x, next.y)) {
				que.push(next);
				visited[next.y][next.x] = VISIT;
			}
		}
	}
}

int main() {
	int testCase; scanf("%d", &testCase);
	int width, height, vegetable;
	while (testCase--) {
		scanf("%d %d %d", &width, &height, &vegetable);
		land.assign(height, vector<int>(width, EMPTY));
		visited.assign(height + 1, vector<int>(width, 0));
		int x, y;
		for (int i = 0; i < vegetable; ++i) {
			scanf("%d %d", &x, &y);
			land[y][x] = BUG;
		}

		int value = 0;
		for (int y = 0; y < land.size(); ++y) {
			for (int x = 0; x < land[0].size(); ++x) {
				if (0 == visited[y][x] && BUG == land[y][x]) {
					++value;
					bfs(Node(x, y));
				}
			}
		}
		cout << value << endl;
	}
	return 0;
}