import math

movie_sample = [
('A', 1, 10),
('A', 3, 9),
('A', 5, 8),
('M', 8, 7),
('A', 5, 6),
('M', 7, 5),
('M', 4, 4),
('M', 7, 0)
]

def calcDistance (point1, point2):
    result = math.sqrt(math.pow(point1[1]-point2[0],2)+
                     math.pow(point1[2]-point2[1],2))

    return result



count_kiss = int(input('키스씬의 숫자를 입력하세요'))
count_action = int(input('액션씬의 숫자를 입력하세요'))

target = (count_kiss, count_action)

movie_sample.sort(key=lambda x: calcDistance(x,target))

a_cnt = 0
m_cnt = 0

for x in movie_sample[0:3]:
    if x[0] == 'M':
        m_cnt += 1
    elif x[0] == 'A':
        a_cnt += 1

print(movie_sample[0:3])

if a_cnt > m_cnt:
    print("액션영화")
elif a_cnt < m_cnt:
    print("멜로영화")