package lab9;

import java.io.*;

public class Lab9_1 {
    public static void main(String[] args) throws      IOException     {//�׳�IOException�쳣
        //����������:���ֽ���-->�ַ���-->������
		     InputStreamReader      isr = new InputStreamReader(     System.in     );
//��InputStreamReader����Ϊ��������BufferedReader����
		     BufferedReader      br = new BufferedReader(     isr     );

        //���������:���ֽ���-->�ַ���-->������
//��"myfile.txt"Ϊ��������FileOutputStream����
        FileOutputStream fos = new FileOutputStream     ("student.csv");
//��FileOutputStream����Ϊ��������OutputStreamWriter����
		     OutputStreamWriter      osw = new OutputStreamWriter(     fos     );
//��OutputStreamWriter����Ϊ��������BufferedWriter����
        BufferedWriter bw = new BufferedWriter     (     osw     );
        System.out.println("�������ַ���(��Ctrl+Z����):");
        String str=null;
        while ((str=br.     readLine     ())!=     null     ){//��������bw�ж�ȡһ���ı�
            bw.     write     (str);//���������д���Ѷ�ȡ���ı�
            bw.     newLine     ();//���������д�뻻�з�
        }
        br.close();
        bw.     close     ();//�ر���
        System.out.println("�ļ��������!");
    }
}

