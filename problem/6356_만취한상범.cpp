#include <cstdio>
using namespace std;

enum {
	CLOSE = 0, OPEN
};

int numOfRoom;
int arr[101];

int main() {
	int testCase; scanf("%d", &testCase);
	while (testCase--) {
		scanf("%d", &numOfRoom);
		
		int numOfEscape = 0;
		for (int round = 1; round <= numOfRoom; ++round) {
			arr[round] = OPEN;
			numOfEscape++;
		}
		for (int i = 2; i <= numOfRoom; ++i) {
			int cur = 1;
			for (int round = i; round <= numOfRoom; round = i * cur) {
				if (arr[round]) {
					arr[round] = CLOSE;
					numOfEscape--;
				}
				else {
					arr[round] = OPEN;
					numOfEscape++;
				}
				cur++;
			}
		}

		printf("%d\n", numOfEscape);
	}

	return 0;
}