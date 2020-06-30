from random import randrange



def check(num_list, target):
    #함수쓰면 분업가능

    result = False

    for x in num_list:
        if x == target:
            result = True
            break

    return result
nums = []
#nums 가 6개가 되는 동안 루프
while len(nums) < 6:
    num = randrange(1,46)

    if check() == True:
        nums.append(num)
    else:
        break

#1부터 45사이의 숫자를 뽑음

# 뽑은 값이 있다면 다시 뽑는다

