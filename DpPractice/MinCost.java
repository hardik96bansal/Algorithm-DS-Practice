package DpPractice;

import java.util.Arrays;

public class MinCost {

    public static int solver(int[][] grid, int m, int n, int a, int b, int[][] dp){
        if(m==a-1 && n==b-1){
            return grid[m][n];
        }
        if(m==a-1){
            return grid[m][n] + solver(grid, m, n+1, a, b, dp);
        }
        if(n==b-1){
            return grid[m][n] + solver(grid, m+1, n, a, b, dp);
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        int opt1 = solver(grid, m+1, n+1, a, b, dp);
        int opt2 = solver(grid, m+1, n, a, b, dp);
        int opt3 = solver(grid, m, n+1, a, b, dp);

        int ans = grid[m][n] + Math.min(opt1, Math.min(opt2, opt3));
        dp[m][n] = ans;
        return ans;        
    }
    
    public static int solverIter(int[][] grid,int m, int n){
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                else if(i==m-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }
                else if(j==n-1){
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }
                else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,2},
                        {1,8,9},
                        {1,1,8}};

        int[][] dp = new int[3][3];
        for(int[] ar:dp) Arrays.fill(ar, -1);

        //System.out.println(solverIter(grid, 3, 3));
        System.out.println(solver(grid, 0, 0, 3, 3, dp));

    }
}