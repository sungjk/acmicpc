#include <cstdio>
using namespace std;

int num[100001];

int main() {
	int n; scanf("%d", &n);
	for (int i = 1; i <= n; ++i) {
		num[i] = i;
		for (int j = 1; j * j <= i; ++j) {
			if (num[i] > num[i - j * j] + 1) {
				num[i] = num[i - j * j] + 1;
			}
		}
	}
	printf("%d\n", num[n]);

	return 0;
}