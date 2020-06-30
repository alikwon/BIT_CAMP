
class Circle:

    def __init__(self):
        #생성자
        print('Circle init')
        self.radius = 10
        # . or [] 메모리 공간에 점프

    def show(self): #메소드엔 self가 파라미터로 들어감
        print('show' , self.radius)

c1 = Circle()
c2 = Circle()

print(c1)
print(c1.radius)
print(c2)
print(c2.radius)

c1.radius=5
c1.show()

c2.radius=10
c2.show()
#<__main__.Circle object at 0x00000000021C8708>
#<__main__.Circle object at 0x00000000021D9148>  >>
#메모리를 새로써서 메모리공간이 서로다름