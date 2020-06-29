package oj1055;

public class Main {
	public static void main(String[] args) {
		C c = new C();
		c.display();
		c.draw();
		A a = c; // 声明抽象类的引用a,并将c赋给a
		a.display(); // 用抽象类引用调用方法
		B b = c; // 声明接口变量b,并将c赋给b
		b.draw(); // 用接口变量调用方法
	}
}

abstract class A { // 声明抽象类A
	public abstract void display(); // 声明抽象方法void display();
}

interface B { // 声明接口B
	public abstract void draw(); // 声明接口方法 void draw();
}

class C extends A implements B { // C类继承了抽象类A，实现了接口B
	public void display() {
		System.out.println("This is the concrete realization of abstract method in abstract class");
	}

	public void draw() {
		System.out.println("This is the concrete realization of the abstract method in the interface");
	}
}
