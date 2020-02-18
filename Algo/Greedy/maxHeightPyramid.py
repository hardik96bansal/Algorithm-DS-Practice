def fun(arr):
    arr = sorted(arr)
    maxPrevWidth = 0
    n = len(arr)
    currWidth = 0
    currHeight = 0
    for i in range(n):
        currWidth = currWidth+1
        if(currWidth>maxPrevWidth):
            currHeight = currHeight+1
            maxPrevWidth = currWidth
            currWidth = 0
    return currHeight

arr = [10,20,30,50,60,70]
print(fun(arr))