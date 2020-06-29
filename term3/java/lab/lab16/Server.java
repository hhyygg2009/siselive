package lab16;

//服务器端程序
import java.net.*;//导入java.net包中的所有类
import java.io.*;
public class Server {
	public static void main(String args[]) {
		int i = 0;// 计数
		try {
			ServerSocket ss = new ServerSocket (6666);// 创建ServerSocket对象
			System.out.println("服务器已启动......");
			while (true) {
				Socket socket = ss.accept();// 等待客户端连接,并生成Socket对象
				i++;// 计数
				System.out.println("已接受连接请求" + i);
				//返回客户端的输出字节流，并生成PrintStream对象
				PrintStream out = new PrintStream(socket.getOutputStream());
				out.println("欢迎访问服务器!");
				out.close();
				socket.close();//关闭socket
				if (i>=4)//连接数大于等于4时,服务器程序退出
					break;
			}
		} catch (IOException e) {//捕获异常
			System.out.println(e);
		}
	}
}

