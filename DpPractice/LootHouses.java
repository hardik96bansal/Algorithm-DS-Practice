package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class LootHouses {

    public static int solver(int n, int total, int[] arr, int[] dp){
        if(n>=total){
            return 0;
        }

        if(dp[n]!=-1) return dp[n];

        int opt1 = arr[n] + solver(n+2, total, arr,dp);
        int opt2 = solver(n+1, total, arr,dp);

        int ans = Math.max(opt1, opt2);
        dp[n] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        Arrays.fill(dp, -1);

        System.out.println(solver(0, n, arr,dp));

    }
}