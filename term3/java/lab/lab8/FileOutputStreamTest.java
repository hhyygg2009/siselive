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
			byte b[] ="文件和输入输出流".getBytes();			
			outfile.write(b);			
			System.out.println("文件内容写入完毕！");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			outfile.close();// 关闭输出流
		}
	}
}

