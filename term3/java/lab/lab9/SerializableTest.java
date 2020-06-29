package lab9;

import java.io.*;

//课程类(可序列化),实现Serializabler接口
class Course implements           Serializable           {
	String courseID;// 课程编号
	String courseName;// 课程名称
	int credit;// 学分
	double average;// 平均成绩;

	Course(String id, String name, int n, double aver) {// 构造方法
		courseID = id;
		courseName = name;
		credit = n;
		average = aver;
	}

	public void displsy() {
		System.out.println(courseID + "\t" + courseName + "\t" + credit + "\t"
				+ average);
	}
}

public class SerializableTest {
	public static void main(String[] args) {
		// 创建三个对象
		Course c1 = new Course("数字电子技术", "CO1004", 2, 98.0);
		Course c2 = new Course("数据结构与算法", "SS1005", 4, 81.5);
		Course c3 = new Course("Java程序设计基础", "CO2002", 4, 85.0);

		// 以下为序列化操作
		try {
			// 创建文件字节输出流,并以此生成对象输出流
			FileOutputStream file_out = new FileOutputStream("courses.dat");
			                              ObjectOutputStream object_out = new ObjectOutputStream(file_out);                                          
			// 向对象输出流写入c1、c2、c3三个对象
			                  object_out.writeObject(c1);                    
			                  object_out.writeObject(c2);                    
			                  object_out.writeObject(c3);     
			object_out.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		// 以下为反序列化操作
		try {
			// 创建文件字节输入流,并以此生成对象输入流
			                  FileInputStream fi = new FileInputStream ("courses.dat");                   
			                  ObjectInputStream object_in = new ObjectInputStream (fi);                     
			                  Course st = null;
			int i;
			System.out.println("课程名称\t\t课程编号\t学分\t平均成绩");
			for (i = 0; i < 3; i++) {
			                  st=(Course)object_in.readObject();                    
				st.displsy();
			}
			object_in.close();
		} catch (ClassNotFoundException e) {
			System.out.println("不能读出对象!");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
