package CodingNinjas.AdvancedRecursion;

public class PrintSubsequence {
    public static void subsequenceUtil(String str,String output){
        if(str.length()==0){
            System.out.println(output);
            return;
        }
        subsequenceUtil(str.substring(1), output);
        subsequenceUtil(str.substring(1), output+str.charAt(0));
    }

    public static void subsequence(String str){
        subsequenceUtil(str,"");        
    }
    
    public static void main(String[] args) {
        subsequence("abc");        
    }

}