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
		/**********���˵�**********/
		printf("\t\t   **     ��������Ӧ�����   **  \n");
		printf("\t\t  ------------------------------ \n");
		printf("\t\t|  **1��һ λ �� �� �� ��    ** |\n");
		printf("\t\t|  **2���� λ �� �� �� ��    ** |\n");
		printf("\t\t|  **3���� λ �� �� �� �� Ϸ ** |\n");
		printf("\t\t|  **4���� �� ʮ λ �� �� �� ** |\n");
		printf("\t\t|  **5���� �� ֵ �� Ϸ       ** |\n");
		printf("\t\t|  **6���� �� �� Ϸ          ** |\n");
		printf("\t\t  ------------------------------ \n");
		printf("�����ڵķ����ǣ�%d,������ʼ��Ϸ׬������!\n",score);
		printf("��ӭС����������������Ӧ������������������������Ϸ��ţ�");
		scanf("%d",&x);
		switch(x)
		{
		case 1: num(1);break; //�������㺯��
		case 2: num(2);break; //�������㺯��
		case 3: sort(1);break;   //����������
		case 4: sort(2);break;   //����������
		case 5: maxmin();break; //��ֵ����
		case 6: k=0;break;        //�˳����� 
		default: 
			printf("�������ִ���,������ѡ��\n");  //����û����ܵ��������
			system("pause");
			continue;
		}
	}	
	return 0;
}

void num (int x2)  //����
{	
	int a,b,result,type,oper,i;
	srand(time(0));
	a=rand()%100,b=rand()%100;
	oper=rand()%2;
	switch(x2)
	{
	case 1:a%=10;b%=10;break;   //�������λ����һλ��
	case 2:break;
	}
	if(a<b) {a+=b;b=a-b;a=a-b;}//����
	oper?result=a+b:result=a-b;//���ݷ���������
	system("cls");
	printf("------------------------------------\n");
	printf("��ӭС����������Ӽ���Ϸ\n");
	printf("------------------------------------\n");
	printf("���Ը����������������Ļ��д�˵���Ŀ��");

	for(i=0;i<3;i++)
	{
		printf("%d%c%d���ڶ���?",a,oper?'+':'-',b);
		scanf("%d",&type);
		if (type==result)//��֤���
		{
			printf("��ϲ������,�������\n");
			score+=3;
			break;
		}
		else
		{
			if(i==2) 
			{
				printf("���ǲ���Ŷ������һ�ΰ�,�������ȷ����%d\n",result);
				score++;
				break;
			}
			printf("��Ӵ������ˣ������ԣ�\n\n");
		}
	}
	system("pause");

}

/**********��ֵ����**********/
void maxmin()
{

	int i,j,resultmax,resultmin,same;
	int a[6],min,max;
	system("cls");
	printf("------------------------------------\n");
	printf("��ӭС������������ֵ��Ϸ\n");
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

		printf("���Ը����������������Ļ��д��һ�����֣�");
		for (j = 0;j < 5; j++)
		printf("%d ",a[j]);
		for(i=0;i<3;i++)
	{

		printf("\n���������������ҳ�����������С�������ÿո�������룺");
		scanf("%d %d",&resultmax,&resultmin);
		if (min==resultmin&&max==resultmax)//��֤���
		{
			printf("��ϲ������,�������\n");
			score+=3;
			break;
		}
		else
		{
			if(i==2) 
			{
				printf("���ǲ���Ŷ������һ�ΰ�,��������ֵ%d����Сֵ��%d.\n",resultmax,resultmin);
				score++;
				break;
			}
			printf("��Ӵ������ˣ������ԣ�\n\n");
		}
	}
	system("pause");	
	return;
}

/**********����������**********/
void sort(int x)
{	

	int i,j, m=0,n=9,k=5,same=0;
	char a[11],b[11];
	srand(time(0));


	printf("------------------------------------\n");
	printf("��ӭС������������������Ϸ\n");
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

	printf("���Ը����������������Ļ��д��һ�����֣�");
	printf("%s\n",a);
	for (i = 0; i < k-1; i++)//����
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

	printf("�����ֵ����ˣ���ѵ��Ը��������ִ�С������������룺");
	scanf("%s",b);
		if (strcmp(a,b)==0)
		{
			printf("��ϲ������,�������\n");
			score+=3;
			break;
		}
		else
		{
			if(i==2) 
			{
				printf("���ǲ���Ŷ������һ�ΰ�,����Ĵ���%s\n",a);
				score++;
			
				break;
			}
			printf("��Ӵ������ˣ������ԣ�\n\n");
		}
	}
	system("pause");

}
