#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int> > board;
vector<bool> visited;

// 아직 방문하지 않았고, here에서 next로 이동할 수 있는 경우
void dfs(int here) {
	visited[here] = true;
	cout << here << " ";
	for (int next = 1; next < board.size(); ++next) {
		if (false == visited[next] && 1 == board[here][next]) {
			dfs(next);
		}
	}
}

// 아직 방문하지 않았고, here에서 next로 이동할 수 있는 경우
void bfs(int start) {
	queue<int> que;
	que.push(start);
	visited[start] = true;

	int here;
	while (!que.empty()) {
		here = que.front(); que.pop();
		cout << here << " ";
		for (int next = 1; next < board.size(); ++next) {
			if (false == visited[next] && 1 == board[here][next]) {
				visited[next] = true;
				que.push(next);
			}
		}
	}
}

int main() {
	int N, M, start;
	cin >> N >> M >> start;
	board.assign(N + 1, vector<int>(N + 1, 0));
	int from, to;
	for (int i = 0; i < M; ++i) {
		cin >> from >> to;
		board[from][to] = board[to][from] = 1;
	}

	visited.assign(N + 1, false);
	dfs(start); cout << endl;
	visited.assign(N + 1, false);
	bfs(start); cout << endl;

	return 0;
}