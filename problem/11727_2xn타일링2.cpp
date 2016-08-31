#include <cstdio>
using namespace std;

const int MOD = 10007;
int cache[1001];

// 2xi 크기의 타일을 채우는 방법의 수
// fill(i - 1) + l
// fill(i - 2) + ll
// fill(i - 2) + ㅁ
int fill(int i){
	if (i == 1) return 1;
	if (i == 2) return 3;

	int &ret = cache[i];
	if (ret > 0) return ret;

	ret = fill(i - 1) + 2 * fill(i - 2);
	ret %= MOD;
	return ret;
}

int main() {
	int n; scanf("%d", &n);
	printf("%d\n", fill(n) % MOD);
	return 0;
}