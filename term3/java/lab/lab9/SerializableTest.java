package lab9;

import java.io.*;

//�γ���(�����л�),ʵ��Serializabler�ӿ�
class Course implements           Serializable           {
	String courseID;// �γ̱��
	String courseName;// �γ�����
	int credit;// ѧ��
	double average;// ƽ���ɼ�;

	Course(String id, String name, int n, double aver) {// ���췽��
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
		// ������������
		Course c1 = new Course("���ֵ��Ӽ���", "CO1004", 2, 98.0);
		Course c2 = new Course("���ݽṹ���㷨", "SS1005", 4, 81.5);
		Course c3 = new Course("Java������ƻ���", "CO2002", 4, 85.0);

		// ����Ϊ���л�����
		try {
			// �����ļ��ֽ������,���Դ����ɶ��������
			FileOutputStream file_out = new FileOutputStream("courses.dat");
			                              ObjectOutputStream object_out = new ObjectOutputStream(file_out);                                          
			// ����������д��c1��c2��c3��������
			                  object_out.writeObject(c1);                    
			                  object_out.writeObject(c2);                    
			                  object_out.writeObject(c3);     
			object_out.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		// ����Ϊ�����л�����
		try {
			// �����ļ��ֽ�������,���Դ����ɶ���������
			                  FileInputStream fi = new FileInputStream ("courses.dat");                   
			                  ObjectInputStream object_in = new ObjectInputStream (fi);                     
			                  Course st = null;
			int i;
			System.out.println("�γ�����\t\t�γ̱��\tѧ��\tƽ���ɼ�");
			for (i = 0; i < 3; i++) {
			                  st=(Course)object_in.readObject();                    
				st.displsy();
			}
			object_in.close();
		} catch (ClassNotFoundException e) {
			System.out.println("���ܶ�������!");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
