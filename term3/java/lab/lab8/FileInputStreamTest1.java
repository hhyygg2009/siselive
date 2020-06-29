package lab8;

import java.io.*;

class FileInputStreamTest1 {
	public static void main(String args[]) throws IOException {
		try {
			FileOutputStream outfile = new FileOutputStream("myfile.txt");
			DataOutputStream out = new DataOutputStream(outfile);
		
			out.writeUTF("机器学习");
			out.writeUTF("周志华");			
			out.writeDouble(61.6);
			out.close();
			
			FileInputStream infile = new FileInputStream("myfile.txt");
			DataInputStream in = new DataInputStream(infile);		
			System.out.println(in.readUTF()+in.readUTF()+in.readDouble());				
		} catch (IOException e) {
			System.out.println(e.getMessage());

	}
}
}