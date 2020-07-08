package CodingNinjas.AdhocProblems;

import java.util.Scanner;

public class CircularListStudents {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11};

        while(t>0){
            int p = scn.nextInt();
            int i = scn.nextInt();

            //i--;
            if(p+i<=11){
                System.out.println(arr[p+i]);
            }
            else{
                System.err.println(arr[p+i-12]);
            }

            t--;
        }
    }

}