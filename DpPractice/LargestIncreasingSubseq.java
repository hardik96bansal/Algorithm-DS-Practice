package DpPractice;

import java.util.Arrays;

public class LargestIncreasingSubseq {
    public static int largestIncSubSeq(int[] arr, int n){
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max = Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,0,1,2,3,10,11,7,8,9};
        System.out.println(largestIncSubSeq(arr, arr.length));

    }
    
}