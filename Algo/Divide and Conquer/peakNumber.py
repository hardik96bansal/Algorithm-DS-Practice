def findPeak(arr):
    if(len(arr) ==2):
        return arr[0] if arr[0]>arr[1] else arr[1]
    
    mid = len(arr)//2
    if(arr[mid] >= arr[mid+1] and arr[mid]>=arr[mid-1]):
        return arr[mid]
    elif(arr[mid]<arr[mid-1]):
        return findPeak(arr[:mid])
    else:
        return findPeak(arr[mid+1:])
    


arr = [10,15,2,23,90,67]
print(findPeak(arr))