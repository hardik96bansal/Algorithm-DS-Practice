def mergeSort(arr, left, right):
    invs = 0
    if(right-left>1):
        mid = (left+right)//2
        invs = invs +mergeSort(arr,left,mid)
        invs = invs +mergeSort(arr,mid,right)

        invs = invs +merge(arr,left,mid,right)
    
    return invs

def merge(arr, left, mid, right):
    tempArr = [0]*len(arr)
    lArr = arr[left:mid]
    rArr = arr[mid:right]

    i=0;
    j=0;
    k=0;
    invs = 0;

    for k in range(left,right):
        if(i<len(lArr) and j<len(rArr)):
            if(lArr[i]<rArr[j]):
                arr[k] = lArr[i]
                i=i+1
            else:
                arr[k] = rArr[j]
                j=j+1
                invs = invs + len(lArr)-i
        
        else:
            if(j<len(rArr)):
                arr[k] = rArr[j]
                j=j+1
            else:
                arr[k] = lArr[i]
                i=i+1

    print(left,mid,right, arr[left:mid], arr[mid:right])
    return invs


arr = [1,20,6,4,5]
print(mergeSort(arr, 0, len(arr)))
print(arr)
    