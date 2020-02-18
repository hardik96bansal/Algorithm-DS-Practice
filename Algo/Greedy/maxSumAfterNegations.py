def fun(arr,neg):
    arr = sorted(arr)
    for i in range(neg):
        if(arr[0] == 0):
            break
        else:
            arr[0] = -arr[0]
            arr = sorted(arr)
    sum = 0 
    for a in arr:
        sum = sum+a
    return sum

arr = [9,8,8,5]
print(fun(arr,3))