
//fraction.cpp 内容

#include <iostream>
#include <string>
#include "fraction.h"
using namespace std;

//成员函数的类外定义
Fraction::Fraction(int n, int d)
{
	num = n;
	den = d;
	if (d == 0)
	{
		cout << "分母不能为" << endl;
		exit(1);
	}
	standardize();			//先标准化
	simplify();				//再化简
}

void Fraction::print()//输出分数
{
	if (num == 0 || den == 1)
		cout << num;
	else
		cout << num << "/" << den;
}

void Fraction::standardize()//标准化,确保分母为正,分子可正可负
{
	if (den < 0)				//分子、分母同乘于-1
	{
		num = -num;
		den = -den;
	}
}

int Fraction::gcd(int m, int n)	//辗转相除法求最大公约数
{
	m = (m >= 0 ? m : -m);		//取正数
	n = (n >= 0 ? n : -n);		//取正数
	
	if (!n)
		return m;
	else
		return gcd(n, m%n);
	/*
	 代码段3
	*/
}

void Fraction::simplify()	//分数化简
{
	int r = gcd(num,den);
	num = num / r;
	den = den / r;
}

Fraction Fraction::operator +(Fraction & f)
{
	int n, d;
	
	//公式：num/den + f.num/f.den =（num*f.den+den*f.num）/（den*f.den）
	Fraction tmp(num*f.den + den * f.num, den*f.den);
	return tmp;



/*
 代码段4
*/
}

Fraction Fraction::operator -(Fraction & f)
{
	int n, d;
	//公式：num/den - f.num/f.den =（num*f.den-den*f.num）/（den*f.den）
/*
 代码段5
*/
	Fraction tmp(num*f.den - den * f.num, den*f.den);
	return tmp;
}

Fraction Fraction::operator *(Fraction & f)
{
	int n, d;
	//公式：num/den * f.num/f.den =（num*f.num）/（den*f.den）
	n = num * f.num;
	d = den * f.den;
	return Fraction(n, d);
}

Fraction Fraction::operator /(Fraction & f)
{
	if (f.num == 0)
	{
		cout << "除数不能为0" << endl;
		exit(1);
	}
	int n, d;
	//公式：(num/den) * (f.num/f.den) =（num*f.den）/（den*f.num）
	n = num * f.den;
	d=den*f.num;
	
/*
 代码段6
*/
	return Fraction(n, d);
}

//友元函数的定义
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

//可能有多行代码
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
		os<<f.num<<"/"<<f.den; //以"a/b"的形式输出
	return         os;
}

istream & operator>>(istream & is, Fraction & f)
{
	string s;
	is >> s;  //将"a/b"作为字符串读入, "a/b" 中间不能有空格
	int pos = s.find("/", 0);
	string sTmp = s.substr(0,pos); //分离出代表实部的字符串
	f.num = atoi(sTmp.c_str());//atoi库函数能将const char*指针指向的内容转换成int 
	sTmp = s.substr(pos + 1, s.length() - pos - 1);   //分离出代表虚部的字符串
	f.den = atoi(sTmp.c_str());
	return is;
}

