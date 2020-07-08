package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;

public class LootHouses {

    public static int getMaxMoney(int arr[], int n){
        if(n==1) return arr[0];
        int[] reff = new int[n];
        Arrays.fill(reff, -1);
        reff[0] = arr[0];
        reff[1] = arr[1];
        int ans = 0;

        for(int i=2;i<n;i++){
            for(int j=i-2;j>=0;j--){
                if(reff[j]+arr[i]>reff[i]){
                    reff[i] = reff[j]+arr[i];
                }
            }
        }    
        for(int i=0;i<n;i++){
            if(reff[i]>ans){
                ans = reff[i];
            }
        }    
        return ans;
	}

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(getMaxMoney(arr, 6));
        
    }

}