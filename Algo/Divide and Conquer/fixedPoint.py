def binarySearch(arr,num,l,r):
    if(r-l>=1):
        mid = (l+r)//2
        if(num == arr[mid]):
            return True
        elif(num>arr[mid]):
            return binarySearch(arr,num,mid+1,r)
        else:
            return binarySearch(arr,num,0,mid)
    return -1

def fixedPoint(arr,l,r):
    if(r-l>=1):
        mid = (l+r)//2

        if(arr[mid] == mid):
            return mid
        elif(arr[mid]<mid):
            return fixedPoint(arr,mid+1,r)
        else:
            return fixedPoint(arr,0,mid)
    return -1

    
#arr = [-10,1,0,3,10,11,30,50,100]
arr = [-10,5,0,5,8,2]
print(fixedPoint(arr,0,len(arr)))