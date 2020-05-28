package GreedyProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        TreeMap<Long, ArrayList<Long>> hMap = new TreeMap<>();
        long max_end = -1;
        for(int i=0;i<n;i++){
            long start = scn.nextLong();
            long end = scn.nextLong();
            if(end>max_end) max_end = end;
            if(hMap.get(end)==null){
                ArrayList<Long> aList = new ArrayList<>();
                aList.add(start);
                hMap.put(end, aList);
            }
            else{
                ArrayList<Long> aList = hMap.get(end);
                aList.add(start);
                //Collections.sort(aList);
                hMap.put(end, aList);            
            }
        }

        int ans = 0;
        long currTime = -1;

        for(Long key:hMap.keySet()){
            ArrayList<Long> aList = hMap.get(key);
            for(long start:aList){
                if(start>=currTime){
                    ans++;
                    currTime = key;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
    
}