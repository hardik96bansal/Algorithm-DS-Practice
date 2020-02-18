def trailingZeroesInFact(num):
    count = 0
    i = 5

    while(num//i>0):
        count = count + num//i
        i = i*5
    
    return count

num = 100
print(trailingZeroesInFact(num))