package Leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static int solver(int start, int remaining, int currSum, int target, int total, int[] nums, List<Integer> ans, List<List<Integer>> ANS, int[][][] dp){
        if(currSum==target && remaining==0 && dp[start][remaining][target] != 1){
            ANS.add(ans);
            return 1;
        }

        if(total-start+1<remaining){
            return 0;
        }

        if(remaining==0){
            return 0;
        }

        if(dp[start][remaining][target] != -1){
            return dp[start][remaining][target];
        }

        List<Integer> o1 = new ArrayList<>(ans);
        List<Integer> o2 = new ArrayList<>(ans);
        o2.add(nums[start]);
        dp[start+1][remaining][currSum] = solver(start+1, remaining, currSum, target, total, nums, o1, ANS, dp);
        dp[start+1][remaining-1][currSum+nums[start]] = solver(start+1, remaining-1, currSum+nums[start], target, total, nums, o2, ANS, dp);

        return 0;
    }



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ANS = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[][][] dp = new int[nums.length+1][nums.length+1][target+1];

        for(int a1=0;a1<=nums.length;a1++){
            for(int a2 = 0;a2<=nums.length;a2++){
                Arrays.fill(dp[a1][a2], -1);
            }
        }

        for(int i=0;i<nums.length;i++)
            solver(i, 4, 0, target, nums.length-1, nums, ans, ANS, dp);
        return ANS;        
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 0,3, 2};
        List<List<Integer>> ANS = fourSum(arr,0);
        System.out.println("a");
    }
    
}