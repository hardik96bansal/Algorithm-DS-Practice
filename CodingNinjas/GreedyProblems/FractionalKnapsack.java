package CodingNinjas.GreedyProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

class Painter{
    double cost;
    double work;
    boolean used;

    public Painter(double cost, Double work) {
        this.cost = cost;
        this.work = work;
        this.used = false;        
    }
}
public class FractionalKnapsack {   
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Comparator cmp = new Comparator<Painter>() {
            @Override
            public int compare(Painter arg1, Painter arg2) {
                double p1 = arg1.work/arg1.cost;
                double p2 = arg2.work/arg2.cost;
                
                if(p1-p2>0){
                    return -1;
                }
                if(p1==p2){
                    if(arg1.work>arg2.work){
                        return -1;
                    }
                    if(arg1.work==arg2.work){
                        return 0;
                    }
                    return 1;
                }
                return 1;
            }
        };

        int n = scn.nextInt();
        double d = scn.nextInt();
        TreeMap<Integer, List<Painter>> hMap = new TreeMap<>();

        for(int i=0;i<n;i++){
            int t = scn.nextInt();
            double cost = scn.nextInt();
            double work = scn.nextInt();

            Painter painter = new Painter(cost,work);
            List<Painter> ins = hMap.get(t);
            if(ins ==null){
                ins = new ArrayList<>();
                ins.add(painter);
                hMap.put(t, ins);
            }
            else{
                ins.add(painter);
                hMap.put(t, ins);
            }
        }

        List<Painter> avPainters = new ArrayList<>();
        int time = 0;
        double cost = 0;
        
        while(d>0){
            List<Painter> newPainters = hMap.get(time);
            if(newPainters!=null){
                avPainters.addAll(newPainters);
                Collections.sort(avPainters, cmp);
                Painter worker = avPainters.get(0);
                d = d-worker.work;
                if(!worker.used){
                    cost = cost + worker.cost;
                    worker.used = true;
                    avPainters.set(0, worker);
                } 
            }
            time++;
        }
        
        System.out.println(cost);

        scn.close();
    }
    
}