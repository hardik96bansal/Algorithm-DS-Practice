import sys
class DisjointSet:

    def __init__(self,n):
        self.parent = [i for i in range(n+1)]
    
    def find(self,s):
        if(self.parent[s] == s):
            return s
        else:
            self.parent[s] = self.find(self.parent[s])
            return self.parent[s]
    
    def merge(self,u,v):
        self.parent[v] = u


def cmp(a):
    return a['profit']

def maxDeadline(arr):
    ans = -sys.maxsize -1
    for a in arr:
        ans = max(ans,a['deadline'])
    return ans

def fun(arr,n):
    arr = sorted(arr,key=cmp,reverse=True)
    maxDL = maxDeadline(arr)

    ds = DisjointSet(maxDL)
    
    for i in range(n):
        availableSlot = ds.find(arr[i]['deadline'])
        if(availableSlot>0):
            ds.merge(availableSlot-1,availableSlot)
            print(arr[i]['id'])


if __name__ == '__main__':
    arr = [{'id': 'a', 'deadline': 2, 'profit': 100}, 
           {'id': 'b', 'deadline': 1, 'profit': 19}, 
           {'id': 'c', 'deadline': 2, 'profit': 27}, 
           {'id': 'd', 'deadline': 1, 'profit': 25}, 
           {'id': 'e', 'deadline': 3, 'profit': 15}] 
        
    fun(arr,len(arr))

    
