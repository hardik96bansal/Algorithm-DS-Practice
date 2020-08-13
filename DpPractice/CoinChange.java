package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int solver(int value, int[] denom, int denLen, int[][] dp){
        if(value == 0){
            return 1;
        }
        if(value<0){
            return 0;
        }
        if(denLen==0){
            return 0;
        }

        if(dp[value][denLen]!=-1){
            return dp[value][denLen];
        }

        int opt1 = solver(value-denom[0], denom, denLen, dp);
        int opt2 = solver(value, Arrays.copyOfRange(denom, 1, denLen), denLen-1, dp);
        int ans = opt1 + opt2;
        dp[value][denLen] = ans;
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] denom = new int[n];

        for(int i=0;i<n;i++){
            denom[i] = scn.nextInt();
        }

        int value = scn.nextInt();
        int[][] dp = new int[value+1][denom.length+1];
        for(int[] ar:dp) Arrays.fill(ar, -1);
        System.out.println(solver(value,denom, denom.length, dp));

        scn.close();
    }
}