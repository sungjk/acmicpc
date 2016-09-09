#include <cstdio>
using namespace std;

int totalSum;
const int MOD = 1000000000;
int table[201][201], cache[201][201];

// k개의 정수를 선택했을 때 합이 sum인 경우의 수
int select(int k, int sum) {
	if (k < 0 || sum < 0) return 0;
	if (k == 0 && sum == 0) return 1;

	int &ret = cache[k][sum];
	if (-1 != ret) return ret;

	ret = 0;
	for (int last = 0; last <= sum; ++last) {
		ret += select(k - 1, sum - last);
		ret %= MOD;
	}
	return ret;
}

int main() {
	int k; scanf("%d %d", &totalSum, &k);
	// init cache
	for (int i = 0; i <= k; ++i) {
		for (int j = 0; j <= totalSum; ++j) {
			cache[i][j] = -1;
		}
	}
	printf("%d\n", select(k, totalSum));

	return 0;
}