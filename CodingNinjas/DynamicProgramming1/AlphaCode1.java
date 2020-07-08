package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class AlphaCode1{
    public static int addModulo(long a ,long b){
        int mod = 1000000007;
        return (int)((a%mod) + (b%mod))%mod;
    }

    public static int callMe(int[] arr, int[] reff, int size){
        int output = 0;
        if(size ==1){
            if(arr[0]==0) return 0;
            return 1;
        }
        if(size==2){
            if(arr[0]==0){
                return 0;
            }
            if(arr[0]*10+arr[1]<=26){
                if(arr[1]==0) return 1;
                else return 2;
            }
        }

        if(reff[size]!=-1){
            return reff[size];
        }
        
        int n1op = 0, n2op = 0;
        if(arr[size-1]!=0) n1op = callMe(arr, reff, size-1);
        if(arr[size-2]!=0 && arr[size-2]*10+arr[size-1]<=26){
            n2op = callMe(arr, reff, size-2);
        }

        output = addModulo(n1op, n2op);
        reff[size] = output;
        return output;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String inp = scn.nextLine();

        while(!inp.equals("0")){
            int size = inp.length();
            int[] reff = new int[size+1];
            Arrays.fill(reff, -1);
            int[] arr = Arrays.stream(inp.split("")).mapToInt(Integer::parseInt).toArray();
            System.out.println(callMe(arr, reff, size));
            inp = scn.nextLine();
        }
        
    }

}