package InterviewBit.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SpiralArray {

    public static ArrayList<Integer> printSpriral(List<ArrayList <Integer>> arr,int counter){
        ArrayList<Integer> ans = new ArrayList<>();
        int direction = 0;

        int vStart = 0;
        int vEnd = arr.size()-1;
        
        int hStart = 0;
        int hEnd = 0;

        if(arr.size()>0) hEnd = arr.get(0).size()-1;

        int currV = 0;
        int currH = 0;
        int i=0;

        while(i<counter){
            if(direction%4==0){
                for(int j=hStart;j<=hEnd;j++){
                    ans.add(arr.get(currV).get(j));
                    i++;
                }               
                currH = hEnd;
                vStart++;
            }
            if(direction%4==1){
                for(int j=vStart;j<=vEnd;j++){
                    ans.add(arr.get(j).get(currH));
                    i++;
                }               
                currV = vEnd;
                hEnd--;
            }
            if(direction%4==2){
                for(int j=hEnd;j>=hStart;j--){
                    ans.add(arr.get(currV).get(j));
                    i++;
                }               
                currH = hStart;
                vEnd--;                
            }
            if(direction%4==3){
                for(int j=vEnd;j>=vStart;j--){
                    ans.add(arr.get(j).get(currH));
                    i++;
                }               
                currV = vStart;
                hStart++;
            }
            direction++;
        }

        return ans;
    }
    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = 0;
        if(m>0) n = A.get(0).size();
        
        return printSpriral(A,m*n);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int counter = 1;
        for(int i=0;i<1;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=1;j<=2;j++){
                temp.add(counter);
                counter++;
            }
            arr.add(temp);
        }
        ans = spiralOrder(arr);
        System.out.println("");
    }
}