package DynamicProgramming1;

import java.util.Scanner;

public class MaxSquareZeroes {
    public static int findMaxSquareWithAllZeros(int[][] input){
        int ans = 0;
        int r = input.length;
        int c = input[0].length;
        int[][] reff = new int[r][c];
        int[] reff1 = new int[c];

        if(c==1){
            for(int i=0;i<r;i++){
                if(input[i][0]==0) return 1;
            }
        }
        if(r==1){
            for(int i=0;i<c;i++){
                if(input[0][i]==0) return 1;
            }
        }
        

        for(int i=0;i<c;i++){
            for(int j=i;j<c;j++){
                int currZeroes = 0;
                reff1[j] = 0;
                for(int k=0;k<r;k++){
                    
                    if(j==i){
                        reff[k][j] = input[k][j];
                    }
                    else{
                        reff[k][j] = input[k][j] + reff[k][j-1];
                    }

                    if(reff[k][j] == 0){
                        currZeroes++;
                    }
                    else{
                        currZeroes = 0;
                    }

                    if(currZeroes==j-i+1 && currZeroes>ans){
                        ans = currZeroes;
                        break;
                    }
                }
                
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
        
        System.out.println(findMaxSquareWithAllZeros(arr));
    }

}