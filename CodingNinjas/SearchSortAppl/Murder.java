package CodingNinjas.SearchSortAppl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Murder{
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while(t>0){
            int n = scn.nextInt();
            long[] arr = new long[n];
            TreeMap<Long, Long> hMap = new TreeMap<>();
            long ans = 0;

            for(int i=0;i<n;i++){
                arr[i] = scn.nextLong();
            }
            for(long a:arr){
                long count = 0;
                ArrayList<Long> present = new ArrayList<>(hMap.keySet());
                for(int i=0;i<present.size();i++){
                    long currNum = present.get(i);
                    if(currNum>=a){
                        break;
                    }
                    count = count + hMap.get(currNum)*currNum;
                }
                ans = ans+count;
                if(hMap.containsKey(a)){
                    hMap.put(a, hMap.get(a)+1);
                }
                else{
                    hMap.put(a, 1L);
                }                
            }
            System.out.println(""+ans);

            t--;
        }
    }
}