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

//�������������������������������������ṹ�塪����������������������
struct  inputmessage//�������ݿ�ṹ��
{
	char num[10];
	char name[10];
	char price[5];
	int shuliang;
	char people[10];
}ipm[60];

int count=0;//�����������������


//������������������������������⡪��������������������������

void input()
{
	int i=0;
	char k;
	getchar();
	for(i=0;i<100;i++)
	{
		printf("�������%d�����ʱ�š��������ơ����ʹ���۸������������ɹ��˵���Ϣ��ÿ��������һ�����밴�¿ո񣩣�",i+1);
		scanf("%s %s %s %d %s",ipm[i].num,ipm[i].name,ipm[i].price,&ipm[i].shuliang,ipm[i].people);//��������Ҫ��������Ϣ
		getchar();
		printf("���������밴Y�����������밴Q:\n");
		scanf("%c",&k);
		getchar();
		count++;//������������
		if(k!='Y')
			break;

	}
	printf("���������Ϣ����Ϊ%d\n",count);
	Save();
	printf("����ɹ�\n");
	getchar();
	menu();
}

//�������������������ʿ���ѯ������������������������
void search()
{
	char c;
	printf("��Ҫ��������������Ϣ�������ʲ�ѯ������a����Ҫ�鿴����������Ϣ������b\n");
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
			char a[10];//��������ı��
			printf("�������ʵı�Ž��в�ѯ\n");
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
					printf("���ʱ��  ��������  ���ʹ���۸� �������� �ɹ���\n");
					printf("%-10s%-10s%-13s%-9d%-10s\n",ipm[i].num,ipm[i].name,ipm[i].price,ipm[i].shuliang,ipm[i].people);
					printf("��ɲ���������س����ز˵�\n");
					j=1;//��ʾ�Ѿ��ҵ���������������
				}
            }
			if(j==0)
            {
                printf("cannot find\n����س����ز˵�\n");
            }
			fclose(fp);
            getchar();
            menu();
}



void output()
{
            int i;
            void Read();
			/* ���ܹ�ֱ�Ӷ�ȡ�ļ�����QAQ����Ϊ�����õ�int���档����
			FILE *fp;

			char ch;//����ĵ�����Ϣ

			if((fp=fopen("file1.txt","r"))==NULL)
			{
				printf("cannot open this file\n");
				exit(0);
			}
			while((ch=fgetc(fp))!=EOF)//��ȡ���ļ�����
			{
				putchar(ch);
			}
			fclose(fp);
            */
        Read();
        printf("���ʱ��  ��������  ���ʹ���۸� �������� �ɹ���\n");
        for(i=0;i<count;i++)
        {
            printf("%-10s%-10s%-13s%-9d%-10s\n",ipm[i].num,ipm[i].name,ipm[i].price,ipm[i].shuliang,ipm[i].people);
        }

		printf("\n�Ƿ񷵻ز˵�����1 ���ز˵�����2 �˳�\n");
		scanf("%d",&i);
		if(i==1)
			menu();
		if(i==2)
			exit(0);
}

//������������������������������ȡģ�顪������������������������������

void bring()
{
    void Read();
    Read();
	 int i=0,tmp;
	 char lingqu[30];
	 int shuliang;
		printf("������Ҫ��ȡ���������ƣ�\n");
		getchar();
        gets(lingqu);
		for(i=0;i<count;i++)
		{
			if(strcmp(lingqu,ipm[i].name)==0)//�Ƚ��Ƿ���������ַ���ͬ-Ѱ����Ʒ��λ��->__->
			{
				printf("��滹ʣ�ࣺ\n");
				printf("%-10d\n",ipm[i].shuliang);//%-xxs�������+�ո����xx���ֿ�
				break;
			}
		}
				printf("������Ҫ��ȡ������");
				scanf("%d",&shuliang);
				getchar();
				tmp=ipm[i].shuliang-shuliang;
				if(tmp>=0)
				{
					ipm[i].shuliang=tmp;//д������
                    printf("��滹ʣ�ࣺ\n");
                    printf("%-10d\n",ipm[i].shuliang);//%-xxs�������+�ո����xx���ֿ�
					printf("��ȡ�ɹ�\n����س����ز˵�\n");
                    Save();
				}
				else
				{
					printf("��ȡʧ��\n����س����ز˵�\n");
				}
				getchar();
				menu();
}

