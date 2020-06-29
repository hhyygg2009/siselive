#include <iostream>
using namespace std;
class Bank {
private:
	long id;
	double balance;
	static double rational;
public:
	void setBalance(double d)
	{
		balance = d;
	}
		double getBalance()
	{
		return balance;
	}
	static void setRational(double r)
	{
		rational = r;
		}
		double getRational()
		{
			return rational;
		}
		void display()
	{
			cout <<"  " <<id << "  " << balance << "  " << rational * balance + balance << endl;
	}
		Bank(long i, double b) 
		{
			id = i;
			balance = b;
			
		}
};

	double Bank::rational = 0.025;
int main()
{
	Bank account[3]{ {1, 10000},{2, 20000 },{3, 50000} };
	for (int i=0; i < 3; i++)
	{
		account[i].display();
	}
	
	getchar();
}