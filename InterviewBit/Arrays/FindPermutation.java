package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class FindPermutation {

    public static ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> set = new ArrayList<>();

        for(int i=1;i<=B;i++){
            set.add(i);
        }

        for(int i=0;i<B-1;i++){
            if(A.charAt(i)=='I'){
                ans.add(set.get(0));
                set.remove(0);
            }
            else{
                ans.add(set.get(set.size()-1));
                set.remove(set.size()-1);
            }
        }

        ans.add(set.get(0));
        return ans;        
    }

    public static void main(String[] args) {
        findPerm("IIDDID", 7);
    }
    
}
