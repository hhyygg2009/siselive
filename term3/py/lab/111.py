try:
    sex,age=input().split()
    age=int(age)
    if (sex=="m" and age>=65) or (sex=="f" and age>=55):
        print("True")
    else:
        print("False")
except:
    print("input error")
