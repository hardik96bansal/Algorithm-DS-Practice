package DynamicProgramming1;

import java.util.Arrays;

public class Staircase {
    public static long staircaseUtil(int n, long[] arr){
        if(n<0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;

        if(arr[n]!=-1) return arr[n];

        long ans = staircaseUtil(n-1, arr) + staircaseUtil(n-2, arr) + staircaseUtil(n-3, arr);
        arr[n] = ans;
        return ans;
    }
    public static long staircase(int n){
        long[] arr = new long[n+1];
        Arrays.fill(arr, -1);
        return staircaseUtil(n,arr);
    }

    public static void main(String[] args) {
        System.out.println(staircase(4));
        
    }

}