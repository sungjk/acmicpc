#include <cstdio>
using namespace std;

int numOfBox;
int box[1001], cache[1001];

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

// here번째 상자를 선택했을 때 최대 상자의 개수
int select(int here) {
	int &ret = cache[here];
	if (ret > 0) return ret;

	ret = 1;
	for (int next = here + 1; next < numOfBox; ++next) {
		if (box[here] < box[next]) {
			ret = max(ret, 1 + select(next));
		}
	}
	return ret;
}

int main() {
	scanf("%d", &numOfBox);
	for (int i = 0; i < numOfBox; ++i) {
		scanf("%d", &box[i]);
	}
	int maxValue = 0;
	for (int begin = 0; begin < numOfBox; ++begin) {
		maxValue = max(maxValue, select(begin));
	}
	printf("%d\n", maxValue);

	return 0;
}