#include <cstdio>
using namespace std;

typedef unsigned long long ull;

ull cache[70];

ull koong(int num) {
	if (num < 2) return 1;
	else if (num == 2) return 2;
	else if (num == 3) return 4;
	else {
		ull &ret = cache[num];
		if (ret > 0) return ret;

		return ret = koong(num - 1) + koong(num - 2) + koong(num - 3) + koong(num - 4);
	}
}

int main() {
	int testCase, n; scanf("%d", &testCase);
	for (int i = 0; i < testCase; ++i) {
		scanf("%d", &n);
		for (int j = 0; j <= n; ++j) {
			cache[j] = 0;
		}

		printf("%lld\n", koong(n));
	}
	
	return 0;
}