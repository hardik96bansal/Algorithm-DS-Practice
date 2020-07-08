package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class MagicGrid {

    public static int callMe(int[][] arr, int si, int sj, int ei, int ej, int[][] reff){
        if(si==ei && sj==ej){
            return 1;
        }
        if(si>ei){
            return Integer.MIN_VALUE;
        }
        if(sj>ej){
            return Integer.MIN_VALUE;
        }
        if(reff[si][sj]!=-1) return reff[si][sj];

        int first = callMe(arr, si, sj+1, ei, ej, reff);
        int second = callMe(arr, si+1, sj, ei, ej, reff);
        int ans = 0;

        if(first==Integer.MIN_VALUE){
            second = second - arr[si][sj];
            if(second<=0) second = 1;
            ans = second;
        }
        else if(second==Integer.MIN_VALUE){
            first = first - arr[si][sj];
            if(first<=0) first = 1;
            ans = first;
        } 
        else{
            first = first - arr[si][sj];
            second = second - arr[si][sj];
            if(first<=0) first = 1;
            if(second<=0) second = 1;
            ans = Math.min(first, second);
        }
        
        reff[si][sj] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t>0){
            int r = scn.nextInt();
            int c = scn.nextInt();
            int[][] arr = new int[r][c];
            int[][] reff = new int[r+1][c+1];

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j] = scn.nextInt();
                }
            }

            for(int[] array : reff){
                Arrays.fill(array, -1);
            }
            
            System.out.println(""+callMe(arr, 0, 0, r-1, c-1, reff));
            t--;
        }
    }

}