#include <cstdio>
using namespace std;

struct Point {
	int left, mid, right;
};

int max(int a, int b) {
	if (a > b) return a;
	return b;
}

int min(int a, int b) {
	if (a > b) return b;
	return a;
}

int main() {
	int n; scanf("%d", &n);
	int left, mid, right;
	scanf("%d %d %d", &left, &mid, &right);

	Point maxPoint, minPoint;
	maxPoint.left = minPoint.left = left;
	maxPoint.mid = minPoint.mid = mid;
	maxPoint.right = minPoint.right = right;
	for (int i = 0; i < n - 1; ++i) {
		scanf("%d %d %d", &left, &mid, &right);
		Point tempMinPoint;
		tempMinPoint.left = minPoint.left;
		tempMinPoint.mid = minPoint.mid;
		tempMinPoint.right = minPoint.right;
		minPoint.left = left + min(tempMinPoint.left, tempMinPoint.mid);
		minPoint.mid = mid + min(tempMinPoint.left, min(tempMinPoint.mid, tempMinPoint.right));
		minPoint.right = right + min(tempMinPoint.mid, tempMinPoint.right);

		Point tempMaxPoint;
		tempMaxPoint.left = maxPoint.left;
		tempMaxPoint.mid = maxPoint.mid;
		tempMaxPoint.right = maxPoint.right;
		maxPoint.left = left + max(tempMaxPoint.left, tempMaxPoint.mid);
		maxPoint.mid = mid + max(tempMaxPoint.left, max(tempMaxPoint.mid, tempMaxPoint.right));
		maxPoint.right = right + max(tempMaxPoint.mid, tempMaxPoint.right);
	}
	printf("%d %d\n", max(maxPoint.left, max(maxPoint.mid, maxPoint.right)), min(minPoint.left, min(minPoint.mid, minPoint.right)));
	
	return 0;
}