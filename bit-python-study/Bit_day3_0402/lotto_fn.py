import random

def makeNums():   #함수를 만들 때 이름중요! 대소문자!
    balls = [i for i in range(1,46)]
    random.shuffle(balls)
    return balls[:6]
    # 일단 NONE주고 시작


def input_display():

    money = int(input("금액을 입력하세요 : "))

    if money % 1000 != 0:
        print("1000원 단위로 입력하세요\n")
        input_display()  # 재귀 =함수안에서 다시 자기자신을 실행
    else:
        return int(money / 1000)


def main():
    count = input_display()
    for x in range(count):
        nums = makeNums()
        print (nums)

    print('----------------------')

if __name__ == "__main__":      #메인함수 호출

    main()
