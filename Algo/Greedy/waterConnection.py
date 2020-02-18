class DisjointSet:
    def __init__(self,n):
        self.arr = [-1]*(n+1)
    
    def out(self,fr,to):
        self.arr[fr] = to
    
    def read(self,n):
        if(self.arr[n]!=-1):
            return self.read(self.arr[n])
        return n
    
    def pr(self):
        print(self.arr)

arr = [ [ 7, 4, 98 ], 
        [ 5, 9, 72 ], 
        [ 4, 6, 10 ], 
        [ 2, 8, 22 ], 
        [ 9, 7, 17 ], 
        [ 3, 1, 66 ] ]

p = 9
n = len(arr)
ds = DisjointSet(p)
for a in arr:
    ds.out(a[0],a[1])

print(ds.read(5))