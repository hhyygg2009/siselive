#include <stdio.h>
#include <math.h>


double  check(double n)
{
	int i;
	for (i = n-1; i >0; i--)
		n = n * i ;
	return n;
}


int main()
{
	double x, y, z, i, j, f;
	scanf("%lf", &x);
	z = check(x);
	i = check(10);
	j = check(10 - x);
	f = i / (z*j);

	
	
	
			printf("%lf", f);
	return 0;
}	