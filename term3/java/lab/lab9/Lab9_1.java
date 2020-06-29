package lab9;

import java.io.*;

public class Lab9_1 {
    public static void main(String[] args) throws      IOException     {//抛出IOException异常
        //创建输入流:从字节流-->字符流-->缓冲流
		     InputStreamReader      isr = new InputStreamReader(     System.in     );
//以InputStreamReader对象为参数创建BufferedReader对象
		     BufferedReader      br = new BufferedReader(     isr     );

        //创建输出流:从字节流-->字符流-->缓冲流
//以"myfile.txt"为参数创建FileOutputStream对象
        FileOutputStream fos = new FileOutputStream     ("student.csv");
//以FileOutputStream对象为参数创建OutputStreamWriter对象
		     OutputStreamWriter      osw = new OutputStreamWriter(     fos     );
//以OutputStreamWriter对象为参数创建BufferedWriter对象
        BufferedWriter bw = new BufferedWriter     (     osw     );
        System.out.println("请输入字符串(按Ctrl+Z结束):");
        String str=null;
        while ((str=br.     readLine     ())!=     null     ){//从输入流bw中读取一行文本
            bw.     write     (str);//向输出流中写入已读取的文本
            bw.     newLine     ();//向输出流中写入换行符
        }
        br.close();
        bw.     close     ();//关闭流
        System.out.println("文件创建完毕!");
    }
}

