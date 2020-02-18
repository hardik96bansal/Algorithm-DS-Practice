def countFreq(arr,num):
    count = 0
    if(len(arr)==0):
        return 0
    mid = len(arr)//2
    if(arr[mid]==num):
        count = count+1
    count = count+countFreq(arr[mid+1:],num)
    count = count+countFreq(arr[:mid],num)

    return count

arr = [1,2,3,4,4,4,5,6,6,7]
print(countFreq(arr,6))