package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class MaxZeroSquare {

    public static int solver(int[][] arr, int m, int n){
        int[] dp = new int[m];
        int ans = 0;

        for(int i=0;i<n;i++){
            Arrays.fill(dp, 0);
            for(int j=i;j<n;j++){
                for(int k=0;k<m;k++){
                    dp[k] = dp[k] + arr[k][j];
                }

                int curr = 0;
                int max = 0;
                for(int k=0;k<m;k++){
                    if(dp[k]==0){
                        curr++;
                    }
                    if(dp[k]!=0){
                        curr = 0;
                    }

                    if(curr>max && curr<=j-i+1){
                        max = curr;
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

        System.out.println(solver(arr, m, n));


    }
}