#include <iostream>
#include "linelist.h"

using namespace std;




bool init(list * ls)
{

		ls->length = 0;
		
		return true;

}

bool print(list * ls)
{
	if (ls->length == 0) {
		printf("��Ϊ��");
		return false;
	}

	for (int i = 0; i < ls->length; i++)
	{
		printf("a[%d]=%c ", i+1, ls->array[i]);
		
	}
	return true;
}

bool Insertlist(list * ls, int pos, ElemType c)
{
	if (ls->length >= MAX_SIZE)
	{
		printf("������");
		return false;

	}
	if (pos-1 > ls->length || pos <= 0)
	{
		printf("λ�ò��Ϸ�");
		return false;

	}
	for (int i = ls->length-1; i >= pos - 1; i--)
	{
		 ls->array[i + 1]=ls->array[i];
	}
	ls->array[pos - 1] = c;
	ls->length++;
	return true;
}
bool getlength(list* ls);//���������



int main()
{
	list a1;
	if(init(&a1))
		printf("\n��ʼ���ɹ�\n");
	Insertlist(&a1, 1, 'a');
	Insertlist(&a1, 2, 'b');
	Insertlist(&a1, 3, 'c');
	Insertlist(&a1, 4, 'd');
	Insertlist(&a1, 5, 'e');
	if (print(&a1))
	{
		printf("\n����ɹ�\n");
	}
	

	
	

}

