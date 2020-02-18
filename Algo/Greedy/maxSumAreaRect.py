def fun(arr):
    arr = sorted(arr)
    sum = 0
    alt = 0
    prod = 1

    for i in range(0,len(arr),2):
        if(arr[i]==arr[i+1] or arr[i+1]-arr[i]==1):
            prod = prod*arr[i]
            alt = alt+1
            if(alt==2):
                alt = 0
                sum = sum+prod
                prod = 1
        else:
            return 0

    return sum
        

arr = [3,2,5,2]
print(fun(arr))