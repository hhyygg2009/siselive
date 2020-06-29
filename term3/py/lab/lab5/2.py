def isNum(n):
    try:
        s = eval(n)
        if type(s) == float or type(s) == complex or type(s) == int:
            return True
        else:
            return False
    except:
        return False;

print(isNum("11"))

