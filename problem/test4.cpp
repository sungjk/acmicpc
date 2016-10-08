#include <iostream>
#include <sstream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

typedef unsigned long long ull;
vector<int> origin;
vector<string> arr;

vector<int> getInput(int sizeLimit/*ssize_t sizeLimit*/)
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

void setArray() {
	int first, second;
	for (int i = 0; i < arr.size(); ++i) {
		for (int j = 0; j < arr.size() - 1; ++j) {
			if (arr[j].at(0) == arr[j + 1].at(0)) {
				first = stoi(arr[j]);
				second = stoi(arr[j + 1]);
				if (first < 10) first = first * 10 + first;
				if (second < 10) second = second * 10 + second;
				if (first > second) {
					string temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			else {
				if (arr[j].at(0) > arr[j + 1].at(0)) {
					string temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}

int main(void)
{
	// 표준 입력으로부터 최대 10개의 자연수를 벡터 형태로 읽어들임
	vector<int> numbers = getInput(10);
	origin = numbers;
	arr.assign(numbers.size(), "-");
	for (int i = 0; i < numbers.size(); ++i) {
		arr[i] = std::to_string(numbers[i]);
	}
	setArray();
	string minStr = "";
	string maxStr = "";
	for (int i = 0; i < arr.size(); ++i) {
		minStr += arr[i];
	}
	for (int i = arr.size() - 1; i >= 0; --i) {
		maxStr += arr[i];
	}
	int minNum = stoi(minStr);
	int maxNum = stoi(maxStr);
	cout << minNum + maxNum << endl;

	return 0;
}