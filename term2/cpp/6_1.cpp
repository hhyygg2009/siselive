#include <iostream>
using namespace std;

class Complex
{
private:
	double real, image;          	//分别为实部、虚部
public:
	Complex(double rel = 0, double img = 0)
	{
		real = rel;
		image = img;
	}

	void display()					//输出(a+b*i) 、(a-b*i) 、(a)等形式
	{
		cout << " (" << real;
		if (image > 0)
			cout << "+" << image << "*i) ";	//虚部为正
		else if (image < 0)
			cout << image << "*i) ";			//虚部为负
		else
			cout << ") ";					//虚部为0，即为实数
	}

	friend Complex operator -(Complex & c1, Complex & c2);//用友元函数重载
	Complex operator / (int x);
	int operator == (Complex &x);
	int operator != (Complex &x);
};

//友元函数的定义
Complex operator -(Complex & c1, Complex & c2)
{
	Complex temp;
	temp.real = c1.real - c2.real;
	temp.image = c1.image - c2.image;
	return temp;
}
Complex Complex::operator /(int x)
{
	Complex temp;
	temp.real  = real /5;
	temp.image  = image /5;
	return temp;
}

int Complex::operator == (Complex &x)
{
	if (real == x.real&&image == x.image)
		return 1;
	else
		return 0;
}

int Complex::operator != (Complex &x)
{
	if (real == x.real&&image == x.image)
		return 0;
	else
		return 1;
}


int main()
{
	Complex c1(10, 9), c2(3, -4), c3;
	c3 = c1 / 5;

	//输出除的结果
	c1.display();
	cout << "/";
	cout << 5;
	cout << "=";
	c3.display();
	cout << endl;

	//输出比较的结果
	cout << "c1==c2 ? 结果:";
	cout << (c1 == c2) << endl;

	cout << "c1!=c2 ? 结果:";
	cout << (c1 != c2) << endl;
	return 0;
}
