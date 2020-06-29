
//fraction.cpp ����

#include <iostream>
#include <string>
#include "fraction.h"
using namespace std;

//��Ա���������ⶨ��
Fraction::Fraction(int n, int d)
{
	num = n;
	den = d;
	if (d == 0)
	{
		cout << "��ĸ����Ϊ" << endl;
		exit(1);
	}
	standardize();			//�ȱ�׼��
	simplify();				//�ٻ���
}

void Fraction::print()//�������
{
	if (num == 0 || den == 1)
		cout << num;
	else
		cout << num << "/" << den;
}

void Fraction::standardize()//��׼��,ȷ����ĸΪ��,���ӿ����ɸ�
{
	if (den < 0)				//���ӡ���ĸͬ����-1
	{
		num = -num;
		den = -den;
	}
}

int Fraction::gcd(int m, int n)	//շת����������Լ��
{
	m = (m >= 0 ? m : -m);		//ȡ����
	n = (n >= 0 ? n : -n);		//ȡ����
	
	if (!n)
		return m;
	else
		return gcd(n, m%n);
	/*
	 �����3
	*/
}

void Fraction::simplify()	//��������
{
	int r = gcd(num,den);
	num = num / r;
	den = den / r;
}

Fraction Fraction::operator +(Fraction & f)
{
	int n, d;
	
	//��ʽ��num/den + f.num/f.den =��num*f.den+den*f.num��/��den*f.den��
	Fraction tmp(num*f.den + den * f.num, den*f.den);
	return tmp;



/*
 �����4
*/
}

Fraction Fraction::operator -(Fraction & f)
{
	int n, d;
	//��ʽ��num/den - f.num/f.den =��num*f.den-den*f.num��/��den*f.den��
/*
 �����5
*/
	Fraction tmp(num*f.den - den * f.num, den*f.den);
	return tmp;
}

Fraction Fraction::operator *(Fraction & f)
{
	int n, d;
	//��ʽ��num/den * f.num/f.den =��num*f.num��/��den*f.den��
	n = num * f.num;
	d = den * f.den;
	return Fraction(n, d);
}

Fraction Fraction::operator /(Fraction & f)
{
	if (f.num == 0)
	{
		cout << "��������Ϊ0" << endl;
		exit(1);
	}
	int n, d;
	//��ʽ��(num/den) * (f.num/f.den) =��num*f.den��/��den*f.num��
	n = num * f.den;
	d=den*f.num;
	
/*
 �����6
*/
	return Fraction(n, d);
}

//��Ԫ�����Ķ���
int operator ==(Fraction & f1, Fraction & f2)
{
	Fraction temp;
	temp = f1 - f2;
	if (temp.num == 0)
		return 1;
	else
		return 0;
}

int operator !=(Fraction & f1, Fraction & f2)
{

	return         !(f1==f2);
}

//�����ж��д���
int operator >=(Fraction & f1, Fraction & f2)
{
	Fraction temp;
	temp = f1 - f2;
	if (temp.num >= 0)
		return 1;
	else
		return 0;

}

int operator <=(Fraction & f1, Fraction & f2)
{
	Fraction temp;
	temp = f1 - f2;
	if (temp.num <= 0)
		return 1;
	else
		return 0;
}

int operator <(Fraction & f1, Fraction & f2)
{
	return !(f1 >= f2);
}

int operator >(Fraction & f1, Fraction & f2)
{
	return !(f1 <= f2);
}

ostream & operator<<(ostream & os, const Fraction & f)
{
	if (f.num == 0 || f.den == 1)
		cout << f.num;
	else
		os<<f.num<<"/"<<f.den; //��"a/b"����ʽ���
	return         os;
}

istream & operator>>(istream & is, Fraction & f)
{
	string s;
	is >> s;  //��"a/b"��Ϊ�ַ�������, "a/b" �м䲻���пո�
	int pos = s.find("/", 0);
	string sTmp = s.substr(0,pos); //���������ʵ�����ַ���
	f.num = atoi(sTmp.c_str());//atoi�⺯���ܽ�const char*ָ��ָ�������ת����int 
	sTmp = s.substr(pos + 1, s.length() - pos - 1);   //����������鲿���ַ���
	f.den = atoi(sTmp.c_str());
	return is;
}

