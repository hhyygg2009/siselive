#pragma once




//����һ�����Ա�
class lt
{
private:
	int * Data[];
	int length;

public:

	void init(lt list);//��ʼ�����Ա�
	void print(lt list);//���������
	void Emptylist(lt list);//�������

	void Insertlist(lt list, int pos, int c);//����
	void Dellist(lt list, int pos);//ɾ������
	void chlist(lt list, int pos, int c);//��������
	int  Locatelist(lt list, int c);//�������
	
		
	


};