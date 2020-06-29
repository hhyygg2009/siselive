//目的：通过函数myMalloc改变指针p的值
#include<stdio.h>
#include<malloc.h>
void myMalloc(char *s) //我想在函数中分配内存,再返回 
{
	s = (char *)malloc(100);
	printf("%x\n", *s);
}

void main()
{
	char *p = NULL;
	printf("%x\n",p); 
	myMalloc(p);    //这里的p实际还是NULL,p的值没有改变，为什么？ 
	printf("%x\n", p);
	if (p) free(p);
}