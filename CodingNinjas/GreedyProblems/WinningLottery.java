package GreedyProblems;

import java.util.Scanner;

public class WinningLottery {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int s = scn.nextInt();
        int d = scn.nextInt();
        int[] arr = new int[d];
        arr[d-1] = 1;
        s--;

        for(int i=0;i<d && s>0;i++){
            if(s>=9){
                arr[i] = arr[i] + 9;
                s=s-9;
            }
            else{
                arr[i] = arr[i] + s;
                s=0;
            }
        }

        String ans = "";
        for(int i=0;i<d;i++){
            ans = arr[i] + ans;
        }
        System.out.println(ans);
    }
    
}