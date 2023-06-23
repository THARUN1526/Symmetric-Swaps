#include<stdio.h>
#include<stdlib.h>

int compare(const void *a, const void *b){
    int *x = (int *)a;
    int *y = (int *)b;
    return *x - *y;
}

int check(int a, int b){
    return a*b;
}
int main(){
    int t;
    scanf("%d", &t);
    while(t-- > 0){
        int n;
        scanf("%d", &n);
        int a[n], b[n];
        for(int i=0;i<n;i++)
            scanf("%d", &a[i]);
        for(int i=0;i<n;i++)
            scanf("%d", &b[i]);
        for(int i=0;i<n;i++) {
            if(a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
        }
        int combined[n][2];
        for(int i=0;i<n;i++) {
            combined[i][0] = a[i];
            combined[i][1] = b[i];
        }
        qsort(combined, n, sizeof(combined[0]), compare);
        int maximum = combined[n-1][0];
        int minimum = combined[0][0];
        int ans = maximum-minimum;
        int firstMin[n], lastMin[n], firstMax[n], lastMax[n];
        firstMin[0] = combined[0][0];
        lastMin[n-1] = combined[n-1][1];
        firstMax[0] = combined[0][0];
        lastMax[n-1] = combined[n-1][1];
        for(int i=1;i<n;i++) {
            firstMin[i] = firstMin[i-1] < combined[i][0] ? firstMin[i-1] : combined[i][0];
            firstMax[i] = firstMax[i-1] > combined[i][0] ? firstMax[i-1] : combined[i][0];
        }
        for(int i=n-2;i>=0;i--) {
            lastMin[i] = lastMin[i+1] < combined[i][1] ? lastMin[i+1] : combined[i][1];
            lastMax[i] = lastMax[i+1] > combined[i][1] ? lastMax[i+1] : combined[i][1];
        }
        for(int i=n-1;i>=0;i--) {
            int temp = combined[i][0];
            combined[i][0] = combined[i][1];
            combined[i][1] = temp;
            if(i == 0) {
                maximum = lastMax[0];
                minimum = lastMin[0];
            }
            else {
                maximum = firstMax[i-1] > lastMax[i] ? firstMax[i-1] : lastMax[i];
                minimum = firstMin[i-1] < lastMin[i] ? firstMin[i-1] : lastMin[i];
            }
            ans = ans < maximum-minimum ? ans : maximum-minimum;
        }
        int res = check(12,34);
        printf("%d\n", ans);
    }
    return 0;
}