#include <iostream>
using namespace std;

struct Rect {
	double length;
	double width;
};//声明矩形（矩形的类型定义）

void InitRect(Rect& R, double l, double w);//构造矩形
double Circumference(Rect& R);//求矩形周长
double AreaR(Rect& R);//求矩形面积

int main()
{
	Rect my_rect;//定义矩形变量my_rect
	double Length, Width, Circ, Area;
	cout << "Input length,width:" << endl;
	cin >> Length >> Width;
	InitRect(my_rect, Length, Width);//构造矩形my_rect
	cout << "矩形周长为:"<<Circumference(my_rect) <<"\t矩形面积为:"<< AreaR(my_rect) << endl;

	return 0;
}


//初始化矩形
void InitRect(Rect& R, double l, double w)
{
	R.length = l;
	R.width = w;
}

//求矩形周长
double Circumference(Rect& R)
{
	return (R.length + R.width) * 2;
}
//求矩形面积
double AreaR(Rect& R)
{
	return R.length * R.width;
}
