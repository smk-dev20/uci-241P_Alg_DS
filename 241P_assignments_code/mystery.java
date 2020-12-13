public class mystery {

    static int mystery1(int n){
        int r=0;
        for(int i=1;i<=(n-1);i++){
            System.out.println("************");
            System.out.println("i= "+i);
            for(int j=i+1;j<=n;j++){
                System.out.println("%%%%");
                System.out.println("j= "+j);
                for(int k=1;k<=j;k++){
                    System.out.println("$$$$$");
                    System.out.println("k= "+k);
                    r+=1;
                }
            }
        }
        return r;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println("Mystery for n= "+n+ " is "+mystery1(n));
    }
}
