#pragma once
#include <iostream>
using namespace std;
typedef char ElemType;

typedef struct Node
{
	ElemType data;
	int      Ltag;
	int      Rtag;
	Node* LChild;   /*填空1、指针域的数据类型*/
	Node* RChild;
} BTNode;

BTNode* pre;
void CreateBiTree(BTNode*& root, ElemType Array[]); //创建初始化二叉树
void Inthread(BTNode* p); //实现中序线索二叉树
BTNode* InPre(BTNode* p);    //求中序线索二叉树结点的前驱
BTNode* InNext(BTNode* p);   //求中序线索二叉树结点的后驱

