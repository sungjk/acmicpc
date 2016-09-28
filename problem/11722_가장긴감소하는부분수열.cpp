#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr;
vector<int> cache;

// here번째 수를 선택했을 때 가장 긴 감소하는 부분수열의 길이
int select(int here) {
	int &ret = cache[here];
	if (-1 != ret) return ret;

	ret = 1;
	for (int next = here + 1; next < arr.size(); ++next) {
		if (arr[here] > arr[next]) {
			ret = max(ret, 1 + select(next));
		}
	}
	return ret;
}

int main() {
	int length; cin >> length;
	arr = vector<int>(length, 0);
	cache = vector<int>(length + 1, -1);
	for (int i = 0; i < arr.size(); ++i) {
		cin >> arr[i];
	}

	int maxValue = 0;
	for (int begin = 0; begin < arr.size(); ++begin) {
		maxValue = max(maxValue, select(begin));
	}
	cout << maxValue << endl;

	return 0;
}