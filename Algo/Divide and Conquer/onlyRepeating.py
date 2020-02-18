def findRepeating(arr,l,r):
    if(r-l==1):
        return arr[l] if arr[l]==arr[r] else -1
    if(r-l==2):
        return arr[l] if(arr[l]==arr[l+1] or arr[l+1]==arr[r]) else -1
    else:
        mid = (l+r)//2
        if(arr[mid] == arr[mid-1] or arr[mid]==arr[mid+1]):
            return arr[mid]
        left = findRepeating(arr,l,mid)
        if(left!=-1):
            return left
        else:
            return findRepeating(arr,mid+1,r)

arr = [1,1,2,3,4]
print(findRepeating(arr,0,len(arr)-1))