#include <iostream>
#include <string>
using namespace std;

class Complex
{
private:
	double real,image;          		//�ֱ�Ϊʵ�����鲿
public:
	Complex(double rel=0, double img=0)
	{
		real=rel;
		image=img;
	}

	void display()					//���(a+b*i) ��(a-b*i) ��(a)����ʽ
	{
		cout<<" ("<<real;
		if (image>0) 
			cout<<"+"<<image<<"*i) ";	//�鲿Ϊ��
		else if (image<0) 
			cout<<image<<"*i) ";			//�鲿Ϊ��
		else
			cout<<") ";					//�鲿Ϊ0����Ϊʵ��
	}

	Complex operator +(Complex & c);	//�ó�Ա��������
	friend istream & operator>>(istream &x, Complex &y);
	friend ostream & operator<<(ostream &x, Complex &y);
		
};

//��Ա���������ⶨ��
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
	
	if ((pos = str.find("-", 1)) != string::npos) cout << "����鲿Ϊ����";
	else {
		if((pos = str.find("+", 1)) != string::npos)
		cout << "����鲿Ϊ����";
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
	cout<<"������c1��c2��ֵ����ʽ��a+bi "<<endl;
	cin>>c1>>c2;
	c3=c1+c2;
	//����ӵĽ��
	cout<<c1<<"+"<<c2<<"="<<c3<<endl;
	cout<<endl;

	return 0;
}
