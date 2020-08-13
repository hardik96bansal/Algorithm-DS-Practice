package DpPractice;

public class MagicGrid {

    public static int solverIter(int[][] grid, int m, int n){
        int dp[][] = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                else if(i==m-1){
                    dp[i][j] = dp[i][j+1] - grid[i][j];
                }
                else if(j==n-1){
                    dp[i][j] = dp[i+1][j] - grid[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) - grid[i][j];
                }
                if(dp[i][j]==0) dp[i][j] = -1*grid[i][j]+1;
            }
        }

        return dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{ 0,-2,-3, 1},
                        {-1, 4, 0,-2},
                        { 1,-2,-3, 0}};

        //int ans = solverIter(grid, 3, 4);

        System.out.println(solverIter(grid, 3, 4));
        



    }
}