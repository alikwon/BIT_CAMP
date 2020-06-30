class Quiz:
    def __init__(self,text): #text = 문제, 답변
        self.text = text
        self.yes = None  #처음에 None 으로 둔다
        self.no = None   #처음에 None 으로 둔다

class QuizManager:

    def __init__(self):
        q1 = Quiz('나는 패턴이 있는게 좋다 ')
        q2 = Quiz('자연 그대로의 플라워패턴이나 풀잎패턴이 좋다 ')  # q1 의 yes
        q3 = Quiz('단색의 부드러운 이불이 좋다 ')  # q1의 no
        q4 = Quiz('동물이 그려져 있는 패턴이 좋다') #q1의 yes(q2) 의 no
        q5 = Quiz('심플한 단선 패턴이 좋다') # q1의 yes(q2) 의 no (q4) 의 no
        q6 = Quiz('A. 패턴없는 단색의 심플한 디자인')
        q7 = Quiz('B. 다양한 패턴으로 가득 채워진 디자인')
        q8 = Quiz('C. 귀여운 시바이누들로 가득 채워진 디자인')
        q9 = Quiz('D. 심플하고 고급스러운 디자인')
        q1.yes = q2
        q1.no = q3

        q2.no = q4
        q4.no = q5
        q3.yes = q6
        q2.yes = q7
        q4.yes = q8
        q5.yes = q9

        self.start_quiz = q1 #시작!

    def getFirstQuiz(self):
        return self.start_quiz



class QuizUI:

    def __init__(self):
        self.manager = QuizManager()
        self.playShow(self.manager.getFirstQuiz())

    def playShow(self, quiz): #재귀

        if quiz == None:
            print ('THE END')
            return

        answer = input(quiz.text)

        if answer == 'y':
            self.playShow(quiz.yes)

        elif answer == 'n':
            self.playShow(quiz.no)

ui = QuizUI()