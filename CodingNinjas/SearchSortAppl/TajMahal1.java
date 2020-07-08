package CodingNinjas.SearchSortAppl;
import java.util.*;

public class TajMahal1 {
	    public static long calculateRound(long start, long end, int pos, int n, long num){
        if(end-start==1){
            if((pos+(start)*n)>=num) return (pos+(start)*n);
            return (pos+(end)*n);
        }
        if(end<=start){
            return (pos+(start)*n);
        }
        long mid = (start+end)/2;
        long curr = pos+(mid)*n;

        if(curr<num){
            return calculateRound(mid+1, end, pos, n, num);
        }
        else{
            return calculateRound(start, mid-1, pos, n, num);
        }      
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }

        long minUntilNow = Long.MAX_VALUE;
        long end = 1000000000;
        long ans = -1;

        for(int i=0;i<n;i++){
            long val = calculateRound(0, end, i, n, arr[i]);
            if(val<minUntilNow){
                minUntilNow = val;
                ans = i+1;
            }
        }
        System.out.println(""+(ans));
    }

}