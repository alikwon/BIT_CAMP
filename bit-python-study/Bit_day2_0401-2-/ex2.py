# 67에서 가까운 순서로 정렬

nums = [10,20,30,90,88,50,60,70,80]

score = 67

def calc(num,target): # ()안의 인자를 사용하겠다.
    return abs(num-target)

#nums.sort(key= lambda num: abs(score - num))
#w절대값 abs
#num = nums의 인자들. 자동으로 assign
nums.sort(key= lambda num: calc(num,score) )

print(nums)