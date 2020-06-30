
nums = [10,20,30,90,88,50,60,70,80]

score = 67

def calc(num,target):
    print(num, target)
    return abs(num-target)

#nums.sort(key= lambda num: abs(score - num))
nums.sort(key= lambda num: calc(num,score))

print(nums)