#define OK 1
#define ERROR 0
#define OVERFLOW -2
#include<malloc.h>
#define LIST_INIT_SIZE 100
#define LISTINCREMEMT 10

/*����˳���SqList�������ͣ�������洢�ṹ����ͻ���������ʵ��*/
typedef struct
{
	ElemType *elem;    //�洢�ռ��ַ 
	int listsize;  //��ǰ���� 
	int length;        //��ǰ����Ĵ洢���� 
}SqList;
//����һ���յ�˳���L���ɹ���������1��ʧ�ܷ���0 
int InitList_Sq(SqList *L)
{
	L->elem = (ElemType*)malloc(LIST_INIT_SIZE * sizeof(ElemType));
	if (!L->elem) return OVERFLOW;  //�洢�ռ����ʧ�� 
	L->listsize = LIST_INIT_SIZE;
	L->length = 0;
	return 1;
}
//��ȡ˳���L��Ԫ�ظ��� 
int ListLength_Sq(SqList L)
{
	return L.length;
}
//��e����˳���L�е�i��Ԫ�� 
int GetElem_Sq(SqList L, int i, ElemType *e)
{
	if (i<1 || i>L.length)return ERROR; //λ�ò��Ϸ� 
	*e = L.elem[i - 1];
	return OK;
}
//����˳���L�е�1����e�����ϵcmp()������Ԫ�ص�λ�����������򷵻�0 
int LocateElem_Sq(SqList L, ElemType e, int(*cmp)(ElemType, ElemType))
{
	int i;
	for (i = 0; i < L.length; i++)
	{
		if (cmp(L.elem[i], e))
		{
			return i + 1;    //����ҵ��ˣ����ظ�Ԫ�ص�λ�� 
		}
	}
	return 0;
}
//��˳���L�ĵ�iλ����Ԫ��e 
int ListInsert_Sq(SqList *L, int i, ElemType e)
{
	if (i<1 || i>L->length + 1)return ERROR;   //λ�ò��Ϸ� 
	if (L->length >= L->listsize) //�ռ䲻�� 
	{
		ElemType *newbase;
		newbase = (ElemType*)realloc(L->elem, (L->listsize + LISTINCREMEMT) * sizeof(ElemType));
		if (!newbase)return OVERFLOW;
		L->elem = newbase;
		L->listsize += LISTINCREMEMT;
	}
	int k;
	for (k = L->length - 1; k >= i - 1; k--) //����λ�ü�֮���Ԫ������ 
	{
		L->elem[k + 1] = L->elem[k];
	}
	L->elem[i - 1] = e;
	L->length++;
	return OK;
}
//ɾ��˳���Lָ��λ��i��Ԫ�أ�������ֵ��e���� 
int ListDelete_sq(SqList *L, int i, ElemType *e)
{
	int k;
	if (i<1 || i>L->length)return ERROR; //λ�÷Ƿ� 
	*e = L->elem[i - 1];
	for (k = i; k <= L->length - 1; k++)   //��ɾ��Ԫ��֮���Ԫ������ 
	{
		L->elem[k - 1] = L->elem[k];
	}
	L->length--;
}
//���ζ�L��ÿ������Ԫ�ص��ú���visit(). 
void Traverse_Sq(SqList L, void(*visit)(ElemType))
{
	int i;
	for (i = 0; i < L.length; i++)
	{
		visit(L.elem[i]);
	}
}
//�������La��Lb�ϲ���Lc�У���������Ȼ���� 
void MergeList(SqList La, SqList Lb, SqList *Lc)
{
	InitList_Sq(Lc);
	int i = 1, j = 1, k = 0;
	int La_len = ListLength_Sq(La), Lb_len = ListLength_Sq(Lb);
	ElemType ai, bj;
	while (i <= La_len && j <= Lb_len)   //La��Lb���ǿ� 
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