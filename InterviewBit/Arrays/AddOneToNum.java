package InterviewBit.Arrays;

import java.util.ArrayList;

public class AddOneToNum {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 0;
        int n = A.size();
        if(A.get(n-1)==9){
            carry = 1;
            A.set(n-1,0);
        }
        for(int i=n-2;i>=0;i--){
            int num = A.get(i);
            if(carry==1){
                if(num==9){
                    carry = 1;
                    A.set(i,0);    
                }
                else{
                    carry = 0;
                    A.set(i,num+1);
                }
            }
        }
        int start = 0;
        for(int i=0;i<n;i++){
            if(A.get(i)!=0){
                start = i;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(carry == 1){
            ans.add(1);
        }
        for(int i=start;i<n;i++){
            ans.add(A.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(0);
        aList.add(9);
        aList.add(9);
        aList.add(9);
        plusOne(aList);


    }
}
