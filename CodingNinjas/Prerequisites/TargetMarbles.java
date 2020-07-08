package CodingNinjas.Prerequisites;

import java.util.Scanner;

class TargetMarbles{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i=0,j=0;
        long sum=0;
        long target = scn.nextLong();
        long[] arr = new long[102];

        for(i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }

        for(i=0;i<n;i++){
            sum = 0;
            for(j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum == target){
                    break;
                }
            }
            if(sum == target){
                break;
            }
        }

        if(sum!=target){
            System.out.println("false");
        }
        else{
            String op = "";
            for(int k=i;k<=j;k++){
                op = op + " "+ arr[k];
            }
            op = op.trim();
            System.out.println("true");
            System.out.println(op);
        }
    }
}