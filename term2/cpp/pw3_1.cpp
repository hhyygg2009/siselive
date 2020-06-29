#include <iostream>
#include <cstring>
using namespace std;
class Complex {
private:
	double r, i;
public:
	void Print() {
		cout << r<<"+"<<i<<"i"<<endl;
	}
	void operator = (char * str)
	{
		string a,b;
		int pos;
		a = str;
		pos=a.find("+");
		b = a.substr(0, pos);
		r = atoi(b.c_str());
		b = a.substr( pos,a.length());
		i = atoi(b.c_str());

	}
};
int main()
{
	Complex a;
	a = "3+4i"; a.Print();
	a = "5+6i"; a.Print();

}
