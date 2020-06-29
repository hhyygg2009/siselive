#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void input();
void search();
void search1();
void output();
void bring();
void clear();
void modify();
void modify2();
void menu();
void Save();
void Read();

//——————————————————结构体————————————
struct  inputmessage//建立数据库结构体
{
	char num[10];
	char name[10];
	char price[5];
	int shuliang;
	char people[10];
}ipm[60];

int count=0;//输入的数量计算器；


//————————————物资入库——————————————

void input()
{
	int i=0;
	char k;
	getchar();
	for(i=0;i<100;i++)
	{
		printf("请输入第%d个物资编号、物资名称、物资购入价格、物资数量、采购人的信息（每次输入完一个，请按下空格）：",i+1);
		scanf("%s %s %s %d %s",ipm[i].num,ipm[i].name,ipm[i].price,&ipm[i].shuliang,ipm[i].people);//输入所需要的物资信息
		getchar();
		printf("继续输入请按Y，结束输入请按Q:\n");
		scanf("%c",&k);
		getchar();
		count++;//计算输入总数
		if(k!='Y')
			break;

	}
	printf("您输入的信息总数为%d\n",count);
	Save();
	printf("保存成功\n");
	getchar();
	menu();
}

//————————物资库存查询————————————
void search()
{
	char c;
	printf("若要进行输入特殊信息进行物资查询请输入a，若要查看物资所有信息请输入b\n");
	getchar();
	scanf("%c",&c);
	switch(c)
	{
	case 'a':search1();break;
	case 'b':output();break;
	}

}

void search1()
{
    void Read();
    Read();
			FILE *fp;
			int i=0,j=0;
			char a[10];//储存输入的编号
			printf("输入物资的编号进行查询\n");
            getchar();
			gets(a);
			if((fp=fopen("File1.txt","r+"))==NULL)
			{
				printf("cannot open this file\n");
				exit(0);
			}
			for(i=0;i<count;i++)
			{
				if (strcmp(a,ipm[i].num)==0)
				{
					printf("\n");
					printf("物资编号  物资名称  物资购入价格 物资数量 采购人\n");
					printf("%-10s%-10s%-13s%-9d%-10s\n",ipm[i].num,ipm[i].name,ipm[i].price,ipm[i].shuliang,ipm[i].people);
					printf("完成操作，输入回车返回菜单\n");
					j=1;//表示已经找到符合条件的数据
				}
            }
			if(j==0)
            {
                printf("cannot find\n输入回车返回菜单\n");
            }
			fclose(fp);
            getchar();
            menu();
}



void output()
{
            int i;
            void Read();
			/* 不能够直接读取文件内容QAQ，因为数量用的int储存。。。
			FILE *fp;

			char ch;//获得文档内信息

			if((fp=fopen("file1.txt","r"))==NULL)
			{
				printf("cannot open this file\n");
				exit(0);
			}
			while((ch=fgetc(fp))!=EOF)//读取至文件结束
			{
				putchar(ch);
			}
			fclose(fp);
            */
        Read();
        printf("物资编号  物资名称  物资购入价格 物资数量 采购人\n");
        for(i=0;i<count;i++)
        {
            printf("%-10s%-10s%-13s%-9d%-10s\n",ipm[i].num,ipm[i].name,ipm[i].price,ipm[i].shuliang,ipm[i].people);
        }

		printf("\n是否返回菜单？按1 返回菜单，按2 退出\n");
		scanf("%d",&i);
		if(i==1)
			menu();
		if(i==2)
			exit(0);
}

//——————————————领取模块————————————————

void bring()
{
    void Read();
    Read();
	 int i=0,tmp;
	 char lingqu[30];
	 int shuliang;
		printf("请输入要领取的物资名称：\n");
		getchar();
        gets(lingqu);
		for(i=0;i<count;i++)
		{
			if(strcmp(lingqu,ipm[i].name)==0)//比较是否与输入的字符相同-寻找商品的位置->__->
			{
				printf("库存还剩余：\n");
				printf("%-10d\n",ipm[i].shuliang);//%-xxs是左对齐+空格出，xx是字宽
				break;
			}
		}
				printf("请输入要领取的数量");
				scanf("%d",&shuliang);
				getchar();
				tmp=ipm[i].shuliang-shuliang;
				if(tmp>=0)
				{
					ipm[i].shuliang=tmp;//写回数据
                    printf("库存还剩余：\n");
                    printf("%-10d\n",ipm[i].shuliang);//%-xxs是左对齐+空格出，xx是字宽
					printf("领取成功\n输入回车返回菜单\n");
                    Save();
				}
				else
				{
					printf("领取失败\n输入回车返回菜单\n");
				}
				getchar();
				menu();
}

