//fraction.h 内容
#include <iostream>
using namespace std;

#ifndef __FRACTION_H__
#define __FRACTION_H__

class Fraction				//分数类
{
private:
	int num;				//分子
	int den;				//分母
	void standardize();		//标准化分数(即保证分母为正,分子可正可负)
	int gcd(int m, int n);		//得到m、n的最大公约数
public:
	Fraction(int n = 0, int d = 1);//带2个参数的构造函数，分别给分子、分母赋值，默认值分别为0、1

	void simplify();			//分数化简
	void print();

	//用成员函数重载+、-、*、/ 四则运算符的声明
	Fraction operator +(Fraction & f);
	Fraction operator -(Fraction & f);
	Fraction operator *(Fraction & f);
	Fraction operator /(Fraction & f);


	/*
代码段1
*/
//用友元函数重载==、>=、<=、!、<、>关系运算符的声明
	friend int operator ==(Fraction & f1, Fraction & f2);
	friend int operator !=(Fraction & f1, Fraction & f2);
	friend int operator <=(Fraction & f1, Fraction & f2);
	friend int operator >=(Fraction & f1, Fraction & f2);
	friend		int operator >(Fraction & f1, Fraction & f2);
	friend		int operator < (Fraction & f1, Fraction & f2);

	/*
代码段2
*/
//重载<<、>>运算符
	friend ostream & operator<<(ostream & os, const Fraction & f);
	friend istream & operator>>(istream & is, Fraction & f);
};
#endif