package lab7;
import java.util.*;
public class Lab7_7 {
	//����һ���˿���:4�ֻ�ɫ,ÿ��13��,����"С��"��"����"������54��
	public static List<String> getCards() {
		/*
		�����_1
		*/		
		List<String> lis=new ArrayList<>();
		String str;
		String type[]= {"����","����","÷��","����"};
		for(int j=0;j<4;j++) {
		for(int i=1;i<=10;i++) {
			if(i==1) str=type[j]+"A";
			else str=type[j]+i;
			lis.add(str);					
		}
		str=type[j]+"J";
		lis.add(str);			
		str=type[j]+"Q";
		lis.add(str);
		str=type[j]+"K";
		lis.add(str);	
		}
		str="���";
		lis.add(str);	
		str="С��";
		lis.add(str);	
		return lis;
	}
	
//����Collections�����ط���ʵ��������ƹ��ܣ���1�������洢����һ���������˿��ƣ���2��������Ÿ����Ӧ���˿�������
	public static void dealCards(List<String> cards, int[] group) {
		System.out.println("��������˿���:");
		/*
		�����_2
		*/
		int x=0;
		Collections.shuffle(cards);
		for(int i=0;i<group.length;i++) {
			System.out.print("��"+(i+1)+"����ҵ��ƣ�");
			for(int j=0;j<group[i];j++) {
			System.out.print(cards.get(x));
			x++;
			}
			System.out.print("\n");
		}
		System.out.print("ׯ�ҵ���: ");
		for(int j=x;j<54;j++) {
		System.out.print(cards.get(j));
		
		}

	}
	

	public static void main(String[] args) {
		List<String> cards = getCards();
		int[] group = { 12, 12, 12, 12 };
		System.out.println(cards);
		dealCards(cards, group);
	}
}
