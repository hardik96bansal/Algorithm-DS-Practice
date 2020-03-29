package LangToolsTimeComp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

class LongestCommonSubsequence{
    public static int firstOccur(int [] arr, int num){
        int ans = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                return i;
            }
        }
        return ans;
    }
    
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(arr.length == 1){
            ans.add(arr[0]);
            return ans;
        }

        HashMap<Integer, Boolean> hMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hMap.get(arr[i])==null){
                hMap.put(arr[i], true);
            }
        }

        int startNum = arr[0];
        int currLen = 0;
        int maxLen = 0;
        int currStart=-1;
        int maxStart =32767;
        //int keyPos = 0;

        for(int key : hMap.keySet()){
            currLen = 0;
            int checkForNum = key;
            //currStart = keyPos;
            while(hMap.containsKey(checkForNum)){   
                if(hMap.get(checkForNum)){
                    hMap.put(checkForNum, false);
                    checkForNum++;
                    currLen++;
                }
                else{
                    break;
                }
            }
            checkForNum = key-1;
            while(hMap.containsKey(checkForNum)){
                if(hMap.get(checkForNum)){
                    hMap.put(checkForNum, false);
                    checkForNum--;
                    currLen++;
                }
                else{
                    break;
                }
            }
            int firstNum = checkForNum+1;
            currStart = firstOccur(arr,firstNum);

            if(currLen>maxLen || (currLen==maxLen && currStart < maxStart)){
                maxStart = currStart;
                maxLen = currLen;
                startNum = firstNum;
            }
        }
        int temp = startNum;
        //System.out.println(startNum+" "+maxLen);
        for(int i=0;i<maxLen;i++){
            ans.add(temp);
            temp++;
        }
        return ans;

    }
    public static void main(String[] args){
        int[] arr = {3 ,7 ,2 ,1 ,9 ,8 ,1 };
        ArrayList<Integer> aList = longestConsecutiveIncreasingSequence(arr);
        Iterator itr = aList.iterator();
        while(itr.hasNext()){
            System.out.println(""+itr.next());
        }
    }
}