package lab7;

import java.util.ArrayList;//导入ArrayList类
//商品类
class Goods {
	private int id;// 编号
	private String name;// 名称
	private float price;// 单价
	private int num;// 数量

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

	public float getTotalPrice() {// 计算总价格
		return price * num;
	}
}


//通过ArrayList类创建一个购物车,用于存储商品
public class ArrayListDemo {
	public static void main(String[] args) {
	/*先创建一个购物车，用于存储商品；再创建3种商品对象添，并加到购物车中；之后输出各商品信息及总价格，如下图所示:
	 	
	请填充填充程序所缺代码
		*/
		ArrayList<Goods> car=new ArrayList<>();
		car.add(new Goods(1,"鸡蛋",2.5f,20));
		car.add(new Goods(6,"大米",45.0f,1));
		car.add(new Goods(17,"图书",68.5f,2));
		float sum=0;
		for (int i=0;i<car.size();i++)
		{
			System.out.println("编号:"+car.get(i).getId()+",名称:"+car.get(i).getName()+"，单价："+car.get(i).getPrice()+"，数量:"+car.get(i).getNum());
			sum+=car.get(i).getTotalPrice();
		}
		System.out.println("商品总价格:"+sum);
		
	}
}
