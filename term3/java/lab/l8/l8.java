package l8;
import java.io.*;
public class l8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if(args[0].equals("Rename")) {
				File f = new File(args[1]);
				File f1 = new File(args[2]);
				f.renameTo(f1);
				System.out.println("ok");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
