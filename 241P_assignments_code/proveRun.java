public class proveRun {

    static int[] oddIncrement(int array[]){
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0)
                continue;
            for(int j=0;j<array.length;j++){
                if(array[j]%2==0)
                continue;
                array[j]+=2;
            }    
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {1,3,5,7,11};
        for(int a:array){
            System.out.print(" "+a+" ");
        }    
        System.out.println();
        int result[] = oddIncrement(array);
        for(int a:result){
            System.out.print(" "+a+" ");
        } 
    }
    
}
