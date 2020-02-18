def fun(arr):
    arr = sorted(arr)
     
    for i in range(len(arr)):
        if(arr[i]>=0):
            break
    
    if(i%2==0):
        ans = 1
        for a in arr:
            if(a!=0):
                ans = ans*a
    else:
        ans = 1
        for a in arr:
            if(a<0 and i!=1):
                ans = ans*a
                i = i-1
            if(a>0):
                ans = ans*a
    
    return ans
            



arr = [-1, 0]
print(fun(arr))