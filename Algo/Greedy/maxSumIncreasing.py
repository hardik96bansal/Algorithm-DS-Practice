def fun(arr):
    
    maxInPrev = 1000
    sum = 0
    count = 0
    for i in range(len(arr)-1,-1,-1):
        innerArr = arr[i]
        maxInRow = -1
        for j in range(len(innerArr)-1,-1,-1):
            if(innerArr[j]<maxInPrev and innerArr[j]>maxInRow):
                maxInRow = innerArr[j]
        if maxInRow == -1:
            return 0
        else:
            maxInPrev = maxInRow
            sum = sum+maxInRow
            count =count+1

    
    if count == len(arr):
        return sum
    else:
        return 0


arr = [[1,7,3,4],
        [4,2,5,1],
        [9,5,1,8]]

arr1 = [[9,8,7],
        [6,5,4],
        [3,2,1]]        

print(fun(arr1))