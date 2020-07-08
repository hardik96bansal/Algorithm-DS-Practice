package CodingNinjas.Prerequisites;

import java.util.Scanner;

class TakTakTree {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int inp = scn.nextInt();
        int i = 0;

        while(inp%11!=1){
            inp = inp*2;
            i++;
        }

        System.out.println(i+" "+inp);
    }
}