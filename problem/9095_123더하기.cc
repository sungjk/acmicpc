#include <cstdio>
using namespace std;

// i를 1,2,3으로 만드는 방법의 수
int sum(int i) {
    if (i == 0) return 1;
    if (i < 0) return 0;
    return sum(i - 1) + sum(i - 2) + sum(i - 3);
}

int main() {
    int t, n; scanf("%d", &t);
    for (int i = 0; i < t; ++i) {
        scanf("%d", &n);
        printf("%d\n", sum(n));
    }

    return 0;
}
