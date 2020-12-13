/*Sherlin 30 Sep 20*/
public class proveCorrect{
public static int c=5; 

static int multiply(int y, int z){
    if (z==0)
        return 0;
    return (multiply(c*y,(int)Math.floor(z/c))+y*(z%c));    
}
    public static void main(String[] args) {
    
        int y = 10;
        int z = 3;
        System.out.println("Product of y="+y+" and z="+z +" with c as "+c+" = "+multiply(y,z));
    }

}