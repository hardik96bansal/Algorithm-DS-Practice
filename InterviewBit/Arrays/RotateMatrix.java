package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = a.get(i).get(j);
                ArrayList<Integer> aList = a.get(i);
                aList.set(j, a.get(j).get(i));
                a.set(i, aList);
                
                aList = a.get(j);
                aList.set(i, temp);
                a.set(j, aList);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                ArrayList<Integer> aList = a.get(i);
                int temp = aList.get(j);
                aList.set(j,aList.get(n-j-1));
                aList.set(n-j-1,temp);
                a.set(i, aList);
            }
        }

        
    }
    public static void main(String[] args) {
        
    }
}
