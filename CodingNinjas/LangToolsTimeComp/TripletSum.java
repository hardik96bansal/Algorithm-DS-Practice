package CodingNinjas.LangToolsTimeComp;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

class TripleSum{
    public static int numberOfCominations3(int c){
        int ans = 1;
        for(int i=0;i<3;i++){
            ans = ans*c;
            c--;

        }
        return ans/6;
    }

    public static int numberOfCominations2(int c){
        int ans = 1;
        for(int i=0;i<2;i++){
            ans = ans*c;
            c--;

        }
        return ans/2;
    }

    public static void FindTriplet(int[] arr, int x){
        TreeMap<Integer, Integer> hMap = new TreeMap<>();

        for(int i=0;i<arr.length;i++){
            if(hMap.get(arr[i])==null){
                hMap.put(arr[i], 1);
            }
            else{
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }
        }

        ArrayList<Integer> uniNums = new ArrayList<>(hMap.keySet());

        for(int i=0;i<uniNums.size();i++){
            int n1 = uniNums.get(i);
            int c1 = hMap.get(n1);
            if(n1*3==x && c1>=3){
                int noc = numberOfCominations3(c1);
                for(int k=0;k<noc;k++){
                    System.out.println(n1+" "+n1+" "+n1);
                }
            }

            for(int j=i+1;j<uniNums.size();j++){
                int n2 = uniNums.get(j);
                int c2 = hMap.get(n2);

                if(n1+2*n2==x && c2>=2){
                    int noc2 = numberOfCominations2(c2);
                    for(int k=0;k<c1*noc2;k++){
                        System.out.println(n1+" "+n2+" "+n2);
                    }
                }
                else if(2*n1+n2==x && c1>=2){
                    int noc1 = numberOfCominations2(c1);
                    for(int k=0;k<noc1*c2;k++){
                        System.out.println(n1+" "+n1+" "+n2);
                    }
                }
                else{
                    int n3 = x-n1-n2;
                    if(hMap.get(n3)!=null && n3>n1 && n3>n2){
                        int c3 = hMap.get(n3);
                        for(int k=0;k<c1*c2*c3;k++){
                            System.out.println(n1+" "+n2+" "+n3);
                        }                       
                        
                    }

                }
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {3,3,4,4,5};
        FindTriplet(arr, 12);

    }
}