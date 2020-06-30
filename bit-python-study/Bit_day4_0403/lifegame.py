
import random
class Dice:
    def __init__(self):
        pass
    def roll(self):
        return random.randrange(1,7)

class Player:

    def __init__(self, name):
        self.name = name
        self.position = 0

class Tile:

    def __init__(self, number):
        self.num = number
        self.link = 0

class GameBouard:
    def __init__(self):
        self.tiles = [Tile(x) for x in range(1,26)]
        self.tiles[1].link = 8
        self.tiles[7].link = 11
        self.tiles[23].link = 2
        self.tiles[16].link = 9
        self.tiles[17].link = 9

    def movePlayer(self,p,amount):

        visit_tiles = []

        print('DEBUG: ',p ,amount)
        value = p.position + amount

        current = self.tiles[value]
        visit_tiles.append(current)

        print("DEBUG", current.num, current.link)

        if current.link != 0:
            p.position = current.link
            visit_tiles.append(self.tiles[current.link])

        else:
            p.position = value

        print("debug", p.name, p.position)

class GameUI:

    def __init__(self):
        self.player_list = []
        self.dice= Dice()
        self.board = GameBouard()

    def makePlayers(self):
        players_count = int(input("How many player?"))

        for x in range(players_count):
            players_name = input("Player Name: ")
            player = Player(players_name)
            print(player)
            self.player_list.append(player)

    def playGame(self):
        count = 0

        while True:
            current_player = self.player_list[count % len(self.player_list)]
            print(current_player.name, " 차례입니다.")
            input("주사위 굴리기")
            dice_num = self.dice.roll()
            print('주사위 눈은 ',dice_num, ' 입니다')

            count += 1
            self.board.movePlayer(current_player, dice_num)

ui = GameUI()
ui.makePlayers()
ui.playGame()