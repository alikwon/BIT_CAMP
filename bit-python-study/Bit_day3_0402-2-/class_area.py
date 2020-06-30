import math


class Circle:

    def __init__(self, r):
        self.radius = r

    def getArea(self):
        return math.pow(self.radius,2) * math.pi

class AreaService:

    def calcArea(self, shape1, shape2):
        return abs(shape1.getArea() - shape2.getArea())


c1 = Circle(10)
c2 = Circle(5)

service = AreaService()
print(service.calcArea(c1,c2))