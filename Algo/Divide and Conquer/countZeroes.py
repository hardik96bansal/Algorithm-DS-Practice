def countZeroes(arr,l,r):
    if((r-l)==1):
        return l if arr[l]==0 else (r if arr[r]==0 else -1)
    if(l<r):
        mid = (l+r)//2
        if(arr[mid] == 0):
            return countZeroes(arr,l,mid)
        if(arr[mid] == 1):
            return countZeroes(arr,mid+1,r)
    return -1

arr = [1,1,1,0,0,0,0]
print(countZeroes(arr,0,len(arr)-1))