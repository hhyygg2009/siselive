#include <iostream>
using namespace std;
int max(int a, int b)
{
	if (a > b) return a;
	return b;
}

float max(float a, float b) {
	if (a > b) return a;
	return b;
}

char * max(char *a, char*b) {
	if (strcmp(a, b))return a;
	return b;
}

int main()
{

 }