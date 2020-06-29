package lab16;

import java.net.*;
import java.io.*;
public class UrlConnectionDemo {
	public static void main(String args[]) {
		try {
			String keywords="Java";
			String url_str="http://www.baidu.com/s?wd="+keywords;
			URL url = new URL(url_str);
			URLConnection gc = url.openConnection();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(gc.getInputStream(),"utf-8"));
			String str;
			PrintStream ps=new PrintStream("out.html","utf-8");
			while ((str = in.readLine()) != null)
				System.out.println(str);
			
			in.close();
			ps.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Exception caught");
			e.printStackTrace();
		}
	}
}
