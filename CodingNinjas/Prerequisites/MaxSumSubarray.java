package CodingNinjas.Prerequisites;

class MaxSumSubarray{
    public static void main(String[] args){
        int startIndex = 0;
        int endIndex = 0;
        boolean flag = true;

        int[] arr1 = {-5,6,7,-20,3,5,8,-9};
        int[] arr = {-3,3,-1,-2};
        int max_so_far = 0;
        int current_sum = 0;
        for(int i=0;i<arr.length;i++){
            int currElem = arr[i];
            if(current_sum+currElem<=0){
                current_sum = 0;
                endIndex = i-1;
                flag = true;
            }
            else{
                if(current_sum == 0){
                    startIndex = i;
                }
                current_sum = current_sum + currElem;
                if(current_sum>max_so_far){
                    max_so_far = current_sum;
                }
                else{
                    flag = false;
                }
                if(flag){
                    endIndex = i-1;
                }
            }
        }

        System.out.println(""+max_so_far+" "+ startIndex + " "+endIndex);
    }
}