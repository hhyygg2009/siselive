#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>
int score=0;
int main()
{   
	void num(int);
	void maxmin();
	void sort(int);
	int x,k=1;
	while(k)
	{
		system("cls");
		system("color f0");
		/**********主菜单**********/
		printf("\t\t   **     数字益智应用软件   **  \n");
		printf("\t\t  ------------------------------ \n");
		printf("\t\t|  **1、一 位 数 加 减 法    ** |\n");
		printf("\t\t|  **2、两 位 数 加 减 法    ** |\n");
		printf("\t\t|  **3、五 位 数 排 序 游 戏 ** |\n");
		printf("\t\t|  **4、五 至 十 位 数 排 序 ** |\n");
		printf("\t\t|  **5、求 最 值 游 戏       ** |\n");
		printf("\t\t|  **6、退 出 游 戏          ** |\n");
		printf("\t\t  ------------------------------ \n");
		printf("你现在的分数是：%d,快来开始游戏赚分数吧!\n",score);
		printf("欢迎小朋友游玩数字益智应用软件，请输入你想游玩的游戏编号：");
		scanf("%d",&x);
		switch(x)
		{
		case 1: num(1);break; //数字运算函数
		case 2: num(2);break; //数字运算函数
		case 3: sort(1);break;   //数字排序函数
		case 4: sort(2);break;   //数字排序函数
		case 5: maxmin();break; //最值函数
		case 6: k=0;break;        //退出程序 
		default: 
			printf("输入数字错误,请重新选择\n");  //解决用户可能的输入错误
			system("pause");
			continue;
		}
	}	
	return 0;
}

void num (int x2)  //运算
{	
	int a,b,result,type,oper,i;
	srand(time(0));
	a=rand()%100,b=rand()%100;
	oper=rand()%2;
	switch(x2)
	{
	case 1:a%=10;b%=10;break;   //随机数两位数变一位数
	case 2:break;
	}
	if(a<b) {a+=b;b=a-b;a=a-b;}//交换
	oper?result=a+b:result=a-b;//根据符号算出结果
	system("cls");
	printf("------------------------------------\n");
	printf("欢迎小朋友游玩求加减游戏\n");
	printf("------------------------------------\n");
	printf("电脑给你出题啦：他在屏幕上写了道题目：");

	for(i=0;i<3;i++)
	{
		printf("%d%c%d等于多少?",a,oper?'+':'-',b);
		scanf("%d",&type);
		if (type==result)//验证结果
		{
			printf("恭喜你答对了,你真棒！\n");
			score+=3;
			break;
		}
		else
		{
			if(i==2) 
			{
				printf("还是不对哦，再来一次吧,这题的正确答案是%d\n",result);
				score++;
				break;
			}
			printf("哎哟，答错了，再试试！\n\n");
		}
	}
	system("pause");

}

/**********最值函数**********/
void maxmin()
{

	int i,j,resultmax,resultmin,same;
	int a[6],min,max;
	system("cls");
	printf("------------------------------------\n");
	printf("欢迎小朋友游玩求最值游戏\n");
	printf("------------------------------------\n");
	srand(time(0));

	for (i = 0;i < 5; i++)
	{
		do{
			same=0;
			a[i]=rand()%10;
			for(j=0;j<i;j++)
			{
				if(a[i]==a[j]) 
				{
					same=1;break;
				}
			}
		}while (same);
	}
	a[i]='\0';

	for (min=max=a[0],i = 1; i < 5; i++)
	{
		if (a[i]>max) max=a[i];
		if (a[i]<min) min=a[i];
	}

		printf("电脑给你出题啦：他在屏幕上写了一串数字：");
		for (j = 0;j < 5; j++)
		printf("%d ",a[j]);
		for(i=0;i<3;i++)
	{

		printf("\n请在上面数字中找出最大的数和最小的数，用空格隔开输入：");
		scanf("%d %d",&resultmax,&resultmin);
		if (min==resultmin&&max==resultmax)//验证结果
		{
			printf("恭喜你答对了,你真棒！\n");
			score+=3;
			break;
		}
		else
		{
			if(i==2) 
			{
				printf("还是不对哦，再来一次吧,这题的最大值%d，最小值是%d.\n",resultmax,resultmin);
				score++;
				break;
			}
			printf("哎哟，答错了，再试试！\n\n");
		}
	}
	system("pause");	
	return;
}

/**********数字排序函数**********/
void sort(int x)
{	

	int i,j, m=0,n=9,k=5,same=0;
	char a[11],b[11];
	srand(time(0));


	printf("------------------------------------\n");
	printf("欢迎小朋友游玩数字排序游戏\n");
	printf("------------------------------------\n");

	switch (x)
	{
	case 1:break;
	case 2:			

		do
		{
			k=rand()%6+5;
			m=rand()%9;
			n=m+1+rand()%9;
		}
		while(n>=10||k>n-m+1);				
	}

	for (i = 0;i < k; i++)
	{
		do{
			same=0;
			a[i]=rand()%(n-m+1)+m+'0';
			for(j=0;j<i;j++)
			{
				if(a[i]==a[j]) 
				{
					same=1;break;
				}
			}
		}while (same);
	}
	a[i]='\0';

	printf("电脑给你出题啦：他在屏幕上写了一串数字：");
	printf("%s\n",a);
	for (i = 0; i < k-1; i++)//排序
	{
		for (j = 0; j < k-1-i; j++)
		{
			if(a[j]>a[j+1])
			{
				a[j]+=a[j+1];
				a[j+1]=a[j]-a[j+1];
				a[j]=a[j]-a[j+1];
			}
		}
	}

	

			for(i=0;i<3;i++)
	{

	printf("现在轮到你了，请把电脑给出的数字从小到大排序后输入：");
	scanf("%s",b);
		if (strcmp(a,b)==0)
		{
			printf("恭喜你答对了,你真棒！\n");
			score+=3;
			break;
		}
		else
		{
			if(i==2) 
			{
				printf("还是不对哦，再来一次吧,这题的答案是%s\n",a);
				score++;
			
				break;
			}
			printf("哎哟，答错了，再试试！\n\n");
		}
	}
	system("pause");

}
