#include <iostream>
using namespace std;

struct Rect {
	double length;
	double width;
};//�������Σ����ε����Ͷ��壩

void InitRect(Rect& R, double l, double w);//�������
double Circumference(Rect& R);//������ܳ�
double AreaR(Rect& R);//��������

int main()
{
	Rect my_rect;//������α���my_rect
	double Length, Width, Circ, Area;
	cout << "Input length,width:" << endl;
	cin >> Length >> Width;
	InitRect(my_rect, Length, Width);//�������my_rect
	cout << "�����ܳ�Ϊ:"<<Circumference(my_rect) <<"\t�������Ϊ:"<< AreaR(my_rect) << endl;

	return 0;
}


//��ʼ������
void InitRect(Rect& R, double l, double w)
{
	R.length = l;
	R.width = w;
}

//������ܳ�
double Circumference(Rect& R)
{
	return (R.length + R.width) * 2;
}
//��������
double AreaR(Rect& R)
{
	return R.length * R.width;
}
