package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;

public class MinCostGrid {

    public static int minCost(int[][] arr,int si,int sj,int ei,int ej, int[][] reff){
        if(si==ei && sj==ej) return arr[ei][ej];
        if(si>ei || sj>ej) return Integer.MAX_VALUE;

        if(reff[si][sj]!=-1) return reff[si][sj];

        int op1 = minCost(arr, si+1, sj, ei, ej, reff);
        int op2 = minCost(arr, si, sj+1, ei, ej, reff);
        int op3 = minCost(arr, si+1, sj+1, ei, ej, reff);

        return arr[si][sj]+Math.min(op1, Math.min(op2, op3));
    }

    public static void main(String[] args) {
        int[][] input = new int [3][3];
        input[0][0] = 4;
        input[0][1] = 3;
        input[0][2] = 2;
        input[1][0] = 1;
        input[1][1] = 8;
        input[1][2] = 3;
        input[2][0] = 1;
        input[2][1] = 1;
        input[2][2] = 8;

        int[][] reff = new int[4][4];
        for(int[] arr:reff){
            Arrays.fill(arr, -1);
        }
        System.out.println(""+minCost(input, 0, 0, 2, 2, reff));
        
    }
}