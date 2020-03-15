package Prerequisites;

import java.util.Scanner;

class Pre4{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] arr = new long[100000];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }
        for(int i=0;i<n/2;i++){
            long a = arr[i]+arr[n-1-i];
            System.out.println(a/10+" "+a%10);
        }
    }
}