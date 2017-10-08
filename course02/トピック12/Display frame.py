def f(a):
    b=0
    for c in a:
        if len(c)>b:
            b=len(c)
    print("*"*(b+4))
    for d in a:
        print("* "+d+" "*(b+1-len(d))+"*")
    print("*"*(b+4))

f(["Here","is","test2"])
f(["LONGDATA","1234567890123456789012345678901234567890","CHECK"])
f(["TO_CONVEY_ONE'S_MOOD","IN_SEVENTEEN_SYLLABLES","IS_VERY_DIFFIC_(JohnCooperClarke)"])
