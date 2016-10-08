#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

const char DIR[5] = { 'a', 'e', 'i', 'o', 'u' };
string target;

vector<string> getInput(ssize_t sizeLimit)
{
	vector<string> tokenVector;
	string line;
	getline(cin, line);
	istringstream iss(line);
	string token;
	while (getline(iss, token, ' ')) {
		tokenVector.push_back(token);
		if (tokenVector.size() >= sizeLimit) {
			break;
		}
	}
	return tokenVector;
}

bool isFirst(int here) {
	int i = 0;
	for (int d = 0; d < 5; ++d) {
		if (target[here] == DIR[d]) {
			++i;
			break;
		}
	}
	for (int d = 0; d < 5; ++d) {
		if (target[here + 1] == DIR[d]) {
			++i;
			break;
		}
	}
	if (2 == i) {
		return true;
	}
	return false;
}

bool isSecond(int here) {
	for (int d = 0; d < 5; ++d) {
		if (target[here] == DIR[d]) return false;
	}
	for (int d = 0; d < 5; ++d) {
		if (target[here + 1] == DIR[d]) return false;
	}
	for (int d = 0; d < 5; ++d) {
		if (target[here + 2] == DIR[d]) return false;
	}
	return true;
}

// here번째에 모음(First)이 연속으로 2개 나온 단어의 수
int selectFirst() {
	int count = 0;
	for (int here = 0; here < target.length() - 1; ++here) {
		if (isFirst(here)) return 1;
	}
	return 0;
}

int selectSecond() {
	int count = 0;
	for (int here = 0; here < target.length() - 2; ++here) {
		if (isSecond(here)) return 1;
	}
	return 0;
}


int main(void)
{
	// 표준 입력으로부터 최대 10개의 문자열 토큰을 벡터 형태로 반환받음
	vector<string> words = getInput(10);
	int first = 0, second = 0;

	for (int begin = 0; begin < words.size(); ++begin) {
		target = words[begin];
		first += selectFirst();
		second += selectSecond();
	}
	cout << first << endl << second << endl;
	
	return 0;
}