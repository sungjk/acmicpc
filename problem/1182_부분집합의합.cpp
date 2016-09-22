#include <iostream>
#include <vector>
using namespace std;

enum {
	NO = 0, YES 
};
int length, target;
vector<int> arr;

// here번째에 합이 sub이고 선택 여부가 isSelect일 때, 합이 target이 되는 부분집합의 개수
int select(int here, int sub, int isSelect) {
	if (length == here) {
		if (target == sub && YES == isSelect) return 1;
		return 0;
	}

	int result = 0;
	result += select(1 + here, sub, isSelect);
	result += select(1 + here, arr[here] + sub, YES);

	return result;
}

int main() {
	cin >> length >> target;
	arr.assign(length, 0);
	for (int i = 0; i < length; ++i) {
		cin >> arr[i];
	}

	cout << select(0, 0, NO) << endl;
	
	return 0;
}
