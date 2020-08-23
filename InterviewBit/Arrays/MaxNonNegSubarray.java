package InterviewBit.Arrays;

import java.util.ArrayList;

public class MaxNonNegSubarray {
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();

        int start = 0;
        int maxL = Integer.MIN_VALUE;
        long maxSum = Long.MIN_VALUE;

        int currStart = 0;
        int currL = 0;
        long currSum = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)>=0){
                currSum += A.get(i);
                currL++;
            }
            if(currSum>maxSum){
                start = currStart;
                maxL = currL;
                maxSum = currSum;                
            }
            if(currSum==maxSum){
                if(currL>maxL){
                    start = currStart;
                    maxL = currL;
                    maxSum = currSum;
                }
            }
            if(A.get(i)<0){
                currStart = i+1;
                currSum = 0;
                currL = 0;
            }   
        }

        ans = new ArrayList<>(A.subList(start, start+maxL));
        return ans;
    }
    
    public static void main(String[] args) {
        //[10, -1, 2, 3, -4, 100]
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(3);

        maxset(A);
    }
}