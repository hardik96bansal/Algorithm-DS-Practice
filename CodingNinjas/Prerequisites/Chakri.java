package Prerequisites;

import java.util.Scanner;

class Chakri{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] arr = new long[100005];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }
        long max = 0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[j]-arr[i]>max){
                    max = arr[j]-arr[i];
                }
            }
        }
        System.out.println(""+max);
    }
}