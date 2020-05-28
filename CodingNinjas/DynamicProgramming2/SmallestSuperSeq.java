package DynamicProgramming2;

import java.util.Arrays;

public class SmallestSuperSeq {
    public static int solver(String a, String b, int al, int bl, int[][] dp){
        if(al==0 && bl==0){
            return 0;
        }
        if(al==0){
            return bl;
        }
        if(bl==0){
            return al;
        }
        if(dp[al][bl]!=-1){
            return dp[al][bl];
        }

        if(a.charAt(0) == b.charAt(0)){
            int ans = 1+solver(a.substring(1), b.substring(1), al-1, bl-1, dp);
            dp[al][bl]=ans;
            return ans;
        }
        int opt1 = solver(a.substring(1), b, al-1, bl, dp);
        int opt2 = solver(a, b.substring(1), al, bl-1, dp);
        int ans = 1+Math.min(opt1, opt2);
        dp[al][bl] = ans;
        return ans;
    }

    public static int smallestSuperSequence(String str1, String str2) {
        int al = str1.length();
        int bl = str2.length();
        int[][] dp = new int[al+1][bl+1];
        for(int[] ar: dp){
            Arrays.fill(ar, -1);
        }
        return solver(str1, str2, al, bl, dp);
	}
    
    public static void main(String[] args) {
        System.out.println(smallestSuperSequence("abcen", "adcne"));
    }
}