
from random import randrange

cnt = 0

while True:

    user = int(input('가위 0, 바위 1, 보 2 \n'))
    com = randrange(0,3)

    #만약 컴이 사용자보다 작은값이면 + 3

    if user > com:
        com = com +3

    result = com - user
    result_str = ''

    if result ==2:
        result_str = 'WIN'
        cnt = cnt + 1
    elif result == 1:
        result_str = 'LOSE'
        cnt = 0
    else:
        result_str = 'DRAW'
        cnt = 0
    print(result_str)

    if cnt == 2:
        break

