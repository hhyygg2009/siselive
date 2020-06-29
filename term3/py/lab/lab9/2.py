class Student:
    count=0

    def __init__(self,id,name,age):
        self.id=id
        self.age=age
        self.name=name

    def show(self):
        print("第{}个学生:{},{},{}岁".format(Student.count,self.id,self.name,self.age))

s1=Student(1,"a",18)
s2=Student(2,"b",19)
s1.show()
s2.show()