import math

class Circle: #클래스 앞엔 대문자

    def __init__(self,r):
        #생성자
        self.radius = r
    def getArea(self):
        return math.pow(self.radius,2)*math.pi

class AreaService: #로직을 위한 클래스

    def calcArea(self,circle1, circle2):
        circle1.getArea()