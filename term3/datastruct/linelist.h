#pragma once

#define MAX_SIZE 10

typedef char ElemType;

struct list
{
	ElemType  array[MAX_SIZE];
	int length;
};

	bool init(list * ls);//初始化线性表
	bool print(list * ls);//输出表内容
	bool getlength(list * ls);//输出表内容
	bool Insertlist(list * ls,int pos, ElemType c);//插入
	//bool Emptylist();//清空内容

	//bool Dellist(int pos);//删除内容
	//bool chlist(int pos, int c);//更改内容
	//int  Locatelist(int c);//输出内容
	
		
	


	

