#include <stdio.h>
#include <math.h>





int max(int a, int b)
{
	return a > b ? a : b;
}
int min(int a, int b)
{
	return a < b ? a : b;
}

int isPrime(int n) {
	int i;
	for (i = 2; i < n; ++i) {
		if (n % i == 0) return 0;
	}
	return 1;
}


int main()
{
	int m, k;
	scanf("%d %d", &m, &k);
	
}
