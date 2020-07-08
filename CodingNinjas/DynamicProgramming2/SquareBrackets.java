package CodingNinjas.DynamicProgramming2;

import java.util.Arrays;
import java.util.Scanner;

public class SquareBrackets {
    
    public static int solve(int n, int currOpen, int total, int[] arr, int[][] dp){
        int ans = 0;
        if(n==0){
            if(currOpen ==0){
                return 1;
            }
            return 0;
        }
        if(dp[n][currOpen]!=-1){
            return dp[n][currOpen];
        }
        int opt1=0, opt2 = 0;
        if(arr[total-n]==1){
            opt1 = solve(n-1, currOpen+1, total, arr, dp);
        }
        else{
            opt1 = solve(n-1, currOpen+1, total, arr, dp);
            if(currOpen>0){
                opt2 = solve(n-1, currOpen-1, total, arr, dp);
            }
        }

        ans = opt1+opt2;
        dp[n][currOpen] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t>0){
            int n = scn.nextInt();
            int[] arr = new int[2*n];
            Arrays.fill(arr,0);
            int k = scn.nextInt();

            for(int i=0;i<k;i++){
                int temp = scn.nextInt();
                arr[temp-1] = 1;
            }

            int[][] dp = new int[2*n+1][2*n+1];
            for(int[] ar:dp){
                Arrays.fill(ar, -1);
            }

            int ans = solve(2*n, 0, 2*n, arr, dp);
            System.out.println(ans);

            t--;
        }

        scn.close();
    }
}