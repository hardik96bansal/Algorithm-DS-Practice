package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacentBitCount {
    public static int addModulo(int a, int b){
        int bigNum = 1000000007;
        return ((a%bigNum) + (b%bigNum))%bigNum;
    }

    public static int callMe(int n, int k, int first, int[][] reff0, int[][] reff1){
        if(k<0) return 0;
        if(n==1){
            if(k==0){
                return 1;
            }
            return 0;
        }

        if(first == 1){
            if(reff1[n][k]!=-1){
                return reff1[n][k];
            }
            int ans1 = callMe(n-1, k-1, 1, reff0, reff1);
            int ans2 = callMe(n-1, k, 0, reff0, reff1);
            int ans = addModulo(ans1,ans2);
            reff1[n][k] = ans;
            return ans;
        }
        else{
            if(reff0[n][k]!=-1){
                return reff0[n][k];
            }
            int ans1 = callMe(n-1, k, 0, reff0, reff1);
            int ans2 = callMe(n-1, k, 1, reff0, reff1);
            int ans = addModulo(ans1, ans2);
            reff0[n][k] = ans;
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t>0){
            int num = scn.nextInt();
            int n = scn.nextInt();
            int k = scn.nextInt();
        
            int[][] reff0 = new int[n+1][k+1];
            int[][] reff1 = new int[n+1][k+1];

            for(int[] arr:reff0){
                Arrays.fill(arr, -1);
            }
            for(int[] arr:reff1){
                Arrays.fill(arr, -1);
            }

            int part1 = callMe(n, k, 0, reff0, reff1);
            int part2 = callMe(n, k, 1, reff0, reff1);
            int ans = addModulo(part1, part2);

            System.out.println(num+" "+ans);
            t--;
        }
        
    }

}