package AdvancedRecursion;

import java.util.HashMap;

public class PrintKeypad {
    public static void printKeypadUtil(int input, String output, HashMap<Integer, String> hMap){
        if(input/10==0){
            String abc = hMap.get(input);
            for(int i=0;i<abc.length();i++){
                System.out.println(abc.charAt(i)+output);
            }
            return;
        }
        int currNum = input%10;

        String abc = hMap.get(currNum);
        if(currNum==0 || currNum==1){
            printKeypadUtil(input/10, output, hMap);
        }
        else{
            for(int i=0;i<abc.length();i++){
                printKeypadUtil(input/10, abc.charAt(i) + output, hMap);
            }
        }
        
    }

    public static void printKeypad(int input){
        HashMap<Integer, String> reff = new HashMap<>();
        reff.put(0, "");
        reff.put(1, "");
        reff.put(2, "abc");
        reff.put(3, "def");
        reff.put(4, "ghi");
        reff.put(5, "jkl");
        reff.put(6, "mno");
        reff.put(7, "pqr");
        reff.put(8, "stu");
        reff.put(9, "wxyz");

        printKeypadUtil(input, "", reff);
	}

    public static void main(String[] args) {
        int n = 213;
        printKeypad(n);
    }

}