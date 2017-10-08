def f(a):
    if 2<len(a):
        print((sum(a)-min(a)-max(a))/(len(a)-2))

f([1,2,3,4,10])
f([7,4,100,5,2,-10])
f([1,2])
