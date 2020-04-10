package AdvancedRecursion;

import java.util.Arrays;
import java.util.HashMap;

public class KeypadCode {
    public static int keypadUtil(int n, String[] output, HashMap<Integer, String> hmap){
        if(n/10==0){
            String temp = hmap.get(n);
            int size = temp.length();
            for(int i=0;i<size;i++){
                output[i] = ""+temp.charAt(i);
            }
            return size;
        }
        int x = keypadUtil(n/10, output, hmap);
        int curr = n%10;

        if(curr == 0|| curr ==1){
            return x;
        }
        String currStr = hmap.get(curr);
        int count = 0;
        for(int j=0;j<currStr.length();j++){
            for(int i=0;i<x;i++){
                output[count] = output[i];
                count++;
            }
        }
        count = 0;
        for(int j=0;j<currStr.length();j++){
            for(int i=0;i<x;i++){
                output[count] = output[count]+currStr.charAt(j);
                count++;
            }
        }

        return count;

    }

    public static String[] keypad(int n){
        // Write your code here
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

        String temp = ""+n;
        String[] output = new String[10000000];
        int c = keypadUtil(n, output, reff);
        output = Arrays.copyOf(output, c);

        return output;

	}

    public static void main(String[] args) {
        keypad(23);
        
    }
}