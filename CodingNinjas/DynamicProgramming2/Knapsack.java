package CodingNinjas.DynamicProgramming2;

import java.util.Arrays;

public class Knapsack {
    public static int callMe(int n, int w, int[] weights, int values[],int[][] reff){
        if(n==0||w<=0){
            return 0;
        }

        if(reff[n][w] != -1){
            return reff[n][w];
        }
        int opt1=0, opt2=0;
        if(w-weights[n-1]>=0){
            opt1 = values[n-1] + callMe(n-1, w-weights[n-1], weights, values, reff);
        }
        opt2 = callMe(n-1, w, weights, values, reff);
        int ans = Math.max(opt1, opt2);

        reff[n][w] = ans;
        return ans;        
    }

    public static int knapsackIter(int[] weight, int[] value, int maxWeight){
        int n = weight.length;
        int[] reff1 = new int[maxWeight+1];
        int[] reff2 = new int[maxWeight+1];
        Arrays.fill(reff1, 0);
        Arrays.fill(reff2, 0);

        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxWeight;j++){
                int opt1=0, opt2=0;
                if(i%2==1){
                    if(j-weight[i-1]>=0){
                        opt1 = value[i-1] + reff1[j-weight[i-1]];
                    }
                    opt2 = reff1[j];
                    reff2[j] = Math.max(opt1, opt2);
                }
                else{
                    if(j-weight[i-1]>=0){
                        opt1 = value[i-1] + reff2[j-weight[i-1]];
                    }
                    opt2 = reff2[j];
                    reff1[j] = Math.max(opt1, opt2);
                }
            }
        }

        if(n%2==1){
            return reff2[maxWeight];
        }
        return reff1[maxWeight];
    }

    public static int knapsack(int[] weight,int value[],int maxWeight){
        int n = weight.length;
        int[][] reff = new int[n+1][maxWeight+1];
        for(int[] arr:reff){
            Arrays.fill(arr, -1);
        }
        return callMe(n, maxWeight, weight, value, reff);                  
    }

    public static void main(String[] args) {
        
    }    
}