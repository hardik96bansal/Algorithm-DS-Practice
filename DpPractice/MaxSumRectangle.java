package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumRectangle {
    public static int solve(int[][] arr, int m, int n){
        int[] dp = new int[m];
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            Arrays.fill(dp, 0);
            for(int j=i;j<n;j++){
                for(int k=0;k<m;k++){
                    dp[k] = dp[k] + arr[k][j];
                }

                int curr = 0;
                int max = Integer.MIN_VALUE;
                for(int k=0;k<m;k++){
                    curr += dp[k];
                    if(curr>max){
                        max = curr;
                    }
                    if(curr<0){
                        curr = 0;
                    }                    
                }
                if(max>ans) ans = max;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][] arr = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println(solve(arr, m, n));



    }
}