#include <iostream>
#include <vector>
using namespace std;

int width, height, startx, starty, endx, endy;
vector<vector<int> > arr;

int tour() {
	int sum = 0;
	for (int y = starty; y <= endy; ++y) {
		for (int x = startx; x <= endx; ++x) {
			sum += arr[y][x];
		}
	}
	return sum;
}

int main() {
	cin >> height >> width;
	arr.assign(height + 1, vector<int>(width + 1, 0));
	for (int h = 1; h < arr.size(); ++h) {
		for (int w = 1; w < arr[0].size(); ++w) {
			cin >> arr[h][w];
		}
	}

	int testCase; cin >> testCase;
	while (testCase--) {
		cin >> starty >> startx >> endy >> endx;
		cout << tour() << endl;
	}

	return 0;
}


//#include <iostream>
//#include <vector>
//using namespace std;
//
//const int DIR[2][2] = {
//	0, 1,
//	1, 0
//};
//int width, height, startx, starty, endx, endy;
//vector<vector<int> > arr;
//vector<vector<vector<vector<vector<vector<int> > > > > > cache;
//vector<vector<bool> > visited;
//
//bool canGo(int x, int y) {
//	if (x >= arr[0].size() || y >= arr.size()) return false;
//	return true;
//}
//
//// (x, y) 위치에 있을때 저장되어 있는 수들의 합
//int tour(int x, int y) {
//	int &ret = cache[y][x][starty][startx][endy][endx];
//	if (-1 != ret) return ret;
//
//	ret = arr[y][x];
//	visited[y][x] = true;
//	if (x == endx && y == endy) return ret;
//	for (int d = 0; d < 2; ++d) {
//		int nextx = x + DIR[d][0];
//		int nexty = y + DIR[d][1];
//		if (canGo(nextx, nexty) && !visited[nexty][nextx]) {
//			visited[nexty][nextx] = true;
//			ret += tour(nextx, nexty);
//		}
//	}
//	return ret;
//}
//
//int main() {
//	cin >> height >> width;
//	arr.assign(height + 1, vector<int>(width + 1, 0));
//	cache.assign(height + 1, vector<vector<vector<vector<vector<int> > > > >(width + 1, vector<vector<vector<vector<int> > >>(height + 1, vector<vector<vector<int> > >(width + 1, vector<vector<int> >(height + 1, vector<int>(width + 1, -1))))));
//	for (int h = 1; h < arr.size(); ++h) {
//		for (int w = 1; w < arr[0].size(); ++w) {
//			cin >> arr[h][w];
//		}
//	}
//
//	int testCase; cin >> testCase;
//	while (testCase--) {
//		cin >> starty >> startx >> endy >> endx;
//		visited.assign(height + 1, vector<bool>(width + 1, false));
//		cout << tour(startx, starty) << endl;
//	} 
//
//	return 0;
//}