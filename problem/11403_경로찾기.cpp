#include <iostream>
#include <vector>
using namespace std;

int n;
vector<vector<int> > map;
vector<vector<int> > check;
vector<int> visit;

void dfs(int v) {
	for (int begin = 0; begin < n; ++begin) {
		if (map[v][begin] == 1 && visit[begin] == 0) {
			visit[begin] = 1;
			dfs(begin);
		}
	}
}

void tour() {
	for (int v = 0; v < n; ++v) {
		dfs(v);
		for (int begin = 0; begin < n; ++begin) {
			check[v][begin] = visit[begin];
			visit[begin] = 0;
		}
	}
}

void print() {
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cout << check[i][j] << " ";
		}
		cout << endl;
	}
}

int main() {
	cin >> n;
	map.assign(n + 1, vector<int>(n + 1, 0));
	check.assign(n + 1, vector<int>(n + 1, 0));
	visit.assign(n + 1, 0);
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> map[i][j];
		}
	}
	tour();
	print();

	return 0;
}