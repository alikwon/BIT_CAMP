class Player:
    def __init__(self,name):
        self.name = name
        self.position = 0
class GameUI:
    def __init__(self):
        self.player_list = []
        pass

    def makePlayer(self):
        player_count = int(input('몇명?'))

        for x in range(player_count):
            player_name = input('이름입력')
            player = Player(player_name)
            self.player_list.append(player)

    def playGame(self):
        count = 0
        while True:
            current_player = self.player_list[count% len(self.player_list)]
