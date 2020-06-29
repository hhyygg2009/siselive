from random import *
from tkinter import *

x = randint(0, 100)
print(x)
y=0
count=0
def check():
    global count,wind
    count += 1
    y=IntVar()
    if count > 7:
        print("你的表现太差，游戏结束")


    y = int(input())
    if x > y:
        print("小了")
    if x < y:
        print("大了")
    if x == y:

        if 8 > count > 5:
            str = "你的表现还可以"
        if count < 5:
            str = "你的表现很优秀"
        str += "，游戏结束"
        Label(wind,str).pack






wind=Tk()
wind.title="h"
btn=Button(wind,text="比较",command=check)
ent=Entry(wind,textvariable=y)
btn.pack()
ent.pack()
wind.mainloop()