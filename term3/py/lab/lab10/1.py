from tkinter import *

root=Tk()
root.title("记事本")
menu=Menu(root)
fmenu=Menu(menu,tearoff=0)
emenu=Menu(menu,tearoff=0)
omenu=Menu(menu,tearoff=0)
vmenu=Menu(menu,tearoff=0)
hmenu=Menu(menu,tearoff=0)

for i in ["新建","打开","保存","另存为","l","页面设置","打印","l","退出"]:
    if i=="l":
        fmenu.add_separator()
        continue
    fmenu.add_radiobutton(label=i)


for i in ["撤销","l","剪切","复制","粘贴","删除","l","查找","查找下一个","替换","转到","l","全选","时间/日期"]:
    if i=="l":
        emenu.add_separator()
        continue
    emenu.add_radiobutton(label=i)

for i in ["自动换行","字体"]:
    omenu.add_checkbutton(label=i)

for i in ["状态栏"]:
    vmenu.add_checkbutton(label=i)

for i in ["查看帮助","l","关于记事本"]:
    if i == "l":
        hmenu.add_separator()
        continue
    hmenu.add_radiobutton(label=i)

menu.add_cascade(label="文件",menu=fmenu)
menu.add_cascade(label="编辑",menu=emenu)
menu.add_cascade(label="格式",menu=omenu)
menu.add_cascade(label="查看",menu=vmenu)
menu.add_cascade(label="帮助",menu=hmenu)

root["menu"]=menu
root.mainloop()