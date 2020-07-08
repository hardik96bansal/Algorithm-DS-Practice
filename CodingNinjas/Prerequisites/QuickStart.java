package CodingNinjas.Prerequisites;

import java.util.Scanner;

class QuickStart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Number");
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        System.out.println("Hello, World."+(num1+num2));
    }
}