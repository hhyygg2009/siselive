#include <stdio.h>
int k=0;

void f(int n)
{
	int x;
	x = (n / 3);//������ƿ
	k =k+x;//�һ�
	n = n - x*3+x;
	
	if (n  < 3)
	{
		return;
	}

	f(n);
}
int main()
{
	int n;
	scanf("%d", &n);
	k = n;
	f(n);
	printf("%d", k);
	return 0;
}

