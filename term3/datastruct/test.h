#pragma once




//定义一个线性表
class lt
{
private:
	int * Data[];
	int length;

public:

	void init(lt list);//初始化线性表
	void print(lt list);//输出表内容
	void Emptylist(lt list);//清空内容

	void Insertlist(lt list, int pos, int c);//插入
	void Dellist(lt list, int pos);//删除内容
	void chlist(lt list, int pos, int c);//更改内容
	int  Locatelist(lt list, int c);//输出内容
	
		
	


};