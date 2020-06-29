def isOdd(s):
    try:
        var = eval(s)
        if(var%2!=0):
            return True
        else:
            return False
    except:
        return False

print(isOdd(10))