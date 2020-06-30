sum = 0 #누적되는값

while True:

    num = int(input('숫자입력 : '))

    sum = sum + num
    if num == -1:
        break


print(sum)