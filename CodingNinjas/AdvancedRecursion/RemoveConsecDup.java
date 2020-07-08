package CodingNinjas.AdvancedRecursion;

public class RemoveConsecDup {
    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here
        if(s.length()==1){
            return ""+s.charAt(0);
        }
        if(s.charAt(0)==s.charAt(1)){
            return removeConsecutiveDuplicates(s.substring(1));
        }
        return s.charAt(0)+removeConsecutiveDuplicates(s.substring(1));
	}

    public static void main(String[] args) {
        String str = "aabccba";
        System.out.println(removeConsecutiveDuplicates(str));        
    }

}