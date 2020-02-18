def fun(arr):
    arr = sorted(arr)
    n = len(arr)
    tempArr = [-1]*(n+1)
    end = n-1
    start = 0

    for i in range(n):
        if(i%2==0):
            tempArr[i] = arr[start]
            start = start+1
        else:
            tempArr[i] = arr[end]
            end = end-1
    
    tempArr[n] = tempArr[0]

    sum = 0
    for i in range(n):
        diff = tempArr[i]-tempArr[i+1]
        if(diff<0):
            diff = diff*-1
        sum = sum+diff
    
    return sum

arr = [1,2,4,8]
print(fun(arr))