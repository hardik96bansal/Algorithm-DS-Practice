package CodingNinjas.GreedyProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Job{
    int start,finish,profit;

    public Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}
public class WeightedJobSched {    

    public static int maxProfitUntilStart(List<Job> aList, int start, int end, int startTime){
        if(end-start == 1){
            if(aList.get(end).finish<=startTime){
                return end;
            }
            else if(aList.get(start).finish<=startTime){
                return start;
            }
            return -1;
        }
        if(end-start == 0){
            if(aList.get(start).finish<=startTime){
                return start;
            }
            return -1;
        }

        int mid = (start+end)/2;
        int midFinish = aList.get(mid).finish;

        if(midFinish>startTime){
            return maxProfitUntilStart(aList, start, mid-1, startTime);
        }
        else if(midFinish<startTime){
            return maxProfitUntilStart(aList, mid, end, startTime);
        }
        
        return mid;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Job> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            int start = scn.nextInt();
            int finish = scn.nextInt();
            int profit = scn.nextInt();

            list.add(new Job(start, finish, profit));
        }

        Comparator cmp = new Comparator<Job>() {
            @Override
            public int compare(Job arg0, Job arg1) {
                return arg0.finish-arg1.finish;
            }            
        };

        Collections.sort(list,cmp);

        int[][] dp = new int[n+1][2];

        dp[0][0] = 0;
        dp[0][1] = list.get(0).profit;
        for(int i=1;i<n;i++){
            Job currJob = list.get(i);
            int currStart = currJob.start;
            int currFinish = currJob.finish;
            int currProfit = currJob.profit;

            int profitWith=0, profitWithout=0;
            // for(int j=i-1;j>=0;j--){
            //     if(list.get(j).finish<=currStart){
            //         profitWith = Math.max(dp[j][0], dp[j][1]);
            //         break;
            //     }
            // }
            int j = maxProfitUntilStart(list, 0, i-1, currStart);
            if(j==-1) profitWith = 0;
            else profitWith = Math.max(dp[j][0], dp[j][1]);
            profitWithout = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][0] = profitWithout;
            dp[i][1] = profitWith + currProfit;
        }

        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}