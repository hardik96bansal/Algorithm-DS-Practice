package CodingNinjas.DynamicProgramming2;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
    public static int callMe(int n, int rem, int[] arr, int [][] reff){
        if(rem == 0){
            return 1;
        }
        if(n==0){
            return 0;
        }

        if(reff[n][rem]!=-1){
            return reff[n][rem];
        }

        int opt1 = 0, opt2 = 0;
        if(rem-arr[n-1]>=0){
            opt1 = callMe(n-1, rem-arr[n-1], arr, reff);
        }
        opt2 = callMe(n-1, rem, arr, reff);

        int ans = opt1+opt2;
        if(ans>1) ans = 1;
        reff[n][rem] = ans;
        return ans;        
    }

    public static int subsetSumIter(int rem, int[] arr){
        int n = arr.length;
        int[] reff1 = new int[rem+1];
        int[] reff2 = new int[rem+1];

        Arrays.fill(reff1, 0);
        Arrays.fill(reff2, 0);

        for(int i=1;i<=n;i++){
            reff1[0] = 1;
            reff2[0] = 1;
            for(int j=1;j<=rem;j++){
                int opt1 = 0, opt2 =0, ans=0;

                if(i%2==1){
                    if(j-arr[i-1]>=0){
                        opt1 = reff1[j-arr[i-1]];
                    }
                    opt2 = reff1[j];
                    ans = opt1 + opt2;
                    if(ans>1) ans = 1;
                    reff2[j] = ans;
                }
                else{
                    if(j-arr[i-1]>=0){
                        opt1 = reff2[j-arr[i-1]];
                    }
                    opt2 = reff2[j];
                    ans = opt1 + opt2;
                    if(ans>1) ans = 1;
                    reff1[j] = ans;
                }

            }
        }

        if(n%2==1){
            return reff2[rem];
        }
        return reff1[rem];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int[][] reff = new int[n+1][k+1];

        for(int[] temp : reff){
            Arrays.fill(temp, -1);
        }

        int ans = subsetSumIter(k, arr);
        if(ans == 1) System.out.println("Yes");
        else System.out.println("No");

        scn.close();
    }
}