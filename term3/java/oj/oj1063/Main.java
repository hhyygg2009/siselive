package oj1063;

import java.util.Scanner;
import java.io.InputStream;
import java.net.URL;

class Main {
 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  String str_url = sc.nextLine();
  try {
   URL url = new URL(str_url);
   InputStream myinput=url.openStream();
   //所缺代码：功能是读取字节输入流内容，并逐字节输出(假设不包括中文)
   int x;
   while((x=myinput.read())!=-1) {
	   System.out.print((char)x);
   }
  } catch (Exception e) {
   System.out.println("exception");
   e.printStackTrace();
  }

 }
}
