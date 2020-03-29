package Prerequisites;

class MindbendingProd{
    public static void main(String[] args){
        long[] arr = {10,3,5,6,2};
        long[] ans = new long[5];
        ans[0] = 1;
        long lp =1,rp=1;
        for(int i=1;i<ans.length;i++){
            lp = lp*arr[i-1];
            ans[i] = lp;
        }
        for(long a:ans){
            System.out.print(" "+a);
        }
        System.out.println("");
        for(int i=ans.length-2;i>=0;i--){
            rp=rp*arr[i+1];
            ans[i] = ans[i]*rp;
        }
        for(long a:ans){
            System.out.print(" "+a);
        }

        
    }
}