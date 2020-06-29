str=unicode(raw_input())
alp=0
num=0
spa=0
oth=0
for i in range(0,len(str)):
    if str[i].isalpha():
       alp+=1
    if str[i].isnumeric():
        num+=1
    if str[i].isspace():
        spa+=1
        
oth=len(str)-alp-num-spa    
print(alp)
print(num)
print(spa)
print(oth)
