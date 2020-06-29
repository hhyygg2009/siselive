#include <iostream>
using namespace std;
class Rect
{
private:
	float length;
	float width;
public:

	Rect(float l, float w)
	{
		length = l;
		width = w;

	}
	void display()
	{
		cout << length << width;

	}
	friend void area_compete(Rect &a, Rect &b);

};

void area_compete(Rect &a, Rect &b)
{
	if ((a.length*a.width) > (b.length*b.width))
	{
		a.display();
	}
	else
	{
		b.display();
	}
}

int main()
{
	Rect a(1.0f, 1.0f);
	Rect b(2.0f, 2.0f);
	area_compete(a, b);
}