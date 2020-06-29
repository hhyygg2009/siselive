#define OK 1
#define ERROR 0
#define OVERFLOW -2
#include<malloc.h>
#define LIST_INIT_SIZE 100
#define LISTINCREMEMT 10

/*定义顺序表SqList数据类型，包括其存储结构定义和基本操作的实现*/
typedef struct
{
	ElemType *elem;    //存储空间基址 
	int listsize;  //当前长度 
	int length;        //当前分配的存储容量 
}SqList;
//构造一个空的顺序表L，成功函数返回1，失败返回0 
int InitList_Sq(SqList *L)
{
	L->elem = (ElemType*)malloc(LIST_INIT_SIZE * sizeof(ElemType));
	if (!L->elem) return OVERFLOW;  //存储空间分配失败 
	L->listsize = LIST_INIT_SIZE;
	L->length = 0;
	return 1;
}
//获取顺序表L的元素个数 
int ListLength_Sq(SqList L)
{
	return L.length;
}
//用e返回顺序表L中第i个元素 
int GetElem_Sq(SqList L, int i, ElemType *e)
{
	if (i<1 || i>L.length)return ERROR; //位置不合法 
	*e = L.elem[i - 1];
	return OK;
}
//返回顺序表L中第1个与e满足关系cmp()的数据元素的位序，若不存在则返回0 
int LocateElem_Sq(SqList L, ElemType e, int(*cmp)(ElemType, ElemType))
{
	int i;
	for (i = 0; i < L.length; i++)
	{
		if (cmp(L.elem[i], e))
		{
			return i + 1;    //如果找到了，返回该元素的位序 
		}
	}
	return 0;
}
//在顺序表L的第i位插入元素e 
int ListInsert_Sq(SqList *L, int i, ElemType e)
{
	if (i<1 || i>L->length + 1)return ERROR;   //位置不合法 
	if (L->length >= L->listsize) //空间不足 
	{
		ElemType *newbase;
		newbase = (ElemType*)realloc(L->elem, (L->listsize + LISTINCREMEMT) * sizeof(ElemType));
		if (!newbase)return OVERFLOW;
		L->elem = newbase;
		L->listsize += LISTINCREMEMT;
	}
	int k;
	for (k = L->length - 1; k >= i - 1; k--) //插入位置及之后的元素右移 
	{
		L->elem[k + 1] = L->elem[k];
	}
	L->elem[i - 1] = e;
	L->length++;
	return OK;
}
//删除顺序表L指定位置i的元素，并且其值用e返回 
int ListDelete_sq(SqList *L, int i, ElemType *e)
{
	int k;
	if (i<1 || i>L->length)return ERROR; //位置非法 
	*e = L->elem[i - 1];
	for (k = i; k <= L->length - 1; k++)   //被删除元素之后的元素左移 
	{
		L->elem[k - 1] = L->elem[k];
	}
	L->length--;
}
//依次对L的每个数据元素调用函数visit(). 
void Traverse_Sq(SqList L, void(*visit)(ElemType))
{
	int i;
	for (i = 0; i < L.length; i++)
	{
		visit(L.elem[i]);
	}
}
//将有序表La和Lb合并到Lc中，并保持依然有序 
void MergeList(SqList La, SqList Lb, SqList *Lc)
{
	InitList_Sq(Lc);
	int i = 1, j = 1, k = 0;
	int La_len = ListLength_Sq(La), Lb_len = ListLength_Sq(Lb);
	ElemType ai, bj;
	while (i <= La_len && j <= Lb_len)   //La和Lb均非空 
	{
		GetElem_Sq(La, i, &ai);
		GetElem_Sq(Lb, j, &bj);
		if (ai <= bj)
		{
			ListInsert_Sq(Lc, ++k, ai);
			++i;
		}
		else
		{
			ListInsert_Sq(Lc, ++k, bj);
			++j;
		}
	}
	while (i <= La_len)
	{
		GetElem_Sq(La, i++, &ai);
		ListInsert_Sq(Lc, ++k, ai);
	}
	while (j <= Lb_len)
	{
		GetElem_Sq(Lb, j++, &bj);
		ListInsert_Sq(Lc, ++k, bj);
	}
}