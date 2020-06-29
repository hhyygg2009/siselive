package lab8;


//��ָ��Ŀ¼�µ��ļ����й��ˣ������޸�����������ʾ�ļ���Ϣ
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.Map.Entry;

public class FilenameFilterAndSorted {
	public static void main(String[] args) {
		// ����·�����ƴ���File����
		File dir = new File(".");
		// �õ��ļ����б�
		if (dir.exists() && dir.isDirectory()) {
			// ����FileNameFilter���͵������࣬����Ϊ�������뵽list()������
			String[] filterFileNames = dir.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// ���ļ������й��ˣ��ļ����ĺ�׺Ϊ.java ��.txt
					return (name.endsWith(".java") || name.endsWith(".txt"));
				}
			});

			// ����һ��HashMap����,�����ļ���Ϊkey�����ļ��޸�ʱ��Ϊvalue
			Map<String, Long> map = new HashMap<String, Long>();
			for (String filename : filterFileNames) {
				map.put(filename, new File(dir, filename).lastModified());

			}
			// ��Map����ת����List�����У���Listʹ��ArrayList��ʵ��
			List<Entry<String, Long>> list = new ArrayList<Entry<String, Long>>(map.entrySet());
			// ���ͨ��Collections.sort(List l, Comparator c)��������������
			Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
				public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
					// long���ݵķ�Χ�Ƚϴ�ֱ��ת��Ϊint��ʱ�п������������compare��ֵֻҪ������0��������,
					// �ɲ�ֱ���ò�,���� 1 �� -1
					long result = o2.getValue() - o1.getValue();
					if (result >= 1)
						return 1;
					else if (result <= -1)
						return -1;
					else
						return 0;
				}
			});

			System.out.printf("%40s%50s", "�ļ���", "�޸�ʱ��");
			System.out.println();
			// Ϊ�˸��Ѻ���ʾ����,��ʹ��SimpleDateFormat����������ļ��޸�ʱ��
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			for (Map.Entry<String, Long> mapping : list) {
				System.out.printf("%-30s%-20s", mapping.getKey(), formatter.format(new Date(mapping.getValue())));
				System.out.println();
			}

		} else {
			System.out.println("��ָ��Ŀ¼���Ҳ�����Ӧ�ļ�");
		}
	}
}
