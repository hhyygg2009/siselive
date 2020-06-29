#include <stdio.h>
int main()
{
	
	int a[8];
	void input_array(int* p, int n);
	void change_array(int* p, int n);
	void print_array(int* p, int n);
	input_array(a, 8);//调用函数input_array()输入数组各元素值
	change_array(a, 8);//调用函数change_array()修改数组各元素值
	print_array(a, 8);//调用函数print_array()输出数组各元素值
	return 0;
}

void input_array(int* p, int n) //输入数组各元素的值，用空格分开
{
	for (int i = 0; i < n; i++) {
		scanf("%d", &p[i]);
	}

	//补充代码


}

void change_array(int* p, int n) //修改数组各元素的值，规则是：下标为偶数(包含0)的修改为原数据的2倍，下标为奇数的修改为原数据的2倍+1
{
	for (int i = 0; i < n; i++) {
		if (i % 2 == 0)
			p[i] *= 2;
		else {
			p[i] = p[i] * 2 + 1;
		}
	}

}

	//补充代码




void print_array(int* p, int n)//输出修改后的数组各元素值，用空格分开(最后一个数据后也有空格)
{
	for (int i = 0; i < n; i++) {
		printf("%d ", p[i]);
	}

	//补充代码


}