package CodingNinjas.StringAlgo;

public class MaxPalindrome {
    
    public static void main(String[] args) {
        String word = "abaaba";
        String word1 = "baab";
        int maxLen = -1;
        int count = 0;

        for(int i=0;i<word.length();i++){
            //odd
            count++;
            int l = i-1;
            int r = i+1;
            int len = 1;
            while(l>=0 && r<word.length() && word.charAt(l)==word.charAt(r)){
                count++;
                len = len+2;
                l--;
                r++;
            }
            if(len>maxLen){
                maxLen = len;
            }

            //even
            if(i!=word.length()-1 && word.charAt(i)==word.charAt(i+1)){
                count++;
                l = i-1;
                r = i+2;
                len = 2;

                while(l>=0 && r<word.length() && word.charAt(l)==word.charAt(r)){
                    count++;
                    len = len+2;
                    l--;
                    r++;
                }
                if(len>maxLen){
                    maxLen = len;
                }
            }
        }

        System.out.println(count);
    }
}