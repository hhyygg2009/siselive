#include "thread.h"           /*11����գ�����գ�����ͷ�ļ�*/

void CreateBiTree(BTNode*& root, ElemType Array[])
{
	static int count = 0;	//��̬����count
	char item = Array[count];//��ȡArray[]�����еĵ�count��Ԫ��
	count++;
	if (item == '#') //�������#�ַ�����������
	{
		root = NULL;
	}
	else
	{
		root = new Node;  /*���3������һ���½��*/
		root->data = item; /*���4����ch��Ϊ�½����������ֵ*/
		root->Ltag = 0;
		root->Rtag = 0;
		CreateBiTree(root->LChild, Array); /*���5: �ݹ�ķ�����������������ע��ʵ�εı�ʾ����*/
		CreateBiTree(root->RChild, Array); /*���6: �ݹ�ķ�����������������ע��ʵ�εı�ʾ����*/

	}
}

void Inthread(BTNode* p)
/* ��p��ָ�Ķ�������������������������preʼ��ָ��շ��ʹ��Ľ�㣬���ֵΪNULL */
{
	if (p != NULL)
	{
		Inthread(p->LChild);  /* ������������ */
		if (p->LChild == NULL)
		{
			p->Ltag = 1;
			p->LChild = pre;  /*���7-8����ǰ������ */
		}
		if (pre != NULL && pre->RChild == NULL)  /* ���9-10���ú������ */
		{
			pre->Rtag = 1;
			pre->RChild = p;
		}
		pre = p;
		Inthread(p->RChild);  /*������������*/
	}
}

/* �����������������в���p������ǰ��, ����preָ�뷵�ؽ�� */
BTNode* InPre(BTNode* p)
{
	BTNode* q;
	if (p->Ltag == 1)
		pre = p->LChild;  /*���13��ֱ������������ǰ��*/
	else
	{ /* ���14-15����p���������в���"�����¶�"��� */
		for (q = p->LChild; q->Rtag == 0; q = q->RChild);
		pre = q;
	}
	return pre;
}

/*�����������������в���p�������̽�㣬����nextָ�뷵�ؽ��*/
BTNode* InNext(BTNode* p)
{
	BTNode* Next;
	BTNode* q;
	if (p->Rtag == 1)
		Next = p->RChild;  /*���16��ֱ����������*/
	else
	{ /*���17-18�� ��p���������в���"�����¶�"���*/
		for (q = p->RChild; q->Ltag == 0; q = q->LChild);
		Next = q;
	}
	return Next;
}

int main()
{
	BTNode* root, * q;
	ElemType A[] = "AB#CD##E##F#G##";//��"#"����շ�֧���ĳ����������

	CreateBiTree(root, A);//������������н���������
	pre = NULL;
	Inthread(root);

	q = InPre(root); /*�Ҹ�����ǰ�����ɳ�������������ǰ��*/
	cout << root->data << "��ǰ��Ϊ" << q->data << endl;
	q = InNext(root); /*�Ҹ����ĺ������ɳ������������ĺ���*/
	cout << root->data << "�ĺ��Ϊ" << q->data << endl;

	return 0;
}
