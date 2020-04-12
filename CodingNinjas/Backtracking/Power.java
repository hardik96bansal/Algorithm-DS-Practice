package Backtracking;

import java.util.Scanner;

public class Power {

    public static long power(int a, int b){
        if(b==1){
            return a;
        }
        return a*power(a, b-1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();

        long ans = power(x, n);
        System.out.println(ans+"");

        
    }

}