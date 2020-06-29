#include <iostream>
using namespace std;


int IsPrimeNumber(int n)
{
	for (int i = 2; i < n; i++)
	{
		if (n%i == 0)
		{
			return 0;
		}
	}
	return 1;
}

int main()
{
	for (int i = 1; i <= 50; i++)
	{
		if(IsPrimeNumber(i))
		cout <<i<<endl;
	}

	return 0;
}