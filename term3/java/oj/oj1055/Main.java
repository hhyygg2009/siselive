package oj1055;

public class Main {
	public static void main(String[] args) {
		C c = new C();
		c.display();
		c.draw();
		A a = c; // ���������������a,����c����a
		a.display(); // �ó��������õ��÷���
		B b = c; // �����ӿڱ���b,����c����b
		b.draw(); // �ýӿڱ������÷���
	}
}

abstract class A { // ����������A
	public abstract void display(); // �������󷽷�void display();
}

interface B { // �����ӿ�B
	public abstract void draw(); // �����ӿڷ��� void draw();
}

class C extends A implements B { // C��̳��˳�����A��ʵ���˽ӿ�B
	public void display() {
		System.out.println("This is the concrete realization of abstract method in abstract class");
	}

	public void draw() {
		System.out.println("This is the concrete realization of the abstract method in the interface");
	}
}
