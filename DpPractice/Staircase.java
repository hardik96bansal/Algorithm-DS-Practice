package DpPractice;

import java.util.Arrays;

public class Staircase {
    public static int solver(int stairs, int[] dp){
        if(stairs<0){
            return 0;
        }
        if(stairs==0){
            return 1;
        }

        if(dp[stairs] != -1){
            return dp[stairs];
        }

        int ans1 = solver(stairs-1,dp);
        int ans2 = solver(stairs-2,dp);
        int ans3 = solver(stairs-3,dp);
        int ans = ans1+ans2+ans3;
        dp[stairs] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
        int stairs = 35;
        int[] dp = new int[stairs+1];
        Arrays.fill(dp, -1);
        System.out.println(solver(stairs,dp));
    }
}