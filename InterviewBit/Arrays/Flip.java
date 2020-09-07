package InterviewBit.Arrays;

import java.util.ArrayList;

public class Flip {
    
    public static ArrayList<Integer> flip(String A) {
        /*
        1001111000  10011000110001
        0210000321  02100321003210
        1001234000  10012000120001
        */
        ArrayList<Integer> ans = new ArrayList<>();
        boolean reset = true;
        int n = A.length();
        int currSum = 0;
        int overSum = 0;
        int ansI = -1;
        int ansJ = -1;
        int currI = -1;
        int currJ = -1;
        int[] arr = new int[n];
        // for(int i=0;i<n;i++){
        //     if(A.charAt(i)=='0'){
        //         currMax++;
        //     }
        //     if(currMax==1){
        //         currI = i;
        //         currJ = i;            
        //     }
        //     if(currMax>1){
        //         currJ = i;
                
        //     }
            
        //     if(currMax>overMax){
        //         overMax = currMax;
        //         if(reset){ ansI = currI; reset = false;}
        //         ansJ = currJ;
        //     }
            
        //     if(A.charAt(i)=='1'){
        //         currMax--;
        //     }
        //     if(currMax<0){
        //         currMax = 0;
        //         currI = -1;
        //         currJ = -1;
        //         reset = true;
        //     }
        // }

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(""+A.charAt(i));
            if(arr[i]==1) arr[i] = -1;
        }

        for(int i=0;i<n;i++){
            currSum += arr[i];
            if(currSum==1){

            }

            if(currSum>overSum){

            }

        }
        
        if(overSum>0){
            ans.add(ansI+1);
            ans.add(ansJ+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        flip("01010111010100010010");
    }
}