
balls = [ x for x in range(1,46)]

print(balls)

for x in range(6):
    print(balls[0])
    del balls[0]
    print(balls)