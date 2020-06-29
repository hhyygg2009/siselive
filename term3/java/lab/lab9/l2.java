package lab9;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class l2 {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		PrintStream ps = new PrintStream("result.txt");
		ps.println("计算机科学与技术专业");
		ps.println("物联网工程专业");
		ps.println("40706101  张小三");
		ps.println("40707101  李小四");
	}

}
