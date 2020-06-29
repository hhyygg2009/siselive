//fraction.h ����
#include <iostream>
using namespace std;

#ifndef __FRACTION_H__
#define __FRACTION_H__

class Fraction				//������
{
private:
	int num;				//����
	int den;				//��ĸ
	void standardize();		//��׼������(����֤��ĸΪ��,���ӿ����ɸ�)
	int gcd(int m, int n);		//�õ�m��n�����Լ��
public:
	Fraction(int n = 0, int d = 1);//��2�������Ĺ��캯�����ֱ�����ӡ���ĸ��ֵ��Ĭ��ֵ�ֱ�Ϊ0��1

	void simplify();			//��������
	void print();

	//�ó�Ա��������+��-��*��/ ���������������
	Fraction operator +(Fraction & f);
	Fraction operator -(Fraction & f);
	Fraction operator *(Fraction & f);
	Fraction operator /(Fraction & f);


	/*
�����1
*/
//����Ԫ��������==��>=��<=��!��<��>��ϵ�����������
	friend int operator ==(Fraction & f1, Fraction & f2);
	friend int operator !=(Fraction & f1, Fraction & f2);
	friend int operator <=(Fraction & f1, Fraction & f2);
	friend int operator >=(Fraction & f1, Fraction & f2);
	friend		int operator >(Fraction & f1, Fraction & f2);
	friend		int operator < (Fraction & f1, Fraction & f2);

	/*
�����2
*/
//����<<��>>�����
	friend ostream & operator<<(ostream & os, const Fraction & f);
	friend istream & operator>>(istream & is, Fraction & f);
};
#endif