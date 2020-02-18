def fun(arr):
    arr = sorted(arr)
    zeroPresent = False

    for i in range(len(arr)):
        if(arr[i]==0):
            zeroPresent = True
            break
        if(arr[i]*-1<0):
            break
    if(i==0):
        return arr[0]
    elif(i%2==1):
        ans = 1
        for a in arr:
            if(a!=0):
                ans = ans*a
        return ans
    else:
        ans = 1
        for a in arr:
            if(a*-1>0 and i!=1):
                ans = ans*a
                i = i-1
            elif(a!=0 and a*-1<0):
                ans = ans*a
        return ans


        

arr = [0, 0]
print(fun(arr))
    
