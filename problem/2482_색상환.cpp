#include <iostream>
#include <vector>
using namespace std;

const int MOD = 1000000003;
int n, k;
vector<vector<vector<int> > > cache;

// here번 색을 선택할 때, 이전까지 count번 선택했고 1번 색의 선택 여부가 first일 때 경우의 수
int select(int here, int count, int first) {
	if (count == k) return 1;
	if (here > n) return 0;
	if (here == n && first) return 0;

	int &ret = cache[here][count][first];
	if (-1 != ret) return ret;
	ret = 0;

	if (here == n) {
		ret = select(here + 2, count + 1, first) % MOD;
		ret += select(here + 1, count, first) % MOD;
		return ret;
	}

	// here번 색을 선택 할 경우
	if (1 == here) ret += select(here + 2, count + 1, 1) % MOD;
	else ret += select(here + 2, count + 1, first) % MOD;

	// here번 색을 선택하지 않을 경우
	if (1 == here) ret += select(here + 1, count, 0) % MOD;
	else ret += select(here + 1, count, first) % MOD;

	return ret % MOD;
}

int main() {
	cin >> n >> k;
	if (n / 2 < k) {
		cout << 0 << endl;
		return 0;
	}

	cache.assign(n + 1, vector<vector<int> >(k + 1, vector<int>(2, -1)));
	cout << select(1, 0, 0) << endl;

	return 0;
}