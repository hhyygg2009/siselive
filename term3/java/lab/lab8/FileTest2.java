package lab8;
import java.io.*;//导入java.io包中的所有类
import java.util.*;
public class FileTest2 {
	public static void main(String args[]) {
	
		File file = new File("c:/");// 用命令行第一个参数作为文件或目录名
		File f[]=file.listFiles();
		for (File x:f) {
			if(x.isFile()) {
				System.out.println("文件：" + x+ ", 大小"+ x.length()+ " 字节");				
			}
			else {
				System.out.println("子目录：" + x);
			}
		
		}
	}
}
