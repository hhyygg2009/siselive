#coding=utf-8
#tempconvert.py
TempStr = input("输入温度")
if TempStr[-1] in ['f', 'F']:
    C = (eval(TempStr[0:-1])-32)/1.8
    print("转换后{:.2f}C".format(C))
elif TempStr[-1] in ['c', 'C']:
    F = 1.8*eval(TempStr[0:-1])+32
    print("转换后{:.2f}C".format(F))
else:
    print("error")