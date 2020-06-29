package lab8;


import java.io.*;

class FileOutputStreamTest {
	public static void main(String args[]) throws IOException {
		File f = new File("myfile.txt");
		FileOutputStream outfile = new FileOutputStream(f);
		try {
			for(int i='0';i<='9';i++) {
				outfile.write(i);
			}
			byte b[] ="�ļ������������".getBytes();			
			outfile.write(b);			
			System.out.println("�ļ�����д����ϣ�");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			outfile.close();// �ر������
		}
	}
}

