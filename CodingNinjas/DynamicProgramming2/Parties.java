package CodingNinjas.DynamicProgramming2;

import java.util.Arrays;
import java.util.Scanner;

public class Parties {

    public static int party(int n, int rem, int[] cost, int[] fun, int[][] dpCost, int[][] dpFun){
        if(n<=0||rem<=0){
            return 0;
        }

        if(dpFun[n][rem]!=-1){
            return dpFun[n][rem];
        }
        
        int opt1=0, opt2 = 0;
        if(rem-cost[n-1]>=0){
            opt1 = fun[n-1] + party(n-1, rem-cost[n-1], cost, fun, dpCost, dpFun);
        }
        opt2 = party(n-1, rem, cost, fun, dpCost, dpFun);

        int resFun = 0;
        int resCost = 0;
        if(opt1>opt2){
            resFun = opt1;
            resCost = cost[n-1] + dpCost[n-1][rem-cost[n-1]];
        }
        else{
            resFun = opt2;
            resCost = dpCost[n-1][rem];
        }

        dpFun[n][rem] = resFun;
        dpCost[n][rem] = resCost;
        return resFun;        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int budget = scn.nextInt();
        int n = scn.nextInt();

        while(budget!=0 && n!=0){
            int[] cost = new int[n+1];
            int[] fun = new int[n+1];

            for(int i=0;i<n;i++){
                cost[i] = scn.nextInt();
                fun[i] = scn.nextInt();
            }

            int[][] dpFun = new int[n+1][budget+1];
            int[][] dpCost = new int[n+1][budget+1];

            for(int[] arr:dpFun){
                Arrays.fill(arr, -1);
            }
            for(int[] arr:dpCost){
                Arrays.fill(arr, 0);
            }
            int res = party(n, budget, cost, fun, dpCost, dpFun);
            System.out.println(dpCost[n][budget]+ " "+ res);

            budget = scn.nextInt();
            n = scn.nextInt();
        }
        
        scn.close();
    }
}