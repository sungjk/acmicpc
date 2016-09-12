#include <cstdio>
using namespace std;

int main() {
    int n; scanf("%d", &n);
    int ret = 0, mulValue;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &mulValue);
        ret += mulValue;
    }
    printf("%d\n", ret + 1 - n);
    
    return 0;
}
