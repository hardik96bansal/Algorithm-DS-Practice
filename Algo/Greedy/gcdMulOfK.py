def fun(arr,k):
    sum = 0
    for i in range(len(arr)):
        if(arr[i]<k):
            sum = sum+k-arr[i]
        elif(arr[i]>k):
            inc = k*(arr[i]//k+1)-arr[i]
            dec = arr[i]%k
            sum = sum + inc if inc<=dec else sum + dec
    
    return sum

arr = [4,9,6]
print(fun(arr,5))