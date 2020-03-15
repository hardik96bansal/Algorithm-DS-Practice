package Prerequisites;

import java.util.Scanner;

class Pages{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[20];

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int s = scn.nextInt();
        for(int i=0;i<s;i++){
            int x = scn.nextInt();
            System.out.println(""+arr[x-1]);
        }
        
    }
}