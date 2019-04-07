#include <iostream>
#include <cstdio>
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
struct Pos {
    int x, y, cost;
    Pos() : x(0), y(0), cost(0) {}
    Pos(int x, int y, int cost) : x(x), y(y), cost(cost) {}
};

int width, height;
vector<vector<char> > map;
// vector<vector<bool> > visited;
vector<vector<char> > water;
vector<vector<int> > waterCost;
queue<Pos> q;

void findStartEnd(int& startX, int& startY, int& endX, int& endY) {
    for (int h = 1; h <= height; ++h) {
        for (int w = 1; w <= width; ++w) {
            if ('D' == map[h][w]) {
                startX = w; startY = h;
            }
            if ('S' == map[h][w]) {
                endX = w; endY = h;
            }
        }
    }
}

void makeWaterMap() {
    int height = map.size() - 1;
    int width = map[0].size() - 1;
	int iter = width > height ? width : height;
    for (int i = 0; i < iter; ++i) {
        for (int y = 1; y < map.size() - 1; ++y) {
            for (int x = 1; x < map[0].size() - 1; ++x) {
                if ('*' == water[y][x] && i == waterCost[y][x]) {
                    for (int d = 0; d < 4; ++d) {
                        int nextX = x + DIR[d][0];
                        int nextY = y + DIR[d][1];
                        if ('.' == water[nextY][nextX] || 'S' == water[nextY][nextX]) {
                            waterCost[nextY][nextX] = waterCost[y][x] + 1;
                            water[nextY][nextX] = '*';
                        }
                    }
                }
            }
        }
    }
}

bool canGo(Pos next) {
    if (('.' == map[next.y][next.x] || 'D' == map[next.y][next.x]) &&
        (next.cost < waterCost[next.y][next.x] || 0 == waterCost[next.y][next.x]) &&
        !visited[next.y][next.x]) {
        return true;
    }
    return false;
}

int bfs(Pos start, Pos end) {
    Pos here;
    visited[start.y][start.x] = true;
    q.push(start);
    printf("start: %d %d, end: %d %d\n", start.x, start.y, end.x, end.y);

    while (!q.empty()) {
        here = q.front(); q.pop();
        printf("here %d %d %d\n", here.x, here.y, here.cost);

        if (here.x == end.x && here.y == end.y) return here.cost;

        for (int i = 0; i < 4; ++i) {
            Pos next(here.x + DIR[i][0], here.y + DIR[i][1], here.cost + 1);
            if (canGo(next)) {
                q.push(next);
                visited[next.y][next.x] = true;
                printf("next %d %d %d\n", next.x, next.y, next.cost);
            }
        }
    }
    return 0;
}

void print() {
    for (int h = 1; h <= height; ++h) {
        for (int w = 1; w <= width; ++w) {
            cout << waterCost[h][w] << " ";
        }
        cout << endl;
    }
}

int main() {
    cin >> width >> height;
    map.assign(height + 2, vector<char>(width + 2, 'X'));
    // visited.assign(height + 2, vector<bool>(width + 2, false));
    waterCost.assign(height + 2, vector<int>(width + 2, 0));
    for (int h = 1; h <= height; ++h) {
        for (int w = 1; w <= width; ++w) {
            cin >> map[h][w];
        }
    }

    water = map;
	makeWaterMap();
    int startX, startY, endX, endY;
    findStartEnd(startX, startY, endX, endY);
    print();

    // int cost = bfs(Pos(startX, startY, 0), Pos(endX, endY, 0));
    int cost = bfs(startX, startY, endX, endY);
    if (0 == cost) {
        cout << "KAKTUS" << endl;
        return 0;

    }
    cout << cost << endl;

    return 0;
}
