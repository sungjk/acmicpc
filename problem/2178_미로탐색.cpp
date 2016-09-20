#include <cstdio>
#include <queue>
using namespace std;

const int DIR[4][2] = {
	0, -1,
	1, 0,
	0, 1,
	-1, 0
};
struct Pos {
	int x, y, cost;
	Pos() : x(0), y(0), cost(0) {}
	Pos(int x, int y, int cost) : x(x), y(y), cost(cost) {}
};
queue<Pos> q;
int maze[101][101], visited[101][101];
int lengthX, lengthY;

bool canGo(Pos here) {
	if (here.x < 1 || here.x > lengthX) return false;
	if (here.y < 1 || here.y > lengthY) return false;
	if (maze[here.y][here.x] == 0) return false;
	if (visited[here.y][here.x]) return false;
	return true;
}

int bfs() {
	Pos here;
	q.push(Pos(1, 1, 1));
	while (!q.empty()) {
		here = q.front(); q.pop();
		for (int i = 0; i < 4; ++i) {
			Pos next(here.x + DIR[i][0], here.y + DIR[i][1], here.cost + 1);
			if (canGo(next)) {
				q.push(next);
				visited[next.y][next.x] = next.cost;
			}
		}
	}
	
	return visited[lengthY][lengthX];
}

int main() {
	scanf("%d %d", &lengthY, &lengthX);
	for (int y = 1; y <= lengthY; ++y) {
		for (int x = 1; x <= lengthX; ++x) {
			scanf("%1d", &maze[y][x]);
		}
	}

	printf("%d\n", bfs());

	return 0;
}