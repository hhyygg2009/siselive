def isPrime(num):
    try:
        for i in range(2,num):
            if num%i==0:
                return False
        return True
    except ZeroDivisionError:
        print("err")


