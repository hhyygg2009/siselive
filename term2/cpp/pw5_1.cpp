#include <iostream>
using namespace std;
class Teacher {
private:
	int num;
	char * pName;
	int age;
public:
	int getnum() {
		return num;
	}
	char * getname() {
		return pName;
	}
	int getage() {
		return age;
	}
	void setnum(int n) {
		num = n;
	}
	void setname(const char * n) {

		strcpy(pName, n);
	}
	void setage(int a) {
		age = a;
	}
	Teacher(int n,const char * na,int a)
	{
		pName = new char[20];
		setnum(n);
		setname(na);
		setage(a);
		printf("���캯��");
	}
	Teacher(int i) {
		
		pName = new char[20];
		setnum(i);
		setname("�");
		
		printf("���캯��2");
	}
	~Teacher(){
		if (pName != NULL) {
			delete[]pName;
		pName = NULL;
		}
		printf("��������");
	}
	Teacher(Teacher & x) {
		age = x.age;
		num = x.num; 
		pName = new char[20];
		strcpy(pName, x.pName);
		printf("���캯��3");
	}
};

int main()
{
	Teacher wang(201, "��ΰ", 35);
	
	Teacher li(wang);
	li.setname("�");
	li.setnum(202);
	
	

	getchar();
	return 0;
}