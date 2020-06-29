class Rect:

    def __init__(self,length,width):
        self.length=length
        self.width=width

    def perimeter(self):
        return (self.length+self.width)*2
    def area(self):
        return self.length*self.width
    def show(self):
        print("长：{} 宽：{} 周长:{} 面积: {}".format(self.length,self.width,self.perimeter(),self.area()))

r=Rect(40,30)
r.show()