#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = 987654321;
vector<int> door, visit;
vector<vector<vector<int> > > cache;

// left와 right번째 문이 열려있고, here번 문을 열어야할 때 이동한 최소 횟수
int move(int here, int left, int right) {
	if (here == visit.size()) return 0;

	int& ret = cache[here][left][right];
	if (-1 != ret) return ret;

	int target = visit[here];
	ret = INF;
	ret = min(ret, abs(left - target) + move(here + 1, target, right));
	ret = min(ret, abs(right - target) + move(here + 1, left, target));
	return ret;
}

int main() {
	int length, left, right; cin >> length >> left >> right;
	door.assign(length + 1, 0);
	int countMove, here; cin >> countMove;
	for (int i = 0; i < countMove; ++i) {
		cin >> here;
		visit.push_back(here);
	}
	cache.assign(countMove + 1, vector<vector<int> >(length + 1, vector<int>(length + 1, -1)));
	cout << move(0, left, right) << endl;
	return 0;
}