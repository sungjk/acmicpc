#include <cstdio>
using namespace std;

int cache[31];

// 3xn번째 타일을 채우는 경우의 수
// fill(n) = 3*fill(n-2) + 2*fill(n-4) + 2*fill(n-6) + ...
int fill(int here) {
	if (here < 0) return 0;
	if (here == 0) return 1;

	int &ret = cache[here];
	if (ret > 0) return ret;

	int next = here - 2;
	ret = 3 * fill(next);
	while (next >= 0) {
		next -= 2;
		ret += 2 * fill(next);
	}
	
	return ret;
}

int main() {
	int n; scanf("%d", &n);
	printf("%d\n", fill(n));
	return 0;
}