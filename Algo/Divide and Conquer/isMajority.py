def isMajority(arr,num):
    firOcc = firstOccur(arr,num,0,len(arr),-1)
    n = len(arr)
    if(firOcc == -1 or firOcc>n//2):
        return False
    if(arr[firOcc+n//2]==num):
        return True
    else:
        return False

def firstOccur(arr,num,l,r,i):
    if(r>l):
        mid = (l+r)//2
        if(arr[mid] == num):
            j = mid if (mid<i or i==-1) else i
            return firstOccur(arr,num,l,mid,j)
        elif(num<arr[mid]):
            return firstOccur(arr,num,l,mid,i)
        else:
            return firstOccur(arr,num,mid+1,r,i)
    return i




arr = [0,1,2,3,3,3,3,3,10]
#print(firstOccur(arr,11,0,len(arr),-1))
print(isMajority(arr,10))