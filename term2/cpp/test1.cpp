//Ŀ�ģ�ͨ������myMalloc�ı�ָ��p��ֵ
#include<stdio.h>
#include<malloc.h>
void myMalloc(char *s) //�����ں����з����ڴ�,�ٷ��� 
{
	s = (char *)malloc(100);
	printf("%x\n", *s);
}

void main()
{
	char *p = NULL;
	printf("%x\n",p); 
	myMalloc(p);    //�����pʵ�ʻ���NULL,p��ֵû�иı䣬Ϊʲô�� 
	printf("%x\n", p);
	if (p) free(p);
}