#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> height;

vector<int> find(int first, int second) {
    vector<int> ret;

    int sum = 0;
    for (int i = 0; i < height.size(); ++i) {
        if (i != first && i != second) {
            sum += height[i];
            ret.push_back(height[i]);
        }
    }
    if (100 == sum) return ret;
    return vector<int>();
}

int main() {
    height.assign(9, 0);
    for (int i = 0; i < height.size(); ++i) {
        cin >> height[i];
    }

    vector<int> ret;
    // 제외할 first, second 난쟁이 고르기
    for (int first = 0; first < height.size(); ++first) {
        for (int second = 0; second < height.size(); ++second) {
            if (first == second) continue;
            ret = find(first, second);
            if (0 != ret.size()) {
                sort(ret.begin(), ret.end());
                for (int i = 0; i < ret.size(); ++i) {
                    cout << ret[i] << endl;
                }
                return 0;
            }
        }
    }

    return 0;
}
