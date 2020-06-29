//main.cpp内容

#include <iostream>
#include"fraction.h"//包含头文件fraction.h
using namespace std;

int main()
{
	Fraction f1,f2;//定义分数类对象f1、f2
	cout << "请以x/y形式分别输入两个分数:" << endl;
	cout << "f1: ";
	cin>>f1;//输入f1
	cout << "f2: ";
	cin >> f2;
	cout << endl;

	//分数进行四则运算
	cout << f1 << " + " << f2 << " = " << f1 + f2 << endl;
	cout << f1 << " - " << f2 << " = " << f1 - f2 << endl;
	/*
	 代码段8
	*/
	cout << endl;

	//分数的关系运算
/*
 代码段9
*/
	cout << " f1 < f2  ?  结果: " << (f1 < f2) << endl;
	cout << "f1 <= f2  ?  结果: " << (f1 <= f2) << endl;
	cout << " f1 > f2  ?  结果: " << (f1 > f2) << endl;
	cout << " f1 >= f2  ?  结果: " << (f1 >= f2) << endl;
	cout << " f1 == f2  ?  结果: " << (f1 == f2) << endl;
	cout << " f1 != f2  ?  结果: " << (f1 != f2) << endl;
	cout << endl;

	return 0;
}
