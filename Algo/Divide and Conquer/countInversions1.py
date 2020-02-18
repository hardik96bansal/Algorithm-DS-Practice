def fun(m,n):
    ar = [2,2,2]
    fun1(m,n, ar)
    print('a',m,ar)

def fun1(m,n,arr):
    if(n==8):
        m=100
        #arr[0] = 10 #Uncomment this and check
        arr = [1,1,1] #Comment this and check
        print('d',m,n,arr)
        return 'a'
    print('b',m,n, arr)
    fun1(m,n+1,arr)
    print('c',m,n, arr)

print(fun(5,5))