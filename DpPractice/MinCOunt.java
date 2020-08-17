package DpPractice;

import java.util.Arrays;

public class MinCOunt {
    public static int binarySearch(int search, int start, int end, int[] arr){
        if(end==start) return start;
        if(end-start==1){
            if(end<=search) return end;
            if(start<=search) return start;
        }

        int mid = (start+end)/2;
        if(arr[mid] == search){
            return mid;
        }
        else if(search>arr[mid]){
            return binarySearch(search, mid, end, arr);
        }
        else{
            return binarySearch(search, start, mid, arr);
        }
    }


    public static int solver(int n, int len, int arr[], int[][] dp){
        if(n==0) return 0;
        if(n<0 || len==0) return Integer.MAX_VALUE/2;
        if(dp[n][len]!=-1) return dp[n][len];
        int opt1 = 1 + solver(n-arr[len-1], len, arr, dp);
        int opt2 = solver(n, len-1, Arrays.copyOfRange(arr, 0, len-1), dp);
        int ans = Math.min(opt1, opt2);
        dp[n][len] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
        int n = 21;
        int[] squares = new int[35];

        for(int i=1;i<=34;i++){
            squares[i] = i*i;
        }

        int[] arr = {0,1,4,9,14};
        int[][] dp = new int[1005][1005];

        for(int[] ar:dp){
            Arrays.fill(ar, -1);
        }

        int sqr = binarySearch(n, 0, 35, squares);
        //System.out.println(sqr);
        int[] ar = Arrays.copyOfRange(arr, 1, sqr);
        //for(int aa:ar) System.out.println(aa);

        System.out.println(solver(n,sqr-1,Arrays.copyOfRange(squares, 1, sqr),dp));


    }
}