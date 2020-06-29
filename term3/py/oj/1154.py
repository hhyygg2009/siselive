
try:
    x,y=raw_input().split()
    x=int(x)
    y=int(y)
    
    ans=int(x/y)
    print(ans)
except ZeroDivisionError:
    print("division by zero")
except:
    print("input error")

    
