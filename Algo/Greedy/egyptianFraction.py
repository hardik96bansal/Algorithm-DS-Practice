def egypt(num,den):
    ciel = 0
    if(num==1):
        print('1/',den)
    elif(num<den):
        if(den%num == 0):
            print('1/',den//num)
        else:
            ciel = den//num +1
            print('1/',ciel)
            egypt((num*ciel-den),(ciel*den))

egypt(12,13)