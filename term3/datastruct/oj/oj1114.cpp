#include <stdio.h>
int main()
{
	
	int a[8];
	void input_array(int* p, int n);
	void change_array(int* p, int n);
	void print_array(int* p, int n);
	input_array(a, 8);//���ú���input_array()���������Ԫ��ֵ
	change_array(a, 8);//���ú���change_array()�޸������Ԫ��ֵ
	print_array(a, 8);//���ú���print_array()��������Ԫ��ֵ
	return 0;
}

void input_array(int* p, int n) //���������Ԫ�ص�ֵ���ÿո�ֿ�
{
	for (int i = 0; i < n; i++) {
		scanf("%d", &p[i]);
	}

	//�������


}

void change_array(int* p, int n) //�޸������Ԫ�ص�ֵ�������ǣ��±�Ϊż��(����0)���޸�Ϊԭ���ݵ�2�����±�Ϊ�������޸�Ϊԭ���ݵ�2��+1
{
	for (int i = 0; i < n; i++) {
		if (i % 2 == 0)
			p[i] *= 2;
		else {
			p[i] = p[i] * 2 + 1;
		}
	}

}

	//�������




void print_array(int* p, int n)//����޸ĺ�������Ԫ��ֵ���ÿո�ֿ�(���һ�����ݺ�Ҳ�пո�)
{
	for (int i = 0; i < n; i++) {
		printf("%d ", p[i]);
	}

	//�������


}