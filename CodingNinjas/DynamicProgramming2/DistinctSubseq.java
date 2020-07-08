package CodingNinjas.DynamicProgramming2;

public class DistinctSubseq {

    public static int solver(String str, int start, int end, int dp[][]){
        if(end-start==str.length()){
            return 1;
        }
        if(start>=end){
            return 0;
        }

        int ans = 0;
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("abcd".substring(0,4));
    }
    
}