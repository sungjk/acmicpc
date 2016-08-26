#include <cstdio>
using namespace std;

int numOfGraphs;
int graphs[10001];
int cache[10001][3];

int max(int a, int b) {
    if (a > b) return a;
    return b;
}

// i번째 포도주를 연속으로 몇 번 selected 했을 때 최대로 마실 수 있는 포도주의 양
// selcted <= 1: i+1번째에 안 마시거나, 한 번 더 마실 수 있다.
// selected = 2: i+1번째에 마실 수 없다.
int drink(int i, int selected) {
    if (i >= numOfGraphs) return 0;

    int &ret = cache[i][selected];
    if (ret > 0) return ret;

    ret = 0;
    if (selected <= 1) {
        ret = max(ret, graphs[i] + drink(i + 1, selected + 1));
    }
    ret = max(ret, drink(i + 1, 0));

    return ret;
}

int main () {
    scanf("%d", &numOfGraphs);
    for (int i = 0; i < numOfGraphs; ++i) {
        scanf("%d", &graphs[i]);
    }
    printf("%d\n", drink(0, 0));

    return 0;
}
