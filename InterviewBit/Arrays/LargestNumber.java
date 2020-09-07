package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    public static int compare(int a, int b){
        String a1 = (""+a) + (""+b);
        String b1 = (""+b) + (""+a);

        int opt1 = Integer.parseInt(a1);
        int opt2 = Integer.parseInt(b1);

        if(opt1>opt2) return -1;
        if(opt2>opt1) return 1;
        // while(a1.length()>1 && b1.length()>1){
        //     if(Integer.parseInt(""+a1.charAt(0)) > Integer.parseInt(""+b1.charAt(0))){
        //         return -1;
        //     }
        //     if(Integer.parseInt(""+a1.charAt(0)) < Integer.parseInt(""+b1.charAt(0))){
        //         return 1;
        //     }
        //     a1 = a1.substring(1);
        //     b1 = b1.substring(1);
        // }

        // if(Integer.parseInt(""+a1.charAt(0)) > Integer.parseInt(""+b1.charAt(0))){
        //     return -1;
        // }
        // if(Integer.parseInt(""+a1.charAt(0)) < Integer.parseInt(""+b1.charAt(0))){
        //     return 1;
        // }

        // if(a1.length()==1 && b1.length()==1){
        //     return 0;
        // }
        // if(a1.length()==1 && b1.length()>1){
        //     if(Integer.parseInt(""+b1.charAt(1)) > Integer.parseInt(""+a1.charAt(0))){
        //         return 1;
        //     }
        //     return -1;
        // }
        // if(a1.length()>1 && b1.length()==1){
        //     if(Integer.parseInt(""+a1.charAt(1)) > Integer.parseInt(""+b1.charAt(0))){
        //         return -1;
        //     }
        //     return 1;
        // }

        return 0;
    }
    
    public static void mergeSort(List<Integer> aList, int start, int end){
        if(start>=end){
            return;
        }
        if(end-start==1){
            if(compare(aList.get(start), aList.get(end))>0){
                int temp = aList.get(start);
                aList.set(start, aList.get(end));
                aList.set(end, temp);
            }
            return;
        }

        int mid = (start+end)/2;
        mergeSort(aList, start, mid);
        mergeSort(aList, mid+1, end);

        int m = start;
        int n = mid+1;
        int[] temp = new int[end-start+1];
        int k = 0;

        for(int i=start;i<=end;i++){
            if(m == mid+1){
                temp[k] = aList.get(n);
                n++;
                k++;
                continue;
            }

            if(n>end){
                if(m==5){
                    System.out.println("");
                }
                temp[k] = aList.get(m);
                m++;
                k++;

                continue;
            }


            if(compare(aList.get(m),aList.get(n)) > 0){
                temp[k] = aList.get(n);
                k++;
                n++;
            }
            else{
                temp[k] = aList.get(m);
                k++;
                m++;
            }
        }

        for(int i=0;i<end-start+1;i++){
            aList.set(start+i, temp[i]);
        }
        
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        int[] arr ={813, 696, 751, 718, 303, 947, 67, 633, 821, 587, 907, 331, 193, 667, 99, 496, 619, 841, 339, 981, 908, 576, 832, 491, 574, 899, 875, 871, 594, 672, 708, 931, 237, 587, 224, 638, 485, 102, 475, 281, 722, 77, 903, 386, 263, 652 };
        for(int a:arr){
            A.add(a);
        }
        //list.add(-1);
        //list.add(-2);

        List<Integer> list = new ArrayList<>(A);
        int zCount = 0;
        for(int a:list){
            if(a==0) zCount++;
        }
        //if(zCount==list.size()) return "0";


        mergeSort(list, 0, 4);
        String ans = "";
        for(int i=0;i<list.size();i++){
            ans = ans + list.get(i);
        }

        System.out.print(ans);
        System.out.println(compare(43, 432));
        
    }
}
