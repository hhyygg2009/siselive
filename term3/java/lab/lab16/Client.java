package lab16;

//客户端程序
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String args[]) {
		try {
			Socket sock = new Socket("127.0.0.1", 6666);// 创建Socket对象,地址与端口要对应服务器的值
			//得到服务器端发送过来的字节输入流信息，并进行包装
			BufferedReader in = new BufferedReader(new InputStreamReader(sock
					.getInputStream()));
			String s = in.readLine();
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			System.out.println("error!");
		}
	}
}
