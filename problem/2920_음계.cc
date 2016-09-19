#include <cstdio>
using namespace std;

int main() {
    int i = 7;
    int here, next; scanf("%d", &here);

    bool isAscending = true;
    if (here == 1) isAscending = true;
    else if (here == 8) isAscending = false;
    else {
        printf("mixed\n");
        return 0;
    }

    while (i--) {
        scanf("%d", &next);
        if (isAscending && next - here == 1) {
            here = next;
        }
        else if (!isAscending && here - next == 1) {
            here = next;
        }
        else {
            printf("mixed\n");
            return 0;
        }
    }
    if (isAscending) printf("ascending\n");
    else printf("descending\n");

    return 0;
}