//————————————————清除库存——————————————
void clear()
{
	FILE *fp;//物资库存文件
	FILE *sp;//副本文件
	char a[50];
	int i=0;
	if((fp=fopen("file1.txt","r+"))==NULL)
		{
			printf("cannot see this file,please make sure your action is ture.\n");
			getchar();
			exit(0);
		}
	if((sp=fopen("file3.txt","w+"))==NULL)
		{
			printf("cannot see this file,please make sure your action is ture.\n");
			getchar();
			exit(0);
		}
	if(ipm[i].shuliang!=0)//如果物资数量不为零，则向副本文件写入
	{
		++i;
		fputs(a,sp);
	}
	fclose(fp);
	fclose(sp);
	remove("file1.txt");//将原来的文件移除
	rename("file3.txt","filel.txt");//重新命名一个文件
	printf("清除成功！\n输入回车返回菜单\n");
	getchar();
    menu();
}

//——————————————————修改物资库存——————————————
void modify()
{
		FILE *fp;
		int shuliang;
		char name[20];
		char num[20];
		int i=0;
		int memory;
		int b;

		if((fp=fopen("file1.txt","r+"))==NULL)
		{
			printf("出现错误！\n");
			exit(0);
		}

		printf("要根据物资编号进行修改请按1，根据物资名称进行修改请按2\n");

			if((fp=fopen("file1.txt","w+"))==NULL)
			{
				printf("出现错误！\n");
				getchar();
			 exit(0);
			}
			getchar();
			scanf("%d",&memory);

			if(memory==1)
			{
				printf("请输入物资编号和修改的物资数量\n");
				scanf("%d",&shuliang);
				gets(num);

				for(i=0;i<count;i++)
				{
					if(strcmp(num,ipm[i].num)==0)
					{
						ipm[i].shuliang=shuliang;
					}
				}
			}
		fclose(fp);
		if((fp=fopen("file1.txt","w+"))==NULL)
			{
				printf("出现错误！\n");
				getchar();
			 exit(0);
			}
		if(memory==2)
		{

			printf("请输入物资名称和修改的物资数量\n");
			gets(name);
			scanf("%d",&shuliang);
			for(i=0;i<count;i++);
			{

				if(strcmp(name,ipm[i].name)==0)
				{
					ipm[i].shuliang=shuliang;

				}
			}

		}
		fclose(fp);
		printf("操作完成，1返回菜单，2进入采购人的修改保存\n");
		b=getchar();
		if(b==1)
			menu();
		if(b==2)
			modify2();
}


void modify2()
{
	FILE *fp;
	int i=0;
	char a[6];
	int shuliang;//输入修改物资数量
	if((fp=fopen("file1.txt","w+"))==NULL)
	{
		printf("出现错误！\n");
		getchar();
		exit(0);
	}
	printf("请输入采购人的信息：\n");
	gets(a);
	printf("请输入数量：\n");
    scanf("%d",&shuliang);
	for(i=0;i<count;i++)
	{
		if(strcmp(a,ipm[i].people)==0)//对比文档内的采购人是否与输入的一样
		{
			ipm[i].shuliang=shuliang;
				//strcpy(ipm[i].shuliang,shuliang);
		}
		else//如果不一样则重新录入保存
		{
			 printf("请输入要录入的新信息：\n");
			 fprintf(fp,"%s %s %s %d %s\n",ipm[i].num,ipm[i].name,ipm[i].price,ipm[i].shuliang,ipm[i].people);
		}
		fclose(fp);
		printf("按回车返回菜单\n");
		getchar();
	}
}

/****************将信息写入文件****************/
void Save()
{
	FILE *fp;
	int i;

	if((fp=fopen("file1.txt","wb"))==NULL)
	{
		printf("cannot open this file\n");
		exit(0);
	}

	for(i=0;i<count;i++)
	{
		if(fwrite(&ipm[i],sizeof(struct  inputmessage),1,fp)!=1)
		{
			printf("写入文件错误\n");
		}
	}
	printf("写入文件完成\n");

	fclose(fp);
}

/****************将信息从文件读出****************/
void Read()
{
	FILE *fp;
	int i,key=0;

	if((fp=fopen("file1.txt","rb"))==NULL)
	{
		printf("cannot open this file\n");
		exit(0);
	}

	for(i=0;i<1000&&!feof(fp);i++)//feof读到文件尾或则到1000结束
	{
		fread(&ipm[i],sizeof(struct  inputmessage),1,fp);
		key++;//读n个数据,由于最读到空的数据也会变成n+1
	}
		fclose(fp);
		if(key!=0)
		{
			count=key-1;//n+1再减去1就是读到的数量了
			printf("读入完成\n");

		}
}

//—————————————————主菜单——————————————
void menu()
{
    system("cls");//清屏
	printf("——————————欢迎使用物资管理系统——————————\n");
	printf("请选择相对应的选项进行操作：\n");
	printf("a.物资入库保存\nb.物资库存查询\n");
	printf("c.物资领取查询\nd.清除物资为零操作\n");
	printf("e.修改物资库存信息\n");
	printf("f.退出\n");
	printf("——————————————————————————————\n");

}


//————————————————————————主函数——————————————————

int main()
{
	char caidan;
    menu();//显示菜单
	while(1)
	{
		scanf("%c",&caidan);
		switch(caidan)
		{
			case 'a':input();break;
			case 'b':search();break;
			case 'c':bring();break;
			case 'd':clear();break;
			case 'e':modify();break;
			case 'f':exit(0);break;
		}

	}

	system("pause");
	return 0;

}

