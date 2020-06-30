
class Quiz:
    def __init__(self,text): #text = 문제, 답변
        self.text = text
        self.yes = None  #처음에 None 으로 둔다
        self.no = None   #처음에 None 으로 둔다


q1 = Quiz('SNS에 사진 올린다 ')
q2 = Quiz('먹는 걸 좋아한다 ') #q1 의 yes
q3 = Quiz('힙하다는 얘기를 자주 듣는다 ') #q1의 no
q4 = Quiz('q1 yes yes')
q5 = Quiz('q1 yes yes yes')

q1.yes = q2
q1.no = q3

q2.yes = q4
q4.yes = q5

current = q1

while True:
    if current == None:
        print('THE END')
        break

    answer= input(current.text)

    if answer == 'y':
        current = current.yes
    elif answer == 'n':
        current = current.no

