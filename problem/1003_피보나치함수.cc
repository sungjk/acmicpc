#include <cstdio>
using namespace std;

struct Count {
    int zero, one;
    Count (int zero, int one) : zero(zero), one(one) {}
};

void fib(Count &count, int n) {
    if (n == 0) {
        count.zero++;
        return;
    }
    else if (n == 1) {
        count.one++;
        return;
    }
    else {
        fib(count, n - 1);
        fib(count, n - 2);
        return;
    }
}

int main() {
    int testCase;
    scanf("%d", &testCase);
    for (int i = 0; i < testCase; ++i) {
        int N;
        scanf("%d", &N);
        Count count(0, 0);
        fib(count, N);
        printf("%d %d\n", count.zero, count.one);
    }

    return 0;
}
