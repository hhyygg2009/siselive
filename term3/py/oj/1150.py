id=input()
date=input()
num=int(id[16:17])

if(num%2==0):
 print("female")
else:
 print("male")
year=int(id[6:10])
years=int(date[0:4])
mon=int(id[10:12])
mons=int(date[5:7])
if(mons-mon)>=0:
 print(years-year)
else:
 print(years-year-1)
