#include <cstdio>
using namespace std;

int length;
int stickers[100001][2];
int cache[100001][3];
enum {
	TOP = 0, BOTTOM, NONE
};

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

// 현재 선택할 스티커가 i번째이고, 이전에 which 스티커를 선택했을 때 최대값
// which=TOP: 이전에 TOP을 선택, i번째에는 BOTTOM | NONE 선택
// which=BOTTOM: 이전에 BOTTOM을 선택, i번째에는 TOP | NONE 선택
// which=NONE: 이전에 아무것도 선택하지않음, i번째에는 TOP | BOTTOM 선택
int select(int i, int which) {
	if (i == length) return 0;

	int &ret = cache[i][which];
	if (-1 != ret) return ret;
	
	ret = 0;
	if (which == TOP) {
		ret = max(ret, stickers[i][1] + select(i + 1, BOTTOM));
	}
	else if (which == BOTTOM) {
		ret = max(ret, stickers[i][0] + select(i + 1, TOP));
	}
	else if (which == NONE) {
		ret = max(ret, stickers[i][0] + select(i + 1, TOP));
		ret = max(ret, stickers[i][1] + select(i + 1, BOTTOM));
	}
	ret = max(ret, select(i + 1, NONE));
	return ret;
}

int main() {
	int testCase; scanf("%d", &testCase);
	for (int i = 0; i < testCase; ++i) {
		scanf("%d", &length);
		// init cache
		for (int m = 0; m < 3; ++m) {
			for (int n = 0; n < length; ++n){
				cache[n][m] = -1;
			}
		}
		// init stickers
		for (int m = 0; m < 2; ++m) {
			for (int n = 0; n < length; ++n) {
				scanf("%d", &stickers[n][m]);
			}
		}
		printf("%d\n", select(0, NONE));
	}
	return 0;
}