package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class Boredom {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[1005];
        int[] dp = new int[1005];
        Arrays.fill(dp, 0);

        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            arr[x]++;
        }

        dp[0] = 0;
        dp[1] = arr[1];

        for(int i=2;i<=1000;i++){
            dp[i] = Math.max(dp[i-1], i*arr[i]+dp[i-2]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<=1000;i++){
            if(dp[i]>ans) ans = dp[i];
        }

        System.out.println(ans);
    }
}