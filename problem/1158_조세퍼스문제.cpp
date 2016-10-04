#include <iostream>
#include <list>
using namespace std;

void josephus(int n, int m) {
	list<int> survivors;
	for (int i = 1; i <= n; ++i) {
		survivors.push_back(i);
	}

	list<int>::iterator kill = survivors.begin();
	cout << "<";
	while (survivors.size() > 0) {
		for (int i = 0; i < m - 1; ++i) {
			++kill;
			if (kill == survivors.end()) {
				kill = survivors.begin();
			}
		}

		if (survivors.size() != 1) cout << *kill << ", ";
		else cout << *kill;

		kill = survivors.erase(kill);
		if (kill == survivors.end()) {
			kill = survivors.begin();
		}
	}
	cout << ">" << endl;
}

int main() {
	int n, m; cin >> n >> m;
	josephus(n, m);
	return 0;
}