#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > graph;
vector<bool> visited;

int dfs(int here) {
    visited[here] = true;
    for (int next = here + 1; next < graph[here].size(); ++next) {
        if (1 == graph[here][next] && !visited[next]) {
            dfs(next);
        }
    }
    return 1;
}

int main() {
    int vertex, edge; cin >> vertex >> edge;
    graph.assign(vertex + 1, vector<int>(vertex + 1, 0));
    int from, to;
    for (int i = 0; i < edge; ++i) {
        cin >> from >> to;
        graph[from][to] = graph[to][from] = 1;
    }

    int group = 0;
    visited.assign(vertex + 1, false);
    for (int v = 1; v <= graph.size() - 1; ++v) {
        if (!visited[v]) {
            group += dfs(v);
        }
    }
    cout << group << endl;

    return 0;
}
