
class Piggysave:

    def __init__(self): #이 공간에 money 라는 변수
        self.money = 0

    def add(self,amount):
        self.money += amount

    def open(self):
        total = self.money
        self.money = 0
        return total



my_save = Piggysave()
your_save = Piggysave()

my_save.add(500)


print(my_save.open())

print(your_save.open())