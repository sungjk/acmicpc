#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = 987654321;
int numOfCoin, total;
vector<int> coin;
vector<vector<int> > cache;

// i번째 동전을 선택했을 때, 가치의 합이 value인 동전의 수
int select(int here, int value) {
	if (here > coin.size() || value > total) return INF;
	if (here == coin.size()) {
		if (value == total) return 0;
		else return INF;
	}

	int &ret = cache[here][value];
	if (-1 != ret) return ret;

	ret = INF;
	ret = min(ret, select(here + 1, value));
	ret = min(ret, 1 + select(here, coin[here] + value));
	return ret;
}

int main() {
	cin >> numOfCoin >> total;
	coin.assign(numOfCoin + 1, -1);
	cache.assign(numOfCoin + 2, vector<int>(10001, -1));
	for (int i = 1; i < coin.size(); ++i) {
		cin >> coin[i];
	}

	int minValue = select(1, 0);
	if (INF == minValue) minValue = -1;
	cout << minValue << endl;

	return 0;
}
