//main.cpp����

#include <iostream>
#include"fraction.h"//����ͷ�ļ�fraction.h
using namespace std;

int main()
{
	Fraction f1,f2;//������������f1��f2
	cout << "����x/y��ʽ�ֱ�������������:" << endl;
	cout << "f1: ";
	cin>>f1;//����f1
	cout << "f2: ";
	cin >> f2;
	cout << endl;

	//����������������
	cout << f1 << " + " << f2 << " = " << f1 + f2 << endl;
	cout << f1 << " - " << f2 << " = " << f1 - f2 << endl;
	/*
	 �����8
	*/
	cout << endl;

	//�����Ĺ�ϵ����
/*
 �����9
*/
	cout << " f1 < f2  ?  ���: " << (f1 < f2) << endl;
	cout << "f1 <= f2  ?  ���: " << (f1 <= f2) << endl;
	cout << " f1 > f2  ?  ���: " << (f1 > f2) << endl;
	cout << " f1 >= f2  ?  ���: " << (f1 >= f2) << endl;
	cout << " f1 == f2  ?  ���: " << (f1 == f2) << endl;
	cout << " f1 != f2  ?  ���: " << (f1 != f2) << endl;
	cout << endl;

	return 0;
}
