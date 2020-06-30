min =1
max =100
mid =0
while True:
     mid = int ((min+max)/2)
     print(mid)
     num = input('높으면 H, 낮으면 L, 맞으면 C \n')

     if num == 'H':
         min = mid
     elif num == 'L':
         max = mid

     elif num == 'C':
         break