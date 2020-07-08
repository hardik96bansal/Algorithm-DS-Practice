package CodingNinjas.DynamicProgramming1;

class BitonicSubseq{
    public static int longestBitonicSubarray(int[] arr){//15 16 14 20 8 21 7
        int ans = 1;
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        dec[0] = 1;

        for(int i=1;i<n;i++){
            inc[i] = 1;
            dec[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    int posssible = inc[j]+1;
                    if(posssible>inc[i]){
                        inc[i] = posssible;
                    }
                }
                if(arr[i]<arr[j]){
                    int posssible = dec[j]+1;
                    if(posssible>dec[i]){
                        dec[i] = posssible;
                    }
                    posssible = inc[j]+1;
                    if(posssible>dec[i]){
                        dec[i] = posssible;
                    }
                }
                
            }
        }

        for(int i=0;i<n;i++){
            if(inc[i]>ans){
                ans = inc[i];
            }
            if(dec[i]>ans){
                ans = dec[i];
            }
        }

        return ans;           
    }

    public static void main(String[] args) {
        int[] arr = {5,20,20,6,4,2};
        int[] arr1 = {15,16,14,20,8,21,7};
        int[] arr2 = {1,2,3};
        System.out.println(longestBitonicSubarray(arr2));
    }
}