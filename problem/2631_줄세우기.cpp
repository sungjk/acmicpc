#include <cstdio>
using namespace std;

int numOfChildren;
int childrens[201], cache[201];

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

// here번째에서 증가하는 가장 긴 부분 수열의 길이
int select(int here) {
	int &ret = cache[here];
	if (-1 != ret) return ret;

	ret = 1;
	for (int next = here + 1; next < numOfChildren; ++next) {
		if (childrens[here] < childrens[next]) {
			ret = max(ret, 1 + select(next));
		}
	}
	return ret;
}

int main() {
	scanf("%d", &numOfChildren);
	for (int i = 0; i < numOfChildren; ++i) {
		scanf("%d", &childrens[i]);
	}
	// init  cache
	for (int i = 0; i < numOfChildren; ++i) {
		cache[i] = -1;
	}

	// 옮겨지는 아이의 최소 수
	// = 전체 아이의 수 - 옮겨지지 않는 아이의 최대 수
	// = 전체 아이의 수 - 번호가 증가하면서 가장 긴 부분 수열
	int maxValue = 0;
	for (int begin = 0; begin < numOfChildren; ++begin) {
		maxValue = max(maxValue, select(begin));
	}
	printf("%d\n", numOfChildren - maxValue);

	return 0;
}