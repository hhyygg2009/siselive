package lab8;
import java.io.*;//导入java.io包中的所有类
import java.util.*;
public class FileTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str=sc.next();		
		File file = new File(str);// 用命令行第一个参数作为文件或目录名
		
		if (file.exists())
			if (file. isFile()) {// 如果是文件,则显示其有关信息
				System.out.println("绝对路径：" + file. getAbsolutePath());
				System.out.println("文件长度：" + file.length()+ " 字节");
			} else {// 若为目录,则列出该目录下的所有文件或子目录名
				System.out.println("目录：" + file + ", 该目录下的文件或子目录有:");
				String lists[] = file. list();// 返回指定目录的所有文件或目录
				for (int i = 0; i < lists.length;i++) {
					System.out.println("\t" + lists[i]);
				}
		}else{
		System.out.println("指定的内容不存在");
}
}
}
