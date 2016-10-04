#include <iostream>
#include <vector>
using namespace std;

typedef long long ll;
vector<ll> cache;

ll fib(int n) {
    if (n <= 2) return 1;
    if (n == 3) return 2;
    ll& ret = cache[n];
    if (-1 != ret) return ret;
    return ret = fib(n - 1) + fib(n - 2);
}

int main() {
    int n; cin >> n;
    cache.assign(n + 2, -1);
    ll len = fib(n + 1) * 2;
    len += fib(n) * 2;
    cout << len << endl;
    return 0;
}
