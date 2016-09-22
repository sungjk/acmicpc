#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int width, height;

// [x, y] = 1 + min([x - 1][y - 1], [x][y - 1], [x - 1][y])
int tour() {
	int maxValue = 0, num = 0;
	vector<vector<int> > rect = vector<vector<int> >(height + 2, vector<int>(width + 2, 0));
	for (int y = 1; y <= height; ++y) {
		for (int x = 1; x <= width; ++x) {
			scanf("%1d", &num);
			if (1 == num) {
				rect[y][x] = 1 + min(rect[y - 1][x - 1], min(rect[y][x - 1], rect[y - 1][x]));
				maxValue = max(maxValue, rect[y][x]);
			}
		}
	}
	return maxValue * maxValue;
}

int main() {
	cin >> height >> width;
	cout << tour() << endl;

	return 0;
}