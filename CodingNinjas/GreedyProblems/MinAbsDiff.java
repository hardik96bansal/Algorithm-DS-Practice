package GreedyProblems;

import java.util.Arrays;

public class MinAbsDiff {
    public static int minAbsoluteDifference(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]<ans){
                ans = arr[i+1]-arr[i];
            }
        }
        return ans;
	}
}