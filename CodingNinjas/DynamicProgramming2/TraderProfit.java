package DynamicProgramming2;

import java.util.Arrays;
import java.util.Scanner;

class TraderProfit{

    public static int[] solver(int n, int k, char mode, int total, int[] arr, int[][] dpB, int[][] dpS){
        int[] ans = new int[2];

        if(k==0){
            ans[0] = 1;
            ans[1] = 0;
            return ans;
        }

        if(n==0){
            ans[0] = 1;
            ans[1] = 0;
            return ans;
        }

        if(mode == 'B'){
            if(dpB[n][k]!=-1){
                ans[1] = dpB[n][k];
                if(ans[1]>0){
                    ans[0] = 1;
                }
                else{
                    ans[0] = 0;
                }
                return ans;
            }
            int[] opt1 = solver(n-1, k, 'S', total, arr, dpB, dpS);//buy
            int[] opt2 = solver(n-1, k, 'B', total, arr, dpB, dpS);//ignore
            
            if(opt1[0]==1 && opt2[0]==1){
                ans[0] = 1;
                ans[1] = Math.max(opt1[1] -arr[total-n], opt2[1]);
            }
            else if(opt1[0]==1){
                ans[0] = 1;
                ans[1] = opt1[1] -arr[total-n];
            }
            else if(opt2[0]==1){
                ans[0] = 1;
                ans[1] = opt2[1];
            }
            else{
                ans[0] = 0;
                ans[1] = 0;
            }
            dpB[n][k] = ans[1];
        }

        if(mode == 'S'){
            if(dpS[n][k]!=-1){
                ans[1] = dpS[n][k];
                if(ans[1]>0){
                    ans[0] = 1;
                }
                else{
                    ans[0] = 0;
                }
                return ans;
            }
            int[] opt1 = solver(n-1, k-1, 'B', total, arr, dpB, dpS);//sell
            int[] opt2 = solver(n-1, k, 'S', total, arr, dpB, dpS);//ignore

            if(opt1[0]==1 && opt2[0]==1){
                ans[0] = 1;
                ans[1] = Math.max(opt1[1] +arr[total-n], opt2[1]);
            }
            else if(opt1[0]==1){
                ans[0] = 1;
                ans[1] = opt1[1] +arr[total-n];
            }
            else if(opt2[0]==1){
                ans[0] = 1;
                ans[1] = opt2[1];
            }
            else{
                ans[0] = 0;
                ans[1] = 0;
            }

            dpS[n][k] = ans[1];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t>0){
            int k = scn.nextInt();
            int n = scn.nextInt();

            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            int[][] dpB = new int[n+1][k+1];
            int[][] dpS = new int[n+1][k+1];

            for(int[] ar:dpB){
                Arrays.fill(ar, -1);
            }
            for(int[] ar:dpS){
                Arrays.fill(ar, -1);
            }

            int[] ans = solver(n, k, 'B', n, arr, dpB, dpS);

            if(ans[0]==1){
                System.out.println(ans[1]);
            }
            else{
                System.out.println("0");
            }
            
            t--;
        }


        scn.close();        
    }
}