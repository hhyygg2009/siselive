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


/*连接数据库*/
void connectdb()
{
	printf("正在连接数据库\n");
	ret = SQLAllocHandle(SQL_HANDLE_ENV, NULL, &henv);//申请环境句柄 
	ret = SQLSetEnvAttr(henv, SQL_ATTR_ODBC_VERSION, (SQLPOINTER)SQL_OV_ODBC3, SQL_IS_INTEGER);//设置环境属性 
	ret = SQLAllocHandle(SQL_HANDLE_DBC, henv, &hdbc);//申请数据库连接句柄 
	ret = SQLConnect(hdbc, (SQLCHAR*)"sql", SQL_NTS, (SQLCHAR*)"user", SQL_NTS, (SQLCHAR*)"123456", SQL_NTS);//连接数据库 
	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		printf("数据库连接成功");
	}
	else
	{
		printf("数据库未连接!\n");
		system("pause");
		exit(0);
	}
}

/*断开数据库*/
void disconnect() {
	SQLDisconnect(hdbc);//断开与数据库的连接 
	SQLFreeHandle(SQL_HANDLE_DBC, hdbc);//释放连接句柄 
	SQLFreeHandle(SQL_HANDLE_ENV, henv);//释放环境句柄
}


void input()
{

	char ch;

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//申请SQL语句句柄 
	SQLCHAR sql[] = "INSERT INTO student VALUES (?,?,?,?,?)";
	SQLLEN P = SQL_NTS;
	ret = SQLPrepare(hstmt, sql, SQL_NTS);
	do {
		printf("输入以下信息，用空格隔开\n");
		printf("学号 姓名 语文 数学 英语\n");
		scanf("%d %s %f %f %f", &id, name, &chi, &math, &eng);
		getchar();
		ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id, 0, &P);//绑定参数 
		ret = SQLBindParameter(hstmt, 2, SQL_PARAM_INPUT, SQL_C_CHAR, SQL_CHAR, 10, 0, name, 10, &P);//绑定参数
		ret = SQLBindParameter(hstmt, 3, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &chi, 0, &P);//绑定参数
		ret = SQLBindParameter(hstmt, 4, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &math, 0, &P);//绑定参数 
		ret = SQLBindParameter(hstmt, 5, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &eng, 0, &P);
		ret = SQLExecute(hstmt);//直接执行SQL语句 

		if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {

			/*****************测试结构体数组********************/
			printf("添加信息成功！\n");

		}

		else printf("添加数据库操作失败！\n");
		
		ret = SQLRowCount(hstmt, &number_row);//查询被影响的行数 
		if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO)
			printf("影响了%d个记录\n", number_row);
		else printf("查询结果集记录个数失败！\n");
		printf("任意键继续输入，q键退出\n");
		scanf("%c", &ch);

	} while (ch != 'q');
	SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//释放语句句柄 
}
void search_all()
{

	SQLLEN len_id, len_name, len_chi, len_math, len_eng;

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//申请SQL语句句柄 
	SQLCHAR sql[] = "SELECT *FROM student";
	ret = SQLExecDirect(hstmt, sql, SQL_NTS);//直接执行SQL语句 
	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		int i = 0;
		printf("学号 姓名       语文 数学 英语 平均分\n");
		while (SQLFetch(hstmt) != SQL_NO_DATA) {//遍历结果集
		/*****************************************数据库整型赋值*******************************/
			SQLGetData(hstmt, 1, SQL_C_LONG, &id, 0, &len_id);
			SQLGetData(hstmt, 2, SQL_C_CHAR, name, 20, &len_name);
			SQLGetData(hstmt, 3, SQL_C_FLOAT, &chi, 0, &len_chi);
			SQLGetData(hstmt, 4, SQL_C_FLOAT, &math, 0, &len_math);
			SQLGetData(hstmt, 5, SQL_C_FLOAT, &eng, 0, &len_eng);
			printf("%-4d %s %-4.1f %-4.1f %-4.1f %-4.1f\n", id, name, chi, math, eng,(chi+math+eng)/3.0);
		}
		SQLLEN number_row;
		ret = SQLRowCount(hstmt, &number_row);//查询被影响的行数 
		if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO)
			printf("结果集共有%d个记录\n", number_row);
		else printf("查询结果集记录个数失败！\n");

		SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//释放语句句柄 
	}
	else printf("查询数据库操作失败！\n");






	/********************************************************/

}
void modify()
{
	int id_before;
	search_all();

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//申请SQL语句句柄 
	SQLCHAR sql[] = "update student set id=?,name=?,chi=?,math=?,eng=? where id=?;";
	SQLLEN P = SQL_NTS;
	ret = SQLPrepare(hstmt, sql, SQL_NTS);
	printf("输入以下信息，用空格隔开\n");
	printf("输入要修改信息学生的学号\n");
	scanf("%d", &id_before);
	printf("学号 姓名 语文 数学 英语\n");
	scanf("%d %s %f %f %f", &id, name, &chi, &math, &eng);
	ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id, 0, &P);//绑定参数 
	ret = SQLBindParameter(hstmt, 2, SQL_PARAM_INPUT, SQL_C_CHAR, SQL_CHAR, 10, 0, name, 10, &P);//绑定参数
	ret = SQLBindParameter(hstmt, 3, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &chi, 0, &P);//绑定参数
	ret = SQLBindParameter(hstmt, 4, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &math, 0, &P);//绑定参数 
	ret = SQLBindParameter(hstmt, 5, SQL_PARAM_INPUT, SQL_C_FLOAT, SQL_FLOAT, 0, 0, &eng, 0, &P);
	ret = SQLBindParameter(hstmt, 6, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id_before, 0, &P);//绑定参数 
	ret = SQLExecute(hstmt);//直接执行SQL语句 

	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		/*****************测试结构体数组********************/
		printf("修改信息成功！\n");
		SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//释放语句句柄 
	}
	else printf("修改失败!\n");
}
void del(int ch)
{
	search_all();

	ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);//申请SQL语句句柄 
	SQLLEN P = SQL_NTS;
	SQLCHAR sql[] = "delete from student;";
	if(ch)SQLCHAR sql[] = "delete from student where id=?;";
	ret = SQLPrepare(hstmt, sql, SQL_NTS);
	if (ch) {
		printf("输入要删除行的学号\n");
		scanf("%d", &id);
		ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &id, 0, &P);//绑定参数 
	}
	ret = SQLExecute(hstmt);//直接执行SQL语句 		
	if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {
		/*****************测试结构体数组********************/
		printf("删除信息成功！\n");
		SQLFreeHandle(SQL_HANDLE_STMT, hstmt);//释放语句句柄 
	}
	else printf("添加数据库操作失败！\n");


}


void menu()
{
	system("cls");
	printf("学生成绩管理系统\n");
	printf("--------------------\n");
	printf("请选择一下管理功能：\n");
	printf("1.学生信息输入\n");
	printf("2.学生信息查询\n");
	printf("3.学生信息更改\n");
	printf("4.学生信息删除\n");
	printf("0.退出\n");
	printf("--------------------\n");

}

void men_del()
{
	int ch;
	system("cls");
	printf("学生成绩管理系统\n");
	printf("请选择一下管理功能：\n");
	printf("1.通过id删除\n");
	printf("2.清空数据\n");
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