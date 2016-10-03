#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

vector<int> pal;
vector<vector<int> > cache;

// start부터 end까지의 수열이 팰린드롬인지 판단
int comp(int start, int end) {
	if (start >= end) return 1;
	int &ret = cache[start][end];
	if (-1 != ret) return ret;

	if (pal[start] == pal[end]) {
		return ret = comp(start + 1, end - 1);
	}
	else {
		return ret = 0;
	}
}

int main() {
	int N; scanf("%d", &N);
	pal.assign(N + 1, 0);
	cache.assign(N + 1, vector<int>(N + 1, -1));
	for (int i = 1; i <= pal.size() - 1; ++i) {
		scanf("%d", &pal[i]);
	}
	int testCase; cin >> testCase;
	while (testCase--) {
		int from, to; scanf("%d %d", &from, &to);
		printf("%d\n", comp(from, to));
	}

	return 0;
}