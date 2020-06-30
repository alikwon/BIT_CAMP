#10번의 결과를 담

from random import randrange

def game():

    com = randrange(0, 3)
    print("컴 값",com)
    user = int(input("가위 0, 바위 1, 보 2"))


    result_str = ''
    if user > com:
        com = com + 3
    result = com - user

    if result == 2:
        result_str = 'user_win'
    elif result == 1:
        result_str = 'com_win'
    else:
        result_str = 'd'
    print (result_str)

    return result_str

a = []
while len(a) < 5:
    result=game()
    a.append(result)

print(a)

