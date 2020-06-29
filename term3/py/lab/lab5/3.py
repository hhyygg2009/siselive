def multi(*nums):
    mul=0
    for i in nums:
        if mul==0:
            mul=i
            continue
        mul=i*mul;
    return mul

print(multi(3,2,9))