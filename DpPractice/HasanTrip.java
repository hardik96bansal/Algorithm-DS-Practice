package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class HasanTrip {
    public static double calcDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }

    public static double solver(int curr, int total, int prevX, int prevY, int[][] cities, double dp[]){
        if(curr==total-1){
            return cities[total-1][2] - calcDistance(prevX, prevY, cities[total-1][0], cities[total-1][1]);
        }
        if(dp[curr]!=-1) return dp[curr];

        double opt1 = solver(curr+1, total, prevX, prevY, cities, dp);
        double opt2 = cities[curr][2] - calcDistance(prevX, prevY, cities[curr][0], cities[curr][1]) +
                        solver(curr+1, total, cities[curr][0], cities[curr][1], cities, dp);
        double ans = Math.max(opt1, opt2);
        dp[curr] = ans;
        return ans;

    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] cities = new int[n][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                cities[i][j] = scn.nextInt();
            }
        }

        double[] dp = new double[n];
        Arrays.fill(dp, -1);

        System.out.println(cities[0][2] + solver(1, n, cities[0][0], cities[0][1], cities, dp));

        scn.close();
    }
}