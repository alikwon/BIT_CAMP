from random import randrange
# 3번 연속이기면 승리

def game():
    com = randrange(0, 3)
    print(' COM: ', com)
    user = int(input('가위 0, 바위 1, 보 2 \n YOU: '))

    if com <  user :
        com = com + 3

    result = com -user
    result_str = ''

    if result == 2:
        result_str = 'USER WIN'
    if result == 1:
        result_str = 'COM WIN'
    if result == 0:
        result_str = 'DRAW'

    print(result_str)
    return (result_str)

before = ''
count = 0

while True:
    result = game()

    if result == 'DRAW':
        continue

    elif result == before:
        count = count + 1
    else:
        count = 1
        before = result

    if count == 3:
        break
