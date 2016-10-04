#include <iostream>
#include <vector>
using namespace std;

const int DIR[4][2] = {
    1, 0,
    0, 1,
    -1, 0,
    0, -1
};
enum {
    A, B // 일반인, 적록색인
};
vector<vector<char> > origin, special;
vector<vector<int> > visited;

bool canGo(int x, int y, char color, int type) {
    if (x < 1 || x > origin.size() - 1) return false;
    if (y < 1 || y > origin.size() - 1) return false;
    if (1 == visited[y][x]) return false;
    if (A == type && color != origin[y][x]) return false;
    if (B == type && color != special[y][x]) return false;
    return true;
}

void dfs(int x, int y, char color, int type) {
    visited[y][x] = 1;
    for (int d = 0; d < 4; ++d) {
        int nextx = x + DIR[d][0];
        int nexty = y + DIR[d][1];
        if (canGo(nextx, nexty, color, type)) {
            dfs(nextx, nexty, color, type);
        }
    }
}

int main() {
    int length; cin >> length;
    origin.assign(length + 1, vector<char>(length + 1, '0'));
    special.assign(length + 1, vector<char>(length + 1, '0'));
    for (int y = 1; y <= length; ++y) {
        for (int x = 1; x <= length; ++x) {
            cin >> origin[y][x];
            special[y][x] = origin[y][x];
            if ('G' == special[y][x]) special[y][x] = 'R';
        }
    }

    int groupA = 0, groupB = 0;
    visited.assign(length + 1, vector<int>(length + 1, 0));
    for (int y = 1; y <= length; ++y) {
        for (int x = 1; x <= length; ++x) {
            if (0 == visited[y][x]) {
                dfs(x, y, origin[y][x], A);
                ++groupA;
            }
        }
    }
    visited.assign(length + 1, vector<int>(length + 1, 0));
    for (int y = 1; y <= length; ++y) {
        for (int x = 1; x <= length; ++x) {
            if (0 == visited[y][x]) {
                dfs(x, y, special[y][x], B);
                ++groupB;
            }
        }
    }
    cout << groupA << " " << groupB << endl;

    return 0;
}
