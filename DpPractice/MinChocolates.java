package DpPractice;

import java.util.Scanner;

public class MinChocolates {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]) dp[i] = dp[i-1] + 1;
            else dp[i] = 1;
        }

        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1] && dp[i]<=dp[i+1]) dp[i] = dp[i+1] +1;
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            ans += dp[i];
        }

        System.out.println(ans);
    }
}