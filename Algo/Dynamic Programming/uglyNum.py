def solve(arr,m,n):
    #lookup = [[0 for i in range(m)] for j in range(n)]
    lookup = arr
    ans = 0
    
    for i in range(m-2,-1,-1):
        for j in range(0,n):
            #print(lookup[j][i])
            if j==0:
                lookup[j][i] = max(lookup[j][i]+lookup[j][i+1],lookup[j][i]+lookup[j+1][i+1])
            elif j==n-1:
                lookup[j][i] = max(lookup[j][i]+lookup[j][i+1],lookup[j][i]+lookup[j-1][i+1])
            else:
                lookup[j][i] = max(lookup[j][i]+lookup[j][i+1],lookup[j][i]+lookup[j+1][i+1],lookup[j][i]+lookup[j-1][i+1])
            
            if(i==0 and lookup[j][i]>ans):
                ans = lookup[j][i]
    print(ans)
    
    




g= [[10, 33, 13, 15],[22, 21, 4, 1],[5, 0, 2, 3],[0, 6, 14, 2]] 

solve(g,4,4)