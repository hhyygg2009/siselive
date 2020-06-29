#include <stdio.h>

int out(int x)
{
	int a, b;
	b = x % 10;
	a = x / 10;
	x =  a + 10 *b;
	return x;
}

int main()
{
	int i,j,k,l=0;
	scanf("%d", &k);
	for ( i = 1; i < 99; i++)
	{
		j = i + k;//ÎÒ
		if (j > 99) break;
		if (out(j) == i)
			l++;
	}
	printf("%d", l);
	return 0;
}

