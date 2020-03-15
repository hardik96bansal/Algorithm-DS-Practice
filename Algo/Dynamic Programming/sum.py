def solve(num,lookup):
    if(num==0):
        return 1
    if num<0:
        return 0
    if(lookup[num]!=-1):
        return lookup[num]
    lookup[num] = solve(num-1,lookup) + solve(num-3,lookup) + solve(num-5,lookup)
    return lookup[num]

arr = [-1]*1000
print(solve(40,arr))