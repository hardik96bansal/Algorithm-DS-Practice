def findExtra(arr1,arr2):
    n1 = len(arr1)
    n2 = len(arr2)

    mid = n1//2 if n1<n2 else n2//2

    if n1==2 or n2==2:
        if arr1[0]==arr2[1]:
            return arr2[0]
        else:
            return arr1[0]

    if arr1[mid] == arr2[mid]:
        return findExtra(arr1[mid+1:],arr2[mid+1:])
    else:
        return findExtra(arr1[:mid+1],arr2[:mid+1])

    return -1
    
arr1 = [2,4,6,8,9,10,12,13,14,15]
arr2 = [2,4,6,9,10,12,13,14,15]

print(findExtra(arr1,arr2))