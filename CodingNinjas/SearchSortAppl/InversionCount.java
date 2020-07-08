package CodingNinjas.SearchSortAppl;

class InversionCount{
    public static long merge(int[] arr, int start, int mid, int end){
        long currAns = 0;
        int[] temp = new int[end-start+1];
        int i=start;
        int j=mid;

        for(int k=0;k<end-start+1;k++){
            if(i==mid){
                temp[k] = arr[j];
                j++;                
            }
            else if(j==end+1){
                temp[k] = arr[i];
                i++;
            }
            else{
                if(arr[i]<=arr[j]){
                    temp[k] = arr[i];
                    i++;
                }
                else{
                    temp[k] = arr[j];
                    j++;
                    currAns = currAns + (mid-i);
                }
            }
        }

        for(int k=start;k<=end;k++){
            arr[k] = temp[k-start];
        }
        
        return currAns;
    }

    public static long divide(int[] arr, int start, int end){
        long ans = 0;
        if(end<=start){
            return 0;
        }
        int mid = (end+start)/2;
        ans = ans+divide(arr, start, mid);
        ans = ans+divide(arr, mid+1, end);
        ans = ans+merge(arr,start,mid+1,end);

        return ans;
    }

    static long solve(int[] A,int n){
        long ans = divide(A, 0, n-1);        
        return ans;		
	}

    public static void main(String[] args){
        int[] arr = {7,6,5,4,3,2};
        System.out.println(solve(arr, 6));
    }
}