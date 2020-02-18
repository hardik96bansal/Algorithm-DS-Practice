def numOfRotations(arr,l,r):
    if(r-l==1):
        return arr[0] if arr[l]<arr[r] else arr[r]
    if(r-l>1):
        mid = (l+r)//2
        if(arr[mid]<arr[r]):
            return numOfRotations(arr,l,mid)
        else:
            return numOfRotations(arr,mid,r)
    return arr[0]

arr = [15,2,3,6,12]
arr2 = [15,16,17]
arr1 = [15,16,17,18,19,1,2,3] 

print(numOfRotations(arr,0,len(arr)-1))
print(numOfRotations(arr1,0,len(arr1)-1))
print(numOfRotations(arr2,0,len(arr2)-1))