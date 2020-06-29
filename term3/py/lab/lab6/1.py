import random,string

num=range(0,9)
a= list( string.ascii_lowercase)
a.extend(num)

code=random.sample(a,8)

for key in code:
    print(key,end="");