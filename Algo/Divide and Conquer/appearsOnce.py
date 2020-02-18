def findNum1(arr):
    if(len(arr)%2==0):
        return -1
    if(len(arr) == 3):
        return arr[0] if arr[1] == arr[2] else arr[2]

    mid = len(arr)//2
    if(arr[mid]==arr[mid+1]):
        return findNum1(arr[mid+2:])
    elif(arr[mid] == arr[mid-1]):
        return findNum1(arr[:mid-1])
    else:
        return mid

arr = [0,1,1,2,2,3,3,5,5]
print(findNum1(arr))