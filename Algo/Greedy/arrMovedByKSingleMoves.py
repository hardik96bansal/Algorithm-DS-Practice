#3 4 6
#5 1 2 3 4
def fun(arr,k):
    n = len(arr)

    for i in range(n):
        maxUntilNow = arr[i]
        if(i<n-k):
            for j in range(i+1,i+k+1):
                if(arr[j]>arr[i]):
                    maxUntilNow = arr[j]
            if(maxUntilNow == arr[i]):
                return arr[i]
        else:
            for j in range(i,n):
                if(arr[j]>maxUntilNow):
                    maxUntilNow = arr[j]
            return maxUntilNow

arr = [2,1,5,4,3,10]
arr1 = [3,1,2]
print(fun(arr1,2))