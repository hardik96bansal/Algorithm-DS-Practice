package CodingNinjas.AdvancedRecursion;

public class Subsequences {
    public static int subsequences(String str, String[] output){
        if(str.length()==0){
            output[0] = "";
            return 1;
        }

        int n = subsequences(str.substring(1), output);
        for(int i=0;i<n;i++){
            output[i+n] = str.charAt(0) + output[i];
        }
        return 2*n;
    }

    public static void main(String[] args) {
        String str = "abc";
        String[] output = new String[100];

        int n = subsequences(str, output);
        for(int i=0;i<n;i++){
            System.out.println(output[i]);
        }
    }

}