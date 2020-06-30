import math

movie_sample = [
    (23,3,'M'),
    (3,32,'A')
]

def calcDistance(point1, point2):
    result = math.sqrt( math.pow(point1[0] -point2[0],2) +
                        math.pow(point1[1] - point2[1],2) )
    return result

count_kiss = 1
count_action = 30

target = (count_kiss, count_action)

movie_sample.sort(key= lambda x: calcDistance(x,target))

print(movie_sample)
