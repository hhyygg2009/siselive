#pragma once

#define MAX_SIZE 10

typedef char ElemType;

struct list
{
	ElemType  array[MAX_SIZE];
	int length;
};

	bool init(list * ls);//��ʼ�����Ա�
	bool print(list * ls);//���������
	bool getlength(list * ls);//���������
	bool Insertlist(list * ls,int pos, ElemType c);//����
	//bool Emptylist();//�������

	//bool Dellist(int pos);//ɾ������
	//bool chlist(int pos, int c);//��������
	//int  Locatelist(int c);//�������
	
		
	


	

