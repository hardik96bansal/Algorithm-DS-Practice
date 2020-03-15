def fib(num,lookup): #1 1 2 3 5 8
    if(num <= 1):
        return 1
    if(lookup[num]!=-1):
        print('a')
        return lookup[num]
    
    lookup[num] = (fib(num-1,lookup)+fib(num-2,lookup))
    return lookup[num]

arr = [-1]*1000
print(fib(8,arr))