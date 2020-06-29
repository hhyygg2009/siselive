from random import random

def enterinf():

    a = eval(input("请输入A能力值"))
    b = eval(input("请输入B能力值"))
    n = eval(input("请输入场次"))
    return a,b,n

def game(a,b,n):
    wina,winb=0,0
    for i in range (n):
        scorea,scoreb=onegame(a,b)
        if scorea>scoreb:
            wina+=1
        else:
            winb+=1
    return wina,winb

def onegame(a,b):
    scorea,scoreb=0,0
    serving='a'
    while not over(scorea,scoreb):
        if serving == 'a':
            if random() < a:
                scorea+=1
            else:
                serving='b'
        else:
            if random() < b:
                scoreb+=1
            else:
                serving='a'

    return scorea,scoreb

def over(scorea,scoreb):
    return scorea == 15 or scoreb == 15

def main():
    a,b,n=enterinf()
    wina,winb=game(a,b,n)
    print("{} {}".format(wina,winb))

main()