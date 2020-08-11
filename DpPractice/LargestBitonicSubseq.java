package DpPractice;

public class LargestBitonicSubseq {
    public static int largestBitonicSubseq(int[] arr, int n){
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        dec[0] = 1;

        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(arr[i]>=arr[j]){
                    if(inc[i]<inc[j]+1){
                        inc[i] = inc[j]+1;
                    }
                }
                if(arr[i]<arr[j]){
                    if(dec[i]<dec[j]+1){
                        dec[i] = dec[j] + 1;
                    }
                    if(dec[i]<inc[j]+1){
                        dec[i] = inc[j] + 1;
                    }
                }
            }
        }
        
        return Integer.max(inc[n-1], dec[n-1]);
    }
    public static void main(String[] args) {
        int[] arr = {2,5,3,0,2,1,7,10,5,4};
        System.out.println(largestBitonicSubseq(arr, arr.length));
    }
    
}