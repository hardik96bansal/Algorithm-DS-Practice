def kThElem(arr1,arr2,k,l,r):
    l1 = len(arr1)
    l2 = len(arr2)

    n1 = l1//2
    n2 = l2//2

    med1 = arr[n1+1] if l1%2==1 else (arr[n1-1]+arr[n1])//2
    med2 = arr[n2+1] if l2%2==1 else (arr[n2-1]+arr[n2])//2

arr1 = [2,3,6,7,9,10]
arr2 = [1,4,8]