def fun(arr):
    mergeSort(arr)
    return arr

def mergeSort(arr):
    if(len(arr)>1):
        m = len(arr)//2
        l = arr[:m]
        r = arr[m:]
        mergeSort(l)
        mergeSort(r)
    
        x=y=k=0
        while x<len(l) and y<len(r):
            if(l[x]<r[y]):
                arr[k] = l[x]
                x = x+1
                k = k+1
            else:
                arr[k] = r[y]
                y = y+1
                k = k+1
        
        while x<len(l):
            arr[k] = l[x]
            x = x+1
            k = k+1

        while y<len(r):
            arr[k] = r[y]
            y = y+1
            k = k+1            
    



arr = [5,4,1,2,7,6,8,3]
print(fun(arr))
