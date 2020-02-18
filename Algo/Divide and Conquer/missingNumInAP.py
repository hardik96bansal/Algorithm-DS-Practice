def findMissing(arr,l,r,diff):
    if(r-l==1):
        return arr[l]+diff if(arr[r]-arr[l]==2*diff) else -1
    mid = (l+r)//2
    correctVal = arr[0] + (mid)*diff
    if(arr[mid]>correctVal):
        return findMissing(arr,l,mid,diff)
    else:
        return findMissing(arr,mid,r,diff)

def callMe(arr):
    d1 = arr[1]-arr[0]
    d2 = arr[2]-arr[1]
    if(d1==d2):
        return findMissing(arr,0,len(arr)-1,d1)
    else:
        return arr[0]+d2 if d1>d2 else arr[1]+d1


arr = [2,4,6,8,10,12,14,18,20,22]
print(callMe(arr))