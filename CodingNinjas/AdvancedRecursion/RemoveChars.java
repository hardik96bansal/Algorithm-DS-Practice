package AdvancedRecursion;

import java.util.Arrays;

public class RemoveChars {
    public static String callMe(String inp,char rem, char rep){
        if(inp.length()==0){
            return "";
        }
        if(inp.charAt(0)==rem){
            return rep+callMe(inp.substring(1), rem, rep);
        }
        else{
            return inp.charAt(0) +callMe(inp.substring(1),rem, rep);
        }        
    }
    public static void main(String[] args) {
        String str = "cabccdedfcde";
        System.out.println(callMe(str, 'c', 'x'));
    }

}