#include <iostream>
#include <string>  ///////////////////////////////////////////////////
#include <vector>	///////////////////////////////////////////////////
#include <exception>

using namespace std;

vector<int> arr;

int getInput()
{
	string line;
	int number = 0;
	getline(cin, line);
	try {
		number = stoi(line);
	}
	catch (exception& e) {
		number = -1;
	}
	return number;
}

void setArray(int num) {
	string str = std::to_string(num);
	arr.assign(str.length(), 0);
	for (int i = 0; i < str.length(); ++i) {
		arr[i] = str[i] - '0';
	}
}

bool isPalindrom(int left, int right) {
	if (left >= right) return true;
	if (arr[left] == arr[right]) {
		return isPalindrom(left + 1, right - 1);
	}
	else {
		return false;
	}
}

int getTen(int n) {
	int ten = 1;
	for (int i = 0; i < n; ++i) ten *= 10;
	return ten;
}

int reverseSum(int sum, int count) {
	if (count > 3) return -1;
	if (isPalindrom(0, arr.size() - 1)) return sum;

	int reverseNum = 0, length = arr.size();
	for (int i = 0; i < length; ++i) {
		reverseNum += (arr[i] * getTen(length - 1 - i)) + (arr[length - 1 - i] * getTen(length - 1 - i));
	}
	setArray(reverseNum);
	reverseSum(reverseNum, count + 1);
}

int main(void)
{
	// 표준 입력으로부터 자연수를 읽어들임
	int number = getInput();
	setArray(number);
	cout << reverseSum(number, 0) << endl;
	return 0;
}
