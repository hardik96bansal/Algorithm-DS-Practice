package DpPractice;

import java.util.Arrays;
import java.util.Scanner;

public class AlphaCode {
    public static int addModulo(int a, int b){
        int mod = 1000000009;
        return (a%mod + b%mod)%mod;
    }
    public static int solve(String inp, int[] arr){
        if(inp.length()==0){
            return 1;
        }

        if(inp.substring(0,1).equals("0")){
            return 0;
        }
        
        if(inp.length()==1){
            return 1;
        }
        if(arr[inp.length()]!=-1){
            return arr[inp.length()];
        }
        
        int ans1 = solve(inp.substring(1), arr);
        int ans2 = 0;

        if(Integer.parseInt(inp.substring(0,2))<=26){
            ans2 = solve(inp.substring(2), arr);
        }
        int ans = addModulo(ans1, ans2);
        arr[inp.length()] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String inp = scn.next();

        while(!inp.equals("0")){
            int[] dp = new int[inp.length()+1];
            Arrays.fill(dp, -1);
            System.out.println(solve(inp,dp));
            inp = scn.next();
        }

        //System.out.println("abc".substring(0,2));

        scn.close();
    }
    
}