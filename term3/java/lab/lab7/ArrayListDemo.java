package lab7;

import java.util.ArrayList;//����ArrayList��
//��Ʒ��
class Goods {
	private int id;// ���
	private String name;// ����
	private float price;// ����
	private int num;// ����

	public Goods(int id, String name, float price, int num) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice(){
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num)   {
		this.num = num;
	}

	public float getTotalPrice() {// �����ܼ۸�
		return price * num;
	}
}


//ͨ��ArrayList�ഴ��һ�����ﳵ,���ڴ洢��Ʒ
public class ArrayListDemo {
	public static void main(String[] args) {
	/*�ȴ���һ�����ﳵ�����ڴ洢��Ʒ���ٴ���3����Ʒ���������ӵ����ﳵ�У�֮���������Ʒ��Ϣ���ܼ۸�����ͼ��ʾ:
	 	
	�������������ȱ����
		*/
		ArrayList<Goods> car=new ArrayList<>();
		car.add(new Goods(1,"����",2.5f,20));
		car.add(new Goods(6,"����",45.0f,1));
		car.add(new Goods(17,"ͼ��",68.5f,2));
		float sum=0;
		for (int i=0;i<car.size();i++)
		{
			System.out.println("���:"+car.get(i).getId()+",����:"+car.get(i).getName()+"�����ۣ�"+car.get(i).getPrice()+"������:"+car.get(i).getNum());
			sum+=car.get(i).getTotalPrice();
		}
		System.out.println("��Ʒ�ܼ۸�:"+sum);
		
	}
}
