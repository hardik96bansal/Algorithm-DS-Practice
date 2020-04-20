package DynamicProgramming1;

import java.util.Arrays;

public class CoinChange {
    public static int coinsUtil(int den[], int value, int rem, int[][] reff){
        if(value<0) return 0;
        if(value==0)return 1;
        if(rem == 0)return 0;

        if(reff[value][rem]!=-1) return reff[value][rem];
        int[] red = Arrays.copyOfRange(den, 1, den.length);
        int first = coinsUtil(den, value-den[0], rem, reff);
        int second = coinsUtil(red, value, rem-1, reff);
        int output = first + second;
        reff[value][rem] = output;

        return output;
    }

    public static int countWaysToMakeChange(int denominations[], int value){	
        int[][] reff = new int[value+1][denominations.length+1];

        for(int[] inner : reff){
            Arrays.fill(inner, -1);
        }
        return coinsUtil(denominations, value, denominations.length, reff);
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(""+countWaysToMakeChange(arr, 4));
    }

}