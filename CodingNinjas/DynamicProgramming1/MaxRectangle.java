package CodingNinjas.DynamicProgramming1;

import java.util.Scanner;

public class MaxRectangle {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        int[][] reff = new int[n][m];
        int ans = Integer.MIN_VALUE;
 
        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                int maxInK = Integer.MIN_VALUE;
                int maxUntilNow = 0;
                for(int k=0;k<n;k++){
                    if(j==i){
                        reff[k][j] = arr[k][j];
                    }
                    else{
                        reff[k][j] = arr[k][j] + reff[k][j-1];
                    }
                }
                for(int k=0;k<n;k++){
                    maxUntilNow += reff[k][j];
                    if(maxUntilNow>maxInK){
                        maxInK = maxUntilNow;
                    }
                    if(maxUntilNow<0){
                        // if(maxUntilNow>maxNeg){
                        //     maxNeg = maxUntilNow;
                        // }
                        maxUntilNow = 0;
                    }
                }
                if(maxInK>ans){
                    ans = maxInK;
                }
            }
        }

        System.out.println(""+ans);
    }

}