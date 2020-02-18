def fun(arr,num,num1):
    if(num<len(arr)):
        if(num1<len(arr[num])):
            print(arr[num][num1])
            fun(arr,num,num1+1)
        else:
            fun(arr,num+1,0)

arr =  [[1,2],
        [4,5]]
fun(arr,0,0)