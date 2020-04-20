package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class AlphaCode {
    public static int addModulo(long a ,long b){
        int mod = 1000000007;
        return (int)((a%mod) + (b%mod))%mod;
    }

    public static int callMe(long n, int[] arr, int size){
        if(n==0) return 0;
        if(n/10==0){
            return 1;
        }
        if(n/100==0){
            if(n<=26){
                if(n%10!=0)
                {
                    return 2;
                }
                else{
                    return 1;
                }
            } 
            if(n%10==0) return 0;
            return 1;
        }
        if(arr[size]!=-1) return arr[size];

        int n1Output = 0;
        if(n%10!=0) n1Output = callMe(n/10,arr, size-1); 
        int n2Output = 0;
        if(n%100<=26 && (n%100)/10!=0) n2Output= callMe(n/100,arr, size-2);
        int output = addModulo(n1Output, n2Output);
        
        arr[size] = output;
        return output;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();

        while(n!=0){
            String temp = ""+n;
            int size = temp.length();
            int[] arr = new int[size+1];
            Arrays.fill(arr, -1);
            System.out.println(callMe(n,arr, size));
            n = scn.nextLong();
        }
        
    }

}