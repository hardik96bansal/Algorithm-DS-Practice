package Backtracking;

import java.util.Scanner;

public class KBalls {

    public static boolean sharmaMore(long n, long k){
        long original = n;
        long sharma = 0;
        long singh = 0;

        if(k==38){
            System.out.println("");
        }

        while(n>k){
            sharma = sharma + k;
            n = n-k;
            long singhShare = n/10;
            singh += singhShare;
            n = n-singhShare;
        }

        sharma = sharma + n;
        if(k==38||k==39){ 
            System.out.println(k+" "+sharma+" "+singh);}

        
        if(original%2==0) return original/2<=sharma;
        else return original/2+1<=sharma;
    }

    public static long callMe(long n, long start, long end){
        if(end-start==1){
            if(sharmaMore(n, start)) return start;
            else return end;
        }
        if(end<=start) return start;

        long mid = (start+end)/2;
        if(sharmaMore(n, mid)){
            return callMe(n, start, mid);
        }
        else{
            return callMe(n, mid+1, end);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        System.out.println(""+callMe(n, 1, n));
    }

}