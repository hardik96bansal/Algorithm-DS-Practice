def binarySearch(arr, num):
    if(len(arr) == 0 or (len(arr) == 1 and num!=arr[0])):
        return False

    mid = len(arr)//2

    if(num==arr[mid]):
        return True
    elif(num>arr[mid]):
        return binarySearch(arr[mid:], num)
    else:
        return binarySearch(arr[:mid], num)

arr = [1,2,3,4,5,6,7,8,9,10,11,12,13]

print(binarySearch(arr,14))