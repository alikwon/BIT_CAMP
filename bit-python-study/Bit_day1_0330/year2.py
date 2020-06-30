year = int(input('연도를 입력하세요: '))

if year%400 == 0:
    print('윤년')

elif year%100 == 0:
    print('평년')

elif year%4 == 0:
    print('윤년')