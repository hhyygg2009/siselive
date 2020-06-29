package l8;
import java.io.*;
class Book implements Serializable{
	String BookName;
	String auhors;
	String ISBN;
	double price;
	String pressHouse;
	public Book(String bookName, String auhors, String iSBN, double price,
			String pressHouse) {
		super();
		BookName = bookName;
		this.auhors = auhors;
		ISBN = iSBN;
		this.price = price;
		this.pressHouse = pressHouse;
	}
	@Override
	public String toString() {
		return BookName + "," + auhors + "," + ISBN + "," + price + ","
				+ pressHouse;
	}
}

public class l92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b= new Book("111","222","333",44.4,"555");
		try{
			FileOutputStream fo = new FileOutputStream("111.dat");
			ObjectOutputStream o = new ObjectOutputStream(fo);
			o.writeObject(b);
			
			FileInputStream fi = new FileInputStream("111.dat");
			ObjectInputStream i = new ObjectInputStream(fi);
			Book b1=(Book)i.readObject();
			System.out.println(b1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
