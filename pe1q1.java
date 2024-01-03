public class pe1q1{
    public static void main(String[] args){
        if(args.length!=2) throw new IllegalArgumentException("It needs to be exactly 2 inputs");
        else{
            int a= Integer.parseInt(args[0]);
            int b=Integer.parseInt(args[1]);
            System.out.println(a+" + "+b+" = "+(a+b));
            System.out.println(a+" * "+b+" = "+(a*b));
        }
        
    }
}