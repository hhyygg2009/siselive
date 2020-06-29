#include <stdio.h>
#include<stdlib.h>
#include<windows.h> 
#include<sql.h> 
#include<sqlext.h> 
#include<sqltypes.h> 
#include<string.h>

int id;
float chi, math, eng;
char name[20];


SQLRETURN ret;
SQLHENV henv;//SQLHANDLE henv 
SQLHDBC hdbc;//SQLHANDLE hdbc 
SQLHSTMT hstmt;//SQLHANDLE hstmt 
SQLLEN number_row;
int connected = 0;


/*�������ݿ�*/
void connectdb()
{
	printf("�����������ݿ�\n");
	ret = SQLAllocHandle(SQL_HANDLE_ENV, NULL, &henv);//���뻷����� 
	ret = SQLSetEnvAttr(henv, SQL_ATTR_ODBC_VERSION, (SQLPOINTER)SQL_OV_ODBC3, SQL_IS_INTEGER);//���û������� 
	ret = SQLAllocHandle(SQL_HANDLE_DBC, henv, &hdbc);//�������ݿ����Ӿ�� 
	ret = SQLConnect(hdbc, (SQLCHAR*)"sql", SQL_NTS, (SQLCHAR*)"user", SQL_NTS, (SQLCHAR*)"123456", SQL_NTS);//�������ݿ� 
	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		printf("���ݿ����ӳɹ�");
	}
	else
	{
		printf("���ݿ�δ����!\n");
		system("pause");
		exit(0);
	}
}

/*�Ͽ����ݿ�*/
void disconnect() {
	SQLDisconnect(hdbc);//�Ͽ������ݿ������ 
	SQLFreeHandle(SQL_HANDLE_DBC, hdbc);//�ͷ����Ӿ�� 
	SQLFreeHandle(SQL_HANDLE_ENV, henv);//�ͷŻ������
}


