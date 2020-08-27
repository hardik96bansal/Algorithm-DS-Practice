package InterviewBit.Arrays;

import java.util.ArrayList;

public class MinFiniteStepsGrid {
    
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;
        for(int i=0;i<A.size()-1;i++){
            int x1 = A.get(i);
            int x2 = A.get(i+1);
            int y1 = B.get(i);
            int y2 = B.get(i+1);

            int d1 = Math.abs(x1-x2);
            int d2 = Math.abs(y1-y2);

            if(d1<d2){
                ans = ans + d2;
            }
            else{
                ans = ans + d1;
            }
        }

        return ans;
    }
}