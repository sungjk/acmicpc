#include <cstdio>
using namespace std;

int length;
int array[1001], cache[1001];

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

// here번째 수를 선택했을 때 가장 큰 부분 수열의 합
int select(int here) {
	int &ret = cache[here];
	if (-1 != ret) return ret;

	ret = array[here];
	for (int next = here + 1; next < length; ++next) {
		if (array[here] < array[next]) {
			ret = max(ret, array[here] + select(next));
		}
	}
	return ret;
}

int main() {
	scanf("%d", &length);
	for (int i = 0; i < length; ++i) {
		scanf("%d", &array[i]);
	}
	// init cache
	for (int i = 0; i < length; ++i) {
		cache[i] = -1;
	}

	int maxValue = 1;
	for (int begin = 0; begin < length; ++begin) {
		maxValue = max(maxValue, select(begin));
	}
	printf("%d\n", maxValue);


	return 0;
}