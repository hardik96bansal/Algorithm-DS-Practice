package InterviewBit.Arrays;

class LargeFactorial{
    public static String solve(int A) {
        String ans = "";

        int resSize = 1;
        
        int[] arr = new int[2000];
        arr[0] = 1;
        for(int i=2;i<=A;i++){
            int carry = 0;
            for(int j=0;j<resSize;j++){
                int prod = arr[j]*i + carry;
                arr[j] = prod%10;
                carry = prod/10;
            }   
            while(carry>0){
                arr[resSize] = carry%10;
                carry = carry/10;
                resSize++;
            }
        }

        for(int i=resSize-1;i>=0;i--){
            ans = ans + arr[i];
        }        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(100));
    }
}