package lab9;

//文本文件的复制
import java.io.*;

public class TextFileCopy {
	public static void main(String[] args) {
		try {
			// 创建输入流:从文件字符流-->缓冲流
			FileReader fr = new FileReader(args[0]);                //以命令行的第一个参数作为源文件名
			BufferedReader br = new BufferedReader(fr);                // 创建带缓冲区的输入流
			
			// 创建输出流:从文件字符流-->缓冲流
			 FileWriter fw = new FileWriter(args[1]);                              // 以命令行的第二个参数作为目标件名
			BufferedWriter bw = new BufferedWriter(fw);                              // 创建带缓冲区的输出流
			/* 代码段[5]  */int s;
			while (   (s=br.read())!=-1   ) {
				/* 代码段[7]  */bw.write(s);
			}
		/* 代码段[8]  */bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件复制完毕!");
	}
}
