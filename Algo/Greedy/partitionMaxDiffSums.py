def fun(arr,k):
    arr = sorted(arr)
    s1 = 0
    s2 = 0

    for i in range(len(arr)):
        if(i<k):
            s1 = s1+arr[i]
        else:
            s2 = s2+arr[i]
    
    return s2-s1 if s2>s1 else s1-s2

arr = [8,4,5,2,10]
arr1 = [1,1,1,1,1,1,1,1]
print(fun(arr1,3))

#1 4 7 8
#2 3 5 6 
#0 3 4 5 7