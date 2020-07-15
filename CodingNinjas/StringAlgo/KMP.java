package CodingNinjas.StringAlgo;

class KMP{
    public static int[] getArr(char[] pattern){
        int len = pattern.length;
        int[] arr = new int[len];
        int i=1;
        int j=0;
        arr[0] = 0;

        while(i<len){
            if(pattern[i]==pattern[j]){
                arr[i] = j+1;
                i++;
                j++;
            }
            else{
                if(j==0){
                    arr[i] = 0;
                    i++;
                }
                else{
                    j = arr[j-1];
                }
            }
        }

        return arr;
    }

    public static int kmp(char[] word, char[] pattern, int[] arr){
        int ans = 0;
        int i=0;
        int j=0;

        int wordLen = word.length;
        int pattLen = pattern.length;


        while(i<wordLen && j<pattLen){
            if(word[i]==pattern[j]){
                i++;
                j++;
            }
            else{
                if(j==0){
                    i++;
                    ans = i;
                }
                else{
                    j = arr[j-1];
                    ans = ans + j + 1;
                }
            }
        }

        if(j==pattLen) return ans;
        return -1;
    }

    static int findString(String word, String pattern) {
        char[] patternArr = new char[pattern.length()];
        char[] wordArr = new char[word.length()];
        for(int i=0;i<pattern.length();i++){
            patternArr[i] = pattern.charAt(i);
        }
        for(int i=0;i<word.length();i++){
            wordArr[i] = word.charAt(i);
        }
        int[] arr = getArr(patternArr);     
        return kmp(wordArr, patternArr, arr);
    }

    public static void main(String[] args) {
        String word = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        System.out.println(findString(word, pattern));
        
    }
}