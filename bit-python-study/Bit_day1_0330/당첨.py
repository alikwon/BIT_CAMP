from random import randrange


#2

value = randrange(0,4)
current = 0

while True:
    input('마음에 준비를 하시고 Enter')
    print (current)

    if current == value:
        print("커피쏘기")
        break
    else:
        print ("얻어먹어")

    current = current +1

