#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Node {
	int floor, count;
	Node() : floor(0), count(0) {}
	Node(int floor, int count) : floor(floor), count(count) {}
};
int top, start, dest, u, d;
vector<int> visited;

int tour() {
	const int DIR[2] = { u, -d };
	visited.assign(top + 1, 0);

	Node s(start, 0);
	queue<Node> que;
	que.push(s);
	visited[start] = 1;

	Node here;
	while (!que.empty()) {
		here = que.front(); que.pop();
		if (dest == here.floor) {
			return here.count;
		}

		for (int d = 0; d < 2; ++d) {
			Node next;
			next.floor = here.floor + DIR[d];
			if (next.floor > 0 && next.floor <= top && 0 == visited[next.floor]) {
				next.count = here.count + 1;
				visited[next.floor] = 1;
				que.push(next);
			}
		}
	}
	return -1;
}

int main() {
	cin >> top >> start >> dest >> u >> d;
	int ret = tour();
	if (-1 == ret) {
		cout << "use the stairs" << endl;
		return 0;
	}
	cout << ret << endl;

	return 0;
}