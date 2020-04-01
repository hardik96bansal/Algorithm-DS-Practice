package SearchSortAppl;

class MergeSort{
    public static void merge(int[] arr, int start, int mid, int end){
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
                if(arr[j]<arr[i]){
                    temp[k] = arr[j];
                    j++;
                }
                else{
                    temp[k] = arr[i];
                    i++;
                }
            }
        }

        for(int k=start;k<end+1;k++){
            arr[k] = temp[k-start];
        }

    }

    public static void mergeSortUtil(int[] arr, int start, int end){
        if(end<=start){
            return;
        }
        int mid = (start+end)/2;
        mergeSortUtil(arr, start, mid);
        mergeSortUtil(arr, mid+1, end);
        merge(arr, start, mid+1, end);
        
    }

    public static void main(String[] args){
        int[] arr = {7,6,5,4,3,2};
        mergeSortUtil(arr, 0, arr.length-1);
        for(int a:arr){
            System.out.print(a+" ");
        }

    }
}