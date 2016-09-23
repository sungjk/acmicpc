#include <iostream>
#include <vector>
#include <queue>
using namespace std;

const int INF = 987654321;
struct Node {
	int to, dist;
	Node() : to(0), dist(0) {}
	Node(int to, int dist) : to(to), dist(dist) {}
};
vector<vector<int> > relation;
vector<int> visited;

int bfs(int start) {
	queue<Node> que;
	que.push(Node(start, 0));
	visited[start] = true;

	int answer = 0;
	Node here;
	while (!que.empty()) {
		here = que.front(); que.pop();
		for (int next = 1; next < relation.size(); ++next) {
			Node there;
			if (false == visited[next] && 1 == relation[here.to][next]) {
				there.to = next;
				there.dist = here.dist + 1;
				que.push(there);
				visited[next] = true;
				answer += there.dist;
			}
		}
	}
	return answer;
}

int main() {
	int N, M;
	cin >> N >> M;
	relation.assign(N + 1, vector<int>(N + 1, 0));

	int from, to;
	for (int i = 0; i < M; ++i) {
		cin >> from >> to;
		relation[from][to] = relation[to][from] = 1;
	}

	int who, kevin, minValue = INF;
	for (int person = 1; person < relation.size(); ++person) {
		visited.assign(N + 1, false);
		kevin = bfs(person);
		if (minValue > kevin) {
			minValue = kevin;
			who = person;
		}
	}
	cout << who << endl;

	return 0;
}