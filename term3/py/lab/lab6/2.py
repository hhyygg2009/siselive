def checksame(a_list):
    for i in range(0,len(a_list)):
        for j in range(i+1,len(a_list)):
            if a_list[i]!=a_list[j]:
                return False
    return True

a=[1,2,3]
print(checksame(a))



