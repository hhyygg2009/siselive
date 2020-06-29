#include <iostream>
#include <string>
using namespace std;

class Complex
{
private:
	double real,image;          		//分别为实部、虚部
public:
	Complex(double rel=0, double img=0)
	{
		real=rel;
		image=img;
	}

	void display()					//输出(a+b*i) 、(a-b*i) 、(a)等形式
	{
		cout<<" ("<<real;
		if (image>0) 
			cout<<"+"<<image<<"*i) ";	//虚部为正
		else if (image<0) 
			cout<<image<<"*i) ";			//虚部为负
		else
			cout<<") ";					//虚部为0，即为实数
	}

	Complex operator +(Complex & c);	//用成员函数重载
	friend istream & operator>>(istream &x, Complex &y);
	friend ostream & operator<<(ostream &x, Complex &y);
		
};

//成员函数的类外定义
Complex Complex::operator +(Complex & c)
{
	Complex temp;
	temp.real=real+c.real;
	temp.image=image+c.image;
	return temp;
}
istream & operator>>(istream &x, Complex &y)
{
	string str,tmp;
	int pos;
	x >> str;
	
	if ((pos = str.find("-", 1)) != string::npos) cout << "检测虚部为负数";
	else {
		if((pos = str.find("+", 1)) != string::npos)
		cout << "检测虚部为正数";
	}

	
	tmp = str.substr(0, pos);
	y.real=atoi(tmp.c_str());
	tmp = str.substr(pos,str.length());
	y.image = atoi(tmp.c_str());

	
	return x;
}
 ostream & operator<<(ostream &x, Complex &y)
{


	x << y.real;
	x << y.image;
	return x;
}

int main()
{
	Complex c1, c2,c3;
	cout<<"请输入c1、c2的值，格式：a+bi "<<endl;
	cin>>c1>>c2;
	c3=c1+c2;
	//输出加的结果
	cout<<c1<<"+"<<c2<<"="<<c3<<endl;
	cout<<endl;

	return 0;
}
