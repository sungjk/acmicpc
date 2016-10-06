#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

enum {
    EMPTY = 0, FILL
};
const int DIR[4][2] = {
    1, 0,
    0, 1,
    -1, 0,
    0, -1
};
struct Node {
    int x, y;
    Node() : x(0), y(0) {}
    Node(int x, int y) : x(x), y(y) {}
};
vector<vector<int> > board;
vector<vector<int> > visited;

bool canGo(Node next) {
    if (next.x < 0 || next.x > board[0].size() - 1) return false;
    if (next.y < 0 || next.y > board.size() - 1) return false;
    if (1 == visited[next.y][next.x]) return false;
    if (FILL == board[next.y][next.x]) return false;
    return true;
}

int bfs(int x, int y) {
    queue<Node> que;
    que.push(Node(x, y));
    visited[y][x] = 1;

    Node here;
    int value = 0;
    while (!que.empty()) {
        here = que.front(); que.pop();
        ++value;
        for (int d = 0; d < 4; ++d) {
            Node next(here.x + DIR[d][0], here.y + DIR[d][1]);
            if (canGo(next)) {
                que.push(next);
                visited[next.y][next.x] = 1;
            }
        }
    }
    return value;
}

int main() {
    int width, height, point; cin >> height >> width >> point;
    board.assign(height, vector<int>(width, 0));
    visited.assign(height + 1, vector<int>(width + 1, 0));

    // init board
    int fromx, fromy, tox, toy;
    while (point--) {
        cin >> fromx >> fromy >> tox >> toy;
        for (int y = fromy; y < toy; ++y) {
            for (int x = fromx; x < tox; ++x) {
                board[y][x] = FILL;
            }
        }
    }

    // tour
    int value = 0;
    vector<int> ret;
    for (int y = 0; y < board.size(); ++y) {
        for (int x = 0; x < board[0].size(); ++x) {
            if (0 == visited[y][x] && EMPTY == board[y][x]) {
                ret.push_back(bfs(x, y));
            }
        }
    }
    sort(ret.begin(), ret.end());
    cout << ret.size() << endl;
    for (int i = 0; i < ret.size(); ++i) {
        cout << ret[i] << " ";
    }
    cout << endl;

    return 0;
}
