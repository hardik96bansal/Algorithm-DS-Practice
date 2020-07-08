package CodingNinjas.Prerequisites;

import java.util.Scanner;

class OddEven{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();

        long odd = 0;
        long even = 0;
        for(long i=0;i<n;i++){
            long a = scn.nextLong();
            if(i%2==0 && a%2==0){
                even = even + a;
            }
            if(i%2==1 && a%2==1){
                odd = odd + a;
            }           
        }

        System.out.println(even+" "+odd);

    }
}