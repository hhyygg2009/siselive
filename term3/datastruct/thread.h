#pragma once
#include <iostream>
using namespace std;
typedef char ElemType;

typedef struct Node
{
	ElemType data;
	int      Ltag;
	int      Rtag;
	Node* LChild;   /*���1��ָ�������������*/
	Node* RChild;
} BTNode;

BTNode* pre;
void CreateBiTree(BTNode*& root, ElemType Array[]); //������ʼ��������
void Inthread(BTNode* p); //ʵ����������������
BTNode* InPre(BTNode* p);    //��������������������ǰ��
BTNode* InNext(BTNode* p);   //�������������������ĺ���

