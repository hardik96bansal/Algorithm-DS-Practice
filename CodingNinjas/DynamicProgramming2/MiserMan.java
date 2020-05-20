package DynamicProgramming2;

import java.util.Scanner;

public class MiserMan {

    public static int solution(int n, int m, int[][] arr){
        int[][] reff = new int[n][m];
        reff[0] = arr[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    if(m>=2){
                        reff[i][j] = arr[i][j] + Math.min(reff[i-1][0], reff[i-1][1]);
                    }
                    else{
                        reff[i][j] = arr[i][j] + reff[i-1][0];
                    }
                }
                else if(j==m-1){
                    if(m>=2){
                        reff[i][j] = arr[i][j] + Math.min(reff[i-1][m-1], reff[i-1][m-2]);
                    }
                    else{
                        reff[i][j] = arr[i][j] + reff[i-1][m-1];
                    }
                }
                else{
                    int ans = Math.min(reff[i-1][j-1], reff[i-1][j]);
                    ans = Math.min(ans, reff[i-1][j+1]);
                    reff[i][j] = arr[i][j] + ans;
                }            
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(reff[n-1][i]<ans){
                ans = reff[n-1][i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int ans = solution(n, m, arr);
        System.out.println(ans);

        scn.close();
    }
    
}