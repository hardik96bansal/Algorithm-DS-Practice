package CodingNinjas.DynamicProgramming1;

import javax.management.RuntimeErrorException;

public class MinChocolates {
    public static int callMe(int[] arr, int n, int curr, int chain, int[] reff){
        if(curr==n-1){
            reff[curr] = chain;
            return chain;
        }
        if(arr[curr]<arr[curr+1]){
            reff[curr] = chain;
            int op1 = callMe(arr, n, curr+1, chain+1, reff);
            if(reff[curr]>=op1){
                reff[curr] = op1-1;
            }
            return reff[curr];
        }
        if(arr[curr]>arr[curr+1]){
            reff[curr] = chain;
            int op1 = callMe(arr, n, curr+1, 1, reff);
            if(reff[curr]<=op1){
                reff[curr] = op1+1;
            }
            return reff[curr];
        }
        if(arr[curr]==arr[curr+1]){
            if(curr+1==n-1){
                reff[curr+1] = 1;
                reff[curr] = chain;
                return reff[curr];
            }
            else{
                reff[curr] = chain;
                reff[curr+1] = callMe(arr, n, curr+1, 1, reff);
                return reff[curr];
            }
        }

        return 1;       
    }
    public static int getMin(int arr[], int N){
        int[] reff = new int[N+1];
        
        callMe(arr, N, 0, 1, reff);
        int ans = 0;

        for(int i=0;i<N;i++){
            ans+=reff[i];
        }

        return ans;
    }
    

    public static void main(String[] args) {
        int[] arr = {82440, 36222, 39726, 90098, 21130, 95534, 90800, 97143, 56966, 45758, 27836, 30506, 59211, 72381, 5674, 45858, 85108, 10284, 93404, 66620};
        int[] arr1 = {};
        System.out.println(getMin(arr1, 0));

        
    }

}