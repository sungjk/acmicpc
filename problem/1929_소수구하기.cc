#include <cstdio>

bool isPrimeNumber(int num) {
    if (num == 1) return false;
    for (int i = 2; i * i <=num; ++i) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int n, m; scanf("%d %d", &m, &n);
    for (int i = m; i <= n; ++i) {
        if (isPrimeNumber(i)) {
            printf("%d\n", i);
        }
    }

    return 0;
}
