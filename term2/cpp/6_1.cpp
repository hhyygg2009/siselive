#include <iostream>
using namespace std;

class Complex
{
private:
	double real, image;          	//�ֱ�Ϊʵ�����鲿
public:
	Complex(double rel = 0, double img = 0)
	{
		real = rel;
		image = img;
	}

	void display()					//���(a+b*i) ��(a-b*i) ��(a)����ʽ
	{
		cout << " (" << real;
		if (image > 0)
			cout << "+" << image << "*i) ";	//�鲿Ϊ��
		else if (image < 0)
			cout << image << "*i) ";			//�鲿Ϊ��
		else
			cout << ") ";					//�鲿Ϊ0����Ϊʵ��
	}

	friend Complex operator -(Complex & c1, Complex & c2);//����Ԫ��������
	Complex operator / (int x);
	int operator == (Complex &x);
	int operator != (Complex &x);
};

//��Ԫ�����Ķ���
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

	//������Ľ��
	c1.display();
	cout << "/";
	cout << 5;
	cout << "=";
	c3.display();
	cout << endl;

	//����ȽϵĽ��
	cout << "c1==c2 ? ���:";
	cout << (c1 == c2) << endl;

	cout << "c1!=c2 ? ���:";
	cout << (c1 != c2) << endl;
	return 0;
}
