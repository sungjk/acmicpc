#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

const int DIR[4][2] = {
    0, -1,
    1, 0,
    0, 1,
    -1, 0
};
struct Node {
    int x, y;
    Node() : x(0), y(0) {}
    Node(int x, int y) : x(x), y(y) {}
};
vector<vector<int> > map;
vector<vector<int> > visited;

bool canGo(int x, int y) {
    if (x < 1 || x > map[0].size() - 1) return false;
    if (y < 1 || y > map.size() - 1) return false;
    if (1 == visited[y][x]) return false;
    if (0 == map[y][x]) return false;
    return true;
}

int bfs(int x, int y) {
    queue<Node> que;
    que.push(Node(x, y));
    visited[y][x] = 1;

    Node here;
    int maxValue = 0;
    while (!que.empty()) {
        here = que.front(); que.pop();
        ++maxValue;
        for (int d = 0; d < 4; ++d) {
            Node next(here.x + DIR[d][0], here.y + DIR[d][1]);
            if (canGo(next.x, next.y)) {
                que.push(next);
                visited[next.y][next.x] = 1;
            }
        }
    }
    return maxValue;
}

int main() {
    int width, height, trash; cin >> height >> width >> trash;
    map.assign(height + 1, vector<int>(width + 1, 0));
    visited.assign(height + 1, vector<int>(width + 1, 0));
    int x, y;
    for (int i = 0; i < trash; ++i) {
        cin >> y >> x;
        map[y][x] = 1;
    }

    int maxValue = 0;
    for (int y = 1; y <= map.size() - 1; ++y) {
        for (int x = 1; x <= map[0].size() - 1; ++x) {
            if (0 == visited[y][x] && 1 == map[y][x]) {
                maxValue = max(maxValue, bfs(x, y));
            }
        }
    }
    cout << maxValue << endl;

    return 0;
}
