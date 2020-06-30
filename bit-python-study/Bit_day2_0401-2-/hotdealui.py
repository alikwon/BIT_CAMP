from webcatch import getData

#
# answer = input("크롤링을 시작할까요? 좀 기다리세요")
#
# if answer != 'N':
#     exit()

result = getData()
for str in result:

    print(str)