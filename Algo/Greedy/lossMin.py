def mergeSort(loss,time,l,r):
    if(r>l):
        mid = (l+r)//2
        mergeSort(loss,time,l,mid)
        mergeSort(loss,time,mid+1,r)
        merge(loss,time,l,mid+1,r)

def merge(loss,time,l,mid,r):
    tempLoss = [-1]*(r-l+1)
    tempTime = [-1]*(r-l+1)
    x = l
    y = mid
    for k in range(0,r-l+1):
        if(y==r+1):
            tempLoss[k] = loss[x]
            tempTime[k] = time[x]
            k = k+1
            x = x+1
        elif(x==mid+1):
            tempLoss[k] = loss[y]
            tempTime[k] = time[y]
            k = k+1
            y = y+1
        
        elif(loss[x]*time[y]>loss[y]*time[x]):
            tempLoss[k] = loss[x]
            tempTime[k] = time[x]
            k = k+1
            x = x+1
        else:
            tempLoss[k] = loss[y]
            tempTime[k] = time[y]
            k = k+1
            y = y+1
    
    for j in range (len(tempLoss)):
        loss[l] = tempLoss[j]
        time[l] = tempTime[j]
        l = l+1
        j = j+1


l = [1,2,3,5,6]
t = [2,4,1,3,2]
mergeSort(l,t,0,len(l)-1)
print(l)