//�������������������������������������桪��������������������������
void clear()
{
	FILE *fp;//���ʿ���ļ�
	FILE *sp;//�����ļ�
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
	if(ipm[i].shuliang!=0)//�������������Ϊ�㣬���򸱱��ļ�д��
	{
		++i;
		fputs(a,sp);
	}
	fclose(fp);
	fclose(sp);
	remove("file1.txt");//��ԭ�����ļ��Ƴ�
	rename("file3.txt","filel.txt");//��������һ���ļ�
	printf("����ɹ���\n����س����ز˵�\n");
	getchar();
    menu();
}

//�������������������������������������޸����ʿ�桪��������������������������
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
			printf("���ִ���\n");
			exit(0);
		}

		printf("Ҫ�������ʱ�Ž����޸��밴1�������������ƽ����޸��밴2\n");

			if((fp=fopen("file1.txt","w+"))==NULL)
			{
				printf("���ִ���\n");
				getchar();
			 exit(0);
			}
			getchar();
			scanf("%d",&memory);

			if(memory==1)
			{
				printf("���������ʱ�ź��޸ĵ���������\n");
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
				printf("���ִ���\n");
				getchar();
			 exit(0);
			}
		if(memory==2)
		{

			printf("�������������ƺ��޸ĵ���������\n");
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
		printf("������ɣ�1���ز˵���2����ɹ��˵��޸ı���\n");
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
	int shuliang;//�����޸���������
	if((fp=fopen("file1.txt","w+"))==NULL)
	{
		printf("���ִ���\n");
		getchar();
		exit(0);
	}
	printf("������ɹ��˵���Ϣ��\n");
	gets(a);
	printf("������������\n");
    scanf("%d",&shuliang);
	for(i=0;i<count;i++)
	{
		if(strcmp(a,ipm[i].people)==0)//�Ա��ĵ��ڵĲɹ����Ƿ��������һ��
		{
			ipm[i].shuliang=shuliang;
				//strcpy(ipm[i].shuliang,shuliang);
		}
		else//�����һ��������¼�뱣��
		{
			 printf("������Ҫ¼�������Ϣ��\n");
			 fprintf(fp,"%s %s %s %d %s\n",ipm[i].num,ipm[i].name,ipm[i].price,ipm[i].shuliang,ipm[i].people);
		}
		fclose(fp);
		printf("���س����ز˵�\n");
		getchar();
	}
}

/****************����Ϣд���ļ�****************/
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
			printf("д���ļ�����\n");
		}
	}
	printf("д���ļ����\n");

	fclose(fp);
}

/****************����Ϣ���ļ�����****************/
void Read()
{
	FILE *fp;
	int i,key=0;

	if((fp=fopen("file1.txt","rb"))==NULL)
	{
		printf("cannot open this file\n");
		exit(0);
	}

	for(i=0;i<1000&&!feof(fp);i++)//feof�����ļ�β����1000����
	{
		fread(&ipm[i],sizeof(struct  inputmessage),1,fp);
		key++;//��n������,����������յ�����Ҳ����n+1
	}
		fclose(fp);
		if(key!=0)
		{
			count=key-1;//n+1�ټ�ȥ1���Ƕ�����������
			printf("�������\n");

		}
}

//�������������������������������������˵�����������������������������
void menu()
{
    system("cls");//����
	printf("����������������������ӭʹ�����ʹ���ϵͳ��������������������\n");
	printf("��ѡ�����Ӧ��ѡ����в�����\n");
	printf("a.������Ᵽ��\nb.���ʿ���ѯ\n");
	printf("c.������ȡ��ѯ\nd.�������Ϊ�����\n");
	printf("e.�޸����ʿ����Ϣ\n");
	printf("f.�˳�\n");
	printf("������������������������������������������������������������\n");

}


//������������������������������������������������������������������������������������������

int main()
{
	char caidan;
    menu();//��ʾ�˵�
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

