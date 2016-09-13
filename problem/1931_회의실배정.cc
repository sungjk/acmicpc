#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;
vector<pair<ll, ll> > rooms;

/*
cnt=0; j=0;
for(i=0; i<n; i++)
    if (s[i] >= f[j])
        j = i
        cnt++;
return cnt
*/
int greedy() {
    int here = 0, maxValue = 0;
    for (int next = 0; next < rooms.size(); ++next) {
        if (here <= rooms[next].second) {
            here = rooms[next].first;
            ++maxValue;
        }
    }
    return maxValue;
}

int main() {
    int numOfRoom; scanf("%d", &numOfRoom);
    int start, end;
    for (int i = 0; i < numOfRoom; ++i) {
        scanf("%d %d", &start, &end);
        rooms.push_back(make_pair(end, start));
    }

    sort(rooms.begin(), rooms.end());
    printf("%d\n", greedy());

    return 0;
}
