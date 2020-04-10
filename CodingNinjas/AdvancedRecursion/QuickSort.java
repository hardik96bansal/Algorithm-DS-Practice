package AdvancedRecursion;

public class QuickSort {
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int count = 0;
        for(int i=start+1;i<=end;i++){
            if(arr[i]<pivot){
                count++;
            }
        }

        count = count + start;

        int temp = arr[start];
        arr[start] = arr[count];
        arr[count] = temp;

        int i=0;
        int j=end;

        while(i<count && j>count){
            if(arr[i]<arr[count]){
                i++;
            }
            if(arr[j]>=arr[count]){
                j--;
            }
            if(arr[i]>=arr[count] && arr[j]<arr[count]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return count;

    }

    public static void quickSortUtil(int[] arr, int start, int end){
        if(start-end>=0) return;
        if(end-start==1){
            if(arr[end]<arr[start]){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            return;
        }

        else{
            int correct = partition(arr, start, end);
            quickSortUtil(arr, start, correct-1);
            quickSortUtil(arr, correct+1, end);
        }
    }



    public static void quickSort(int[] arr){
        quickSortUtil(arr, 0, arr.length-1);       
    }

    public static void main(String[] args) {
        int[] arr = {5,7,8,2,1,9,4};
        quickSort(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
        
    }

}