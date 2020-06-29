package lab6;
//打印该类公有方法的返回类型、名称和参数列表
import java.lang.reflect.*;
class MyClass6{
	public void getData(int a, float b, String s){
	}
	public void putData(int a, int b){
	}
}
public class ClassMethodExample {
	public static void main(String[] args) {
		MyClass6 myObj = new MyClass6();
		displayMethods(myObj);
	}
	static void displayMethods(Object obj){
		int count = 0;
		Class c1 = obj.getClass();
		Method[] stringMethods = c1.getMethods();
		while(count < stringMethods.length){
			String methodName = stringMethods[count].getName();
			String returnType = stringMethods[count].getReturnType().toString();
			System.out.print(returnType + " " + methodName + "(");
			
			Class[] parameterTypes = stringMethods[count].getParameterTypes();
			for(int i=0; i< parameterTypes.length; i++){
				String parameterName =parameterTypes[i].getName();
				System.out.print(""+parameterName);
			}
			System.out.println(");");
			count++;
		}
	}
}
