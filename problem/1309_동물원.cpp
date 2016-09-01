#include <cstdio>
using namespace std;

const int MOD = 9901;
int zoo[100001];

int main() {
	int n; scanf("%d", &n);
	zoo[0] = 1; zoo[1] = 3;
	for (int i = 2; i <= n; ++i) {
		zoo[i] = 2 * zoo[i - 1] + zoo[i - 2];
		zoo[i] %= MOD;
	}
	printf("%d\n", zoo[n] % MOD);

	return 0;
}