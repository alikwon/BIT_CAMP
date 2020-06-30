import math

def getCircleArea(radius):

    return math.pow(radius,2) * math.pi

def getDonutArea(r1,r2):        #영역 구분

    area1 = getCircleArea(r1)
    area2 = getCircleArea(r2)

    return abs(area1-area2)

if __name__ == "__main__":      #메인함수 호출

    result = getDonutArea(5,10)

    print(result)