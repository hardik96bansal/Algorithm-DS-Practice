package CodingNinjas.CodeChef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

class CodeChef132{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        long n1 = scn.nextLong();
        long n2 = scn.nextLong();
        long n3 = scn.nextLong();
        long total = n1+n2+n3;

        TreeMap<Long,Long> hmap = new TreeMap<>();
        

        for(long i=0;i<total;i++){
            long inp = scn.nextLong();
            if(hmap.get(inp)!=null){
                hmap.put(inp, hmap.get(inp)+1);
            }
            else{
                hmap.put(inp,1L);
            }

        }

        long ansCount = 0;
        ArrayList<Long> keys = new ArrayList<>();

        for(long key:hmap.keySet()){
            long count = hmap.get(key);
            if(count>=2){
                ansCount++;
                keys.add(key);
            }
        }

        System.out.println(""+ansCount);
        for(long key:keys){
            System.out.println(""+key);
        }
    }
}