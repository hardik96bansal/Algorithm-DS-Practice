def findMax(arr):
    if(len(arr)==2):
        return arr[0] if arr[0]>arr[1] else arr[1]
    l=len(arr)
    mid = l//2
    if(arr[mid]>arr[0]):
        return findMax(arr[mid:])
    else:
        return findMax(arr[:mid+1])

arr = [8, 10, 20, 80, 100, 200, 400,  3, 2, 1]
print(findMax(arr))