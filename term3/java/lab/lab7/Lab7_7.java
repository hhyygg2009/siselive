package lab7;
import java.util.*;
public class Lab7_7 {
	//生成一副扑克牌:4种花色,每种13张,包含"小王"、"大王"，共计54张
	public static List<String> getCards() {
		/*
		代码段_1
		*/		
		List<String> lis=new ArrayList<>();
		String str;
		String type[]= {"红桃","黑桃","梅花","方角"};
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
		str="大鬼";
		lis.add(str);	
		str="小鬼";
		lis.add(str);	
		return lis;
	}
	
//利用Collections类的相关方法实现随机发牌功能，第1个参数存储的是一副完整的扑克牌，第2个参数存放各玩家应得扑克牌张数
	public static void dealCards(List<String> cards, int[] group) {
		System.out.println("随机分派扑克牌:");
		/*
		代码段_2
		*/
		int x=0;
		Collections.shuffle(cards);
		for(int i=0;i<group.length;i++) {
			System.out.print("第"+(i+1)+"个玩家的牌：");
			for(int j=0;j<group[i];j++) {
			System.out.print(cards.get(x));
			x++;
			}
			System.out.print("\n");
		}
		System.out.print("庄家的牌: ");
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
