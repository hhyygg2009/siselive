package lab8;


//对指定目录下的文件进行过滤，并按修改日期逆序显示文件信息
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.Map.Entry;

public class FilenameFilterAndSorted {
	public static void main(String[] args) {
		// 根据路径名称创建File对象
		File dir = new File(".");
		// 得到文件名列表
		if (dir.exists() && dir.isDirectory()) {
			// 创建FileNameFilter类型的匿名类，并作为参数传入到list()方法中
			String[] filterFileNames = dir.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// 对文件名进行过滤，文件名的后缀为.java 或.txt
					return (name.endsWith(".java") || name.endsWith(".txt"));
				}
			});

			// 声明一个HashMap对象,它以文件名为key、以文件修改时间为value
			Map<String, Long> map = new HashMap<String, Long>();
			for (String filename : filterFileNames) {
				map.put(filename, new File(dir, filename).lastModified());

			}
			// 将Map集合转换成List集合中，而List使用ArrayList来实现
			List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(map.entrySet());
			// 最后通过Collections.sort(List l, Comparator c)方法来进行排序
			Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
				public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
					// long数据的范围比较大，直接转换为int型时有可能溢出。好在compare的值只要是正、0、负即可,
					// 可不直接用差,改用 1 或 -1
					long result = o2.getValue() - o1.getValue();
					if (result >= 1)
						return 1;
					else if (result <= -1)
						return -1;
					else
						return 0;
				}
			});

			System.out.printf("%40s%50s", "文件名", "修改时间");
			System.out.println();
			// 为了更友好显示日期,现使用SimpleDateFormat对象来输出文件修改时间
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			for (Map.Entry<String, Long> mapping : list) {
				System.out.printf("%-30s%-20s", mapping.getKey(), formatter.format(new Date(mapping.getValue())));
				System.out.println();
			}

		} else {
			System.out.println("在指定目录中找不到对应文件");
		}
	}
}
