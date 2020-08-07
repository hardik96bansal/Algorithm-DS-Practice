package CodingNinjas.FenwickTree;

public class Fenwick {

    public static void update(int index, int num, int[] arr, int[] BIT, int n){
        while(index<n){
            BIT[index] += num;
            index += index&-index;
        }
    }

    public static int query(int index, int[] BIT){
        int ans = 0;
        while(index>0){
            ans = ans + BIT[index];
            index -= index & (-index);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {3,2,-1,6,5,4,-3,3,7,2,3};
        int[] BIT = new int[12];

        for(int i=1;i<=11;i++){
            update(i, arr[i-1], arr, BIT, 12);
        }

        for(int a:BIT) System.out.print(a+" ");
        System.out.println(query(5, BIT));
    }
    
}