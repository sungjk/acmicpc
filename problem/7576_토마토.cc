/*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
*/
#include <cstdio>
#include <queue>
using namespace std;

const int DIR[4][2] = {
    0, -1,
    1, 0,
    0, 1,
    -1, 0
};
struct Tomato {
    int x, y, days;
    Tomato() : x(0), y(0), days(0) {}
    Tomato(int x, int y, int days) : x(x), y(y), days(days) {}
};
int lengthX, lengthY, rest;
int tomatos[1001][1001];
queue<Tomato> q;

bool canGo(int nextX, int nextY) {
    if (nextX < 1 || nextX > lengthX) return false;
    if (nextY < 1 || nextY > lengthY) return false;
    if (0 == tomatos[nextY][nextX]) return true;
    return false;
}

int go() {
    Tomato here;
    while (!q.empty()) {
        here = q.front(); q.pop();
        --rest; // 현재 토마토 익었음
        for (int i = 0; i < 4; ++i) {
            int nextX = here.x + DIR[i][0];
            int nextY = here.y + DIR[i][1];
            if (canGo(nextX, nextY)) {
                Tomato next(nextX, nextY, here.days + 1);
                tomatos[nextY][nextX] = 1; // visited
                q.push(next);
            }
        }
    }
    return here.days;
}

int main() {
    scanf("%d %d", &lengthX, &lengthY);
    rest = 0;
    for (int y = 1; y <= lengthY; ++y) {
        for (int x = 1; x <= lengthX; ++x) {
            scanf("%d", &tomatos[y][x]);
            if (-1 == tomatos[y][x]) continue;
            if (1 == tomatos[y][x]) {
                q.push(Tomato(x, y, 0));
            }
            ++rest;
        }
    }

    int minValue = go();
    if (0 != rest) {
        printf("-1\n");
        return 0;
    }
    printf("%d\n", minValue);

    return 0;
}
