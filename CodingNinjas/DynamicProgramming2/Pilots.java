package DynamicProgramming2;

import java.util.Arrays;
import java.util.Scanner;

class Pilots{
    public static int[] solve(int n, int k, int open, int mode, int total, int[][] arr, int[][] dpA, int dpP[][]){
        int[] ans = new int[2];
        if(k==0){
            ans[0] = 1;
            ans[1] = 0;  
            return ans;          
        }
        if(n==0){
            ans[0] = 0;
            ans[1] = 0;
            return ans;            
        }
        if(mode == 'A'){
            if(dpA[n][k]!=-1){
                ans[1] = dpA[n][k];
                if(ans[1]==0){
                    ans[0] = 0;
                }
                else ans[0] = 1;
                return ans;
            }
            int aSal = arr[total-n][1];
            int[] nextA = solve(n-1, k, open+1, 'A', total, arr, dpA, dpP);
            int[] nextP = new int[2];
            nextP[0] = nextP[1] = 0;
            if(open>0){
                nextP = solve(n-1, k, open-1, 'P', total, arr, dpA, dpP);
            }
            if(nextA[0]==1 && nextP[0]==1){
                ans[0] = 1;
                ans[1] = aSal + Math.min(nextA[1], nextP[1]);
            }
            else if(nextA[0]==1){
                ans[0] = 1;
                ans[1] = aSal + nextA[1];
            }
            else if(nextP[0]==1){
                ans[0] = 1;
                ans[1] = aSal + nextP[1];
            }
            else{
                ans[0] = 0;
                ans[1] = 0;
            }
            dpA[n][k] = ans[1];
            return ans;
        }
        else{
            if(dpP[n][k]!=-1){
                ans[1] = dpP[n][k];
                if(ans[1]==0){
                    ans[0] = 0;
                }
                else ans[0] = 1;
                return ans;
            }
            int pSal = arr[total-n][0];
            int[] nextA = solve(n-1, k-1, open+1, 'A', total, arr, dpA, dpP);
            int[] nextP = new int[2];
            nextP[0] = nextP[1] = 0;
            if(open>0){
                nextP = solve(n-1, k-1, open-1, 'P', total, arr, dpA, dpP);
            }
            if(nextA[0]==1 && nextP[0]==1){
                ans[0] = 1;
                ans[1] = pSal + Math.min(nextA[1], nextP[1]);
            }
            else if(nextA[0]==1){
                ans[0] = 1;
                ans[1] = pSal + nextA[1];
            }
            else if(nextP[0]==1){
                ans[0] = 1;
                ans[1] = pSal + nextP[1];
            }
            else{
                ans[0] = 0;
                ans[1] = 0;
            }
            dpP[n][k] = ans[1];
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][2];
        int[][] dpA = new int[n+1][n/2+1];
        int[][] dpP = new int[n+1][n/2+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        for(int[] ar:dpA){
            Arrays.fill(ar, -1);
        }
        for(int[] ar:dpP){
            Arrays.fill(ar, -1);
        }


        int[] ans = solve(n, n/2, 1, 'A', n, arr, dpA, dpP);
        System.out.println(ans[1]);


        scn.close();        
    }
}