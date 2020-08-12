package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int solver(int value, int[] denom){
        if(value<0){
            return 0;
        }
        if(value==0){
            return 1;
        }
        int ans = 0;

        for(int i=0;i<denom.length;i++){
            ans += solver(value-denom[i], Arrays.copyOfRange(denom, 1, denom.length));
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] denom = new int[n];

        for(int i=0;i<n;i++){
            denom[i] = scn.nextInt();
        }

        int value = scn.nextInt();
        System.out.println(solver(value,denom));

        scn.close();
    }
}