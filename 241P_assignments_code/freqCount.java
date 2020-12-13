public class freqCount {

    public static int mode(int[] arr){
        int max = 0;
        int count = 1;
        int mode = -1;
        int i=0;
        while(i < arr.length-1){
            int j = i+1;
            if(arr[i]==arr[j]){
                count++;
            }
            else {
                if(count>max){
                    mode = arr[i];
                    max = count;
                }    
               count =1;
            }
            i++;
        }
        return mode;
    }
    public static void main(String[] args) {
        int array[] = {1,1,1,2,2,2,2,2,2,3,3,3,4,4,4,4,5,5,6,6,7,7,7,7,7,7,7,7,7,7,77};
        System.out.println("Mode = "+mode(array));
    }
    
}
