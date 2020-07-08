package CodingNinjas.AdhocProblems;

import java.util.Scanner;

public class WinningSeq {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n+1];
        
        for(int i=1;i<=n;i++){
            arr[i] = scn.nextInt();
        }

        boolean possible = true;
        int ans = 0;
        int i=1;
        while(i<n-1){
            if(Math.abs(arr[i]-i)>2){
                possible = false;
                break;
            }
            if(arr[i]==i){
                i++;
            }
            else if(arr[i] - arr[i+1]==1){
                i=i+2;
                ans++;
            }
            else if(arr[i+1]-arr[i]==1 && arr[i]-arr[i+2]==1){//2 3 1
                i=i+3;
                ans = ans+2;
            }
            else if(arr[i]-arr[i+1]==2 && arr[i+2]-arr[i+1]==1){//3 1 2
                i=i+3;
                ans = ans+2;
            }
            else if(arr[i]-arr[i+1]==1 && arr[i+2]-arr[i+1]==1){//3 2 1
                i = i+3;
                ans = ans+3;
            }
            else{
                possible = false;
                break;
            }
        }

        if(possible) System.out.println("YES\n"+ans);
        else System.out.println("NO");
    }

}