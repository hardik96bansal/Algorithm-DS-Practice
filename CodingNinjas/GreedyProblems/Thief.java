package CodingNinjas.GreedyProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Item{
    int mass, value;

    public Item(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
public class Thief {
    public static int getMinWeight(ArrayList<Integer> aList, int start, int end, int weight){
        if(end-start==0){
            if(aList.get(start)>=weight){
                return aList.get(start);
            }
            return -1;
        }

        if(end-start==1){
            if(aList.get(start)>=weight){
                return aList.get(start);
            }
            if(aList.get(end)>=weight){
                return aList.get(end);
            }
            return -1;
        }

        int mid = (start+end)/2;
        if(aList.get(mid)==weight){
            return aList.get(mid);
        }

        if(aList.get(mid)<weight){
            return getMinWeight(aList, mid+1, end, weight);
        }

        return getMinWeight(aList, start, mid-1, weight);
    }  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Integer> bag= new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int m = scn.nextInt();
            int v = scn.nextInt();

            items.add(new Item(m, v));
        }

        for(int i=0;i<k;i++){
            int c = scn.nextInt();
            bag.add(c);
        }

        Collections.sort(bag);

        Comparator cmp = new Comparator<Item>() {
            @Override
            public int compare(Item arg0, Item arg1) {
                return arg1.value-arg0.value;
            }
        };

        Collections.sort(items, cmp);

        int remaining = bag.size();
        int currItem = 0;
        int ans = 0;

        while(remaining>0 && currItem<items.size()){
            int currItemWt = items.get(currItem).mass;
            int possibleWt = getMinWeight(bag, 0, bag.size()-1, currItemWt);
            if(possibleWt ==-1){
                currItem++;
            }
            else{
                ans = ans + items.get(currItem).value;
                remaining--;
                currItem++;
                bag.remove((Integer)possibleWt);
            }
        }

        System.out.println(ans);
    }
}