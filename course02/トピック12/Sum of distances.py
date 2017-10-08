import math
def f(a):
    b=a.copy()
    b.append(b.pop(0))
    c=0
    for p1,p2 in zip(a,b):
        c+=math.sqrt((p2[0]-p1[0])**2+(p2[1]-p1[1])**2)
    print(c)

f([(0,0),(2,0),(0,2),(5,2),(3,0),(5,0)])
f([(0,0),(1,0),(1,2),(0,2)])
