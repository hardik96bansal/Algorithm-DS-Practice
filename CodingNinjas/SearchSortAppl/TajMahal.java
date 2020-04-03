package SearchSortAppl;

import java.util.Scanner;

public class TajMahal {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }
        
        long ans = -1;
        long min = Long.MAX_VALUE;

        for(int i=0;i<n;i++){
            long t = (arr[i]-i)/n;
            long temp = (arr[i]-i);
            if(temp<0) temp = 0;
            if(temp%n!=0){
                t++;                
            }
            long val = i+t*n;
            if(val<min){
                min=val;
                ans= i+1;
            }
        }
        System.out.println(""+(ans));
    }

}