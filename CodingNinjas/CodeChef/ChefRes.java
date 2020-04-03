package CodeChef;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class ChefRes{
    public static long findIndex(ArrayList<Long> aList, int start, int end, long num, TreeMap<Long, Long> hMap){
        if(start>=aList.size()) return -1;
        if(end<=start){
            if(num<aList.get(start)){
                if(num>hMap.get(aList.get(start))){
                    return -1;
                }
                else{
                    return aList.get(start)-num;
                }
            }
        }
        int mid = (start+end)/2;
        if(aList.get(mid)==num){
            return 0;
        }
        if(mid>=aList.size()-1){
            if(aList.get(mid)==num || num<hMap.get(aList.get(mid))) return 0;
            else return -1;
        }
        else if(aList.get(mid)<num){
            if(num<aList.get(mid+1)){
                if(num<hMap.get(aList.get(mid))) 
                    return 0;
            }
            return findIndex(aList, mid+1, end, num, hMap);
        }
        else{
            return findIndex(aList, start, mid-1, num, hMap);
        }

    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while(t>0){
            int n = scn.nextInt();
            int m = scn.nextInt();
            TreeMap<Long,Long> hMap = new TreeMap<>();

            while(n>0){
                long l = scn.nextLong();
                long r = scn.nextLong();

                hMap.put(l, r);
                n--;
            }

            while(m>0){
                long p = scn.nextLong();

                ArrayList<Long> aList = new ArrayList<>(hMap.keySet());
                long index = findIndex(aList, 0, aList.size()-1, p, hMap);
                System.out.println(index);
                m--;
            }

            t--;
        }
    }
}