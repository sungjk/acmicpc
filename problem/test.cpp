#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

const int INF = 987654321;
struct Node {
	int start, end, diff;
	Node() : start(0), end(0), diff(0) {}
	Node(int start, int end, int diff) : start(start), end(end), diff(diff) {}
};
vector<int> arr;
vector<Node> result;

vector<int> getInput(ssize_t sizeLimit)
{
	vector<int> tokenVector;
	string line;
	getline(cin, line);
	istringstream iss(line);
	string token;
	while (getline(iss, token, ' ')) {
		try {
			tokenVector.push_back(stoi(token));
		}
		catch (exception& e) {
			continue;
		}
		if (tokenVector.size() >= sizeLimit) {
			break;
		}
	}
	return tokenVector;
}


Node lis(int here) {
	Node ret(arr[here], 0, 0);
	int minValue = INF, temp;
	for (int next = here + 1; next < arr.size(); ++next) {
		temp = abs(arr[next] - arr[here]);
		if (minValue > temp) {
			minValue = temp;
			ret.end = arr[next];
			ret.diff = abs(arr[next] - arr[here]);
		}
	}
	return ret;
}

void sortByDiff() {
	Node temp;
	for (int i = 0; i < result.size(); ++i) {
		for (int j = i; j < result.size() - 1; ++j) {
			if (result[i].diff > result[j].diff) {
				temp = result[i];
				result[i] = result[j];
				result[j] = temp;
			}
		}
	}
}

int main(void)
{
	// 표준 입력으로부터 최대 10개의 자연수를 벡터 형태로 읽어들임
	vector<int> numbers = getInput(10);
	arr = numbers;
	for (int begin = 0; begin < numbers.size(); ++begin) {
		result.push_back(lis(begin));
	}
	sortByDiff();

	Node ans = result[0];
	int minValue = abs(ans.start - ans.end), temp;
	for (int i = 1; i < result.size(); ++i) {
		if (ans.diff < result[i].diff) break;
		temp = abs(result[i].start - result[i].end);
		if (minValue > temp) {
			minValue = temp;
			ans = result[i];
		}
	}
	
	cout << ans.start << " " << ans.end << endl;

	return 0;
}