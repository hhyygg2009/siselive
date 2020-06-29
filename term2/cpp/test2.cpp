#include <iostream>
#include <string>
using namespace std;

class Person {
private:
	string name;
	int age;
public:
	Person(string n, int a) :name(n), age(a) {}
	string getName() { return name; }
	void setAge(int a) { age = a; }
	int getAge() { return age; }
	void show() {
		cout << "ÐÕÃû:" << name << ",ÄêÁä:" << age;
	}
};

class Teacher :public Person
{
private:
	string email;
};