void input()
{

	char ch;

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//����SQL����� 
	SQLCHAR sql[] = "INSERT INTO student VALUES (?,?,?,?,?)";
	SQLLEN P = SQL_NTS;
	ret = SQLPrepare(hstmt, sql, SQL_NTS);
	do {
		printf("����������Ϣ���ÿո����\n");
		printf("ѧ�� ���� ���� ��ѧ Ӣ��\n");
		scanf("%d %s %f %f %f", &id, name, &chi, &math, &eng);
		getchar();
		ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id, 0, &P);//�󶨲��� 
		ret = SQLBindParameter(hstmt, 2, SQL_PARAM_INPUT, SQL_C_CHAR, SQL_CHAR, 10, 0, name, 10, &P);//�󶨲���
		ret = SQLBindParameter(hstmt, 3, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &chi, 0, &P);//�󶨲���
		ret = SQLBindParameter(hstmt, 4, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &math, 0, &P);//�󶨲��� 
		ret = SQLBindParameter(hstmt, 5, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &eng, 0, &P);
		ret = SQLExecute(hstmt);//ֱ��ִ��SQL��� 

		if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {

			/*****************���Խṹ������********************/
			printf("�����Ϣ�ɹ���\n");

		}

		else printf("������ݿ����ʧ�ܣ�\n");
		
		ret = SQLRowCount(hstmt, &number_row);//��ѯ��Ӱ������� 
		if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO)
			printf("Ӱ����%d����¼\n", number_row);
		else printf("��ѯ�������¼����ʧ�ܣ�\n");
		printf("������������룬q���˳�\n");
		scanf("%c", &ch);

	} while (ch != 'q');
	SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//�ͷ������ 
}
void search_all()
{

	SQLLEN len_id, len_name, len_chi, len_math, len_eng;

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//����SQL����� 
	SQLCHAR sql[] = "SELECT *FROM student";
	ret = SQLExecDirect(hstmt, sql, SQL_NTS);//ֱ��ִ��SQL��� 
	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		int i = 0;
		printf("ѧ�� ����       ���� ��ѧ Ӣ�� ƽ����\n");
		while (SQLFetch(hstmt) != SQL_NO_DATA) {//���������
		/*****************************************���ݿ����͸�ֵ*******************************/
			SQLGetData(hstmt, 1, SQL_C_LONG, &id, 0, &len_id);
			SQLGetData(hstmt, 2, SQL_C_CHAR, name, 20, &len_name);
			SQLGetData(hstmt, 3, SQL_C_FLOAT, &chi, 0, &len_chi);
			SQLGetData(hstmt, 4, SQL_C_FLOAT, &math, 0, &len_math);
			SQLGetData(hstmt, 5, SQL_C_FLOAT, &eng, 0, &len_eng);
			printf("%-4d %s %-4.1f %-4.1f %-4.1f %-4.1f\n", id, name, chi, math, eng,(chi+math+eng)/3.0);
		}
		SQLLEN number_row;
		ret = SQLRowCount(hstmt, &number_row);//��ѯ��Ӱ������� 
		if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO)
			printf("���������%d����¼\n", number_row);
		else printf("��ѯ�������¼����ʧ�ܣ�\n");

		SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//�ͷ������ 
	}
	else printf("��ѯ���ݿ����ʧ�ܣ�\n");






	/********************************************************/

}
void modify()
{
	int id_before;
	search_all();

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//����SQL����� 
	SQLCHAR sql[] = "update student set id=?,name=?,chi=?,math=?,eng=? where id=?;";
	SQLLEN P = SQL_NTS;
	ret = SQLPrepare(hstmt, sql, SQL_NTS);
	printf("����������Ϣ���ÿո����\n");
	printf("����Ҫ�޸���Ϣѧ����ѧ��\n");
	scanf("%d", &id_before);
	printf("ѧ�� ���� ���� ��ѧ Ӣ��\n");
	scanf("%d %s %f %f %f", &id, name, &chi, &math, &eng);
	ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id, 0, &P);//�󶨲��� 
	ret = SQLBindParameter(hstmt, 2, SQL_PARAM_INPUT, SQL_C_CHAR, SQL_CHAR, 10, 0, name, 10, &P);//�󶨲���
	ret = SQLBindParameter(hstmt, 3, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &chi, 0, &P);//�󶨲���
	ret = SQLBindParameter(hstmt, 4, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &math, 0, &P);//�󶨲��� 
	ret = SQLBindParameter(hstmt, 5, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &eng, 0, &P);
	ret = SQLBindParameter(hstmt, 6, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id_before, 0, &P);//�󶨲��� 
	ret = SQLExecute(hstmt);//ֱ��ִ��SQL��� 

	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		/*****************���Խṹ������********************/
		printf("�޸���Ϣ�ɹ���\n");
		SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//�ͷ������ 
	}
	else printf("�޸�ʧ��!\n");
}
void del(int ch)
{
	search_all();

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//����SQL����� 
	SQLLEN P = SQL_NTS;
	SQLCHAR sql[] = "delete from student;";
	if(ch)SQLCHAR sql[] = "delete from student where id=?;";
	ret = SQLPrepare(hstmt, sql, SQL_NTS);
	if (ch) {
		printf("����Ҫɾ���е�ѧ��\n");
		scanf("%d", &id);
		ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id, 0, &P);//�󶨲��� 
	}
	ret = SQLExecute(hstmt);//ֱ��ִ��SQL��� 		
	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		/*****************���Խṹ������********************/
		printf("ɾ����Ϣ�ɹ���\n");
		SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//�ͷ������ 
	}
	else printf("������ݿ����ʧ�ܣ�\n");


}


void menu()
{
	system("cls");
	printf("ѧ���ɼ�����ϵͳ\n");
	printf("--------------------\n");
	printf("��ѡ��һ�¹����ܣ�\n");
	printf("1.ѧ����Ϣ����\n");
	printf("2.ѧ����Ϣ��ѯ\n");
	printf("3.ѧ����Ϣ����\n");
	printf("4.ѧ����Ϣɾ��\n");
	printf("0.�˳�\n");
	printf("--------------------\n");

}

void men_del()
{
	int ch;
	system("cls");
	printf("ѧ���ɼ�����ϵͳ\n");
	printf("��ѡ��һ�¹����ܣ�\n");
	printf("1.ͨ��idɾ��\n");
	printf("2.�������\n");
	scanf("%d", &ch);
	switch (ch)
	{
	case 1:del(1); break;
	case 2:del(0); break;
	default:
		break;
	}
}

int main()
{
	connectdb();
	int choice;
	while (1)
	{
		menu();
		scanf("%d", &choice);
		getchar();
		switch (choice)
		{
		case 1:input(); break;
		case 2:search_all(); break;
		case 3:modify(); break;
		case 4:men_del(); break;
		case 0:exit(0);
		default:
			break;
		}
		system("pause");
	}

	return 0;
}