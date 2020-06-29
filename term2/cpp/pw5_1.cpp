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
		printf("构造函数");
	}
	Teacher(int i) {
		
		pName = new char[20];
		setnum(i);
		setname("李华");
		
		printf("构造函数2");
	}
	~Teacher(){
		if (pName != NULL) {
			delete[]pName;
		pName = NULL;
		}
		printf("析构函数");
	}
	Teacher(Teacher & x) {
		age = x.age;
		num = x.num; 
		pName = new char[20];
		strcpy(pName, x.pName);
		printf("构造函数3");
	}
};

int main()
{
	Teacher wang(201, "王伟", 35);
	
	Teacher li(wang);
	li.setname("李华");
	li.setnum(202);
	
	

	getchar();
	return 0;
}