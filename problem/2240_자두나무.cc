#include <cstdio>
using namespace std;

enum {
    LEFT = 1, RIGHT
};
int numOfFruits, numOfMove;
int fruits[1001], cache[1001][31][3];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

int negative(int pos) {
    if (pos == LEFT) return RIGHT;
    return LEFT;
}

// here번 자두가 떨어질 때 pos 위치에서 move번 움직였을 때 받을 수 있는 자두의 최대 개수
// 먹을 수 있는 경우
    // 먹고 나서 그대로 있을 경우
    // 먹고 나서 움직일 경우
// 못먹는 경우
    // 못먹고 나서 그대로 있을 경우
    // 못먹고 나서 움직일 경우
int eat(int here, int move, int pos) {
    if (here > numOfFruits || move > numOfMove) return 0;

    int &ret = cache[here][move][pos];
    if (-1 != ret) return ret;

    ret = 0;
    if (fruits[here] == pos) {
        ret = max(ret, 1 + eat(here + 1, move, pos));
        if (move < numOfMove) {
            ret = max(ret, 1 + eat(here + 1, move + 1, negative(pos)));
        }
    }
    else { // 못먹는 경우
        ret = max(ret, eat(here + 1, move, pos));
        if (move < numOfMove) {
            ret = max(ret, eat(here + 1, move + 1, negative(pos)));
        }
    }
    return ret;
}

int main() {
    scanf("%d %d", &numOfFruits, &numOfMove);
    for (int i = 1; i <= numOfFruits; ++i) {
        for (int j = 0; j <= numOfMove; ++j) {
            for (int k = 0; k <= 2; ++k) {
                cache[i][j][k] = -1;
            }
        }
    }
    for (int i = 1; i <= numOfFruits; ++i) {
        scanf("%d", &fruits[i]);
    }
    int notMove = eat(1, 0, LEFT);
    int moveRight = eat(1, 1, RIGHT);
    printf("%d\n", max(notMove, moveRight));

    return 0;
}
