package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;

class BSTCount{
    public static int addModulo(int a, int b){
        long bignum = 1000000000+7;
        long temp = a%bignum + b%bignum;
        temp = temp%bignum;
        return (int)temp;
    }
    
    public static int subModulo(int a, int b){
        long bignum = 1000000000+7;
        long temp = a%bignum - b%bignum;
        temp = temp%bignum;
        return (int)temp;
    }
    
    public static int prodModulo(int a, int b){
        long bignum = 1000000000+7;
        long temp = a%bignum * b%bignum;
        temp = temp%bignum;
        return (int)temp;
    }

    public static int countTreesUtil(int start, int count, int[][] arr){
        if(count <=1){
            return 1;
        }
        if(count==2){
            return 2;
        }
        int res = 0;
        if(arr[start][count]!=-1) return arr[start][count];
        for(int i=1;i<=count;i++){
            int currRoot = subModulo(addModulo(start, i),1);
            if(currRoot-start==1 && count-i==1) res= addModulo(res, 1);
            else{
                int ans1 = countTreesUtil(start, currRoot-start, arr);
                int ans2 = countTreesUtil(start+i, count-i, arr);
                int ans = prodModulo(ans1,ans2);
                res = addModulo(res, ans);
            }
        }

        arr[start][count] = res;
        return res;
    }
    public static int countTrees(int numKeys) {
        if(numKeys==1) return 1;
        int[][] arr = new int[numKeys+1][numKeys+1];
        for(int[] temp: arr){
            Arrays.fill(temp, -1);
        }
        return countTreesUtil(1, numKeys, arr);
    }
    
}