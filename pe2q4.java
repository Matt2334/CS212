public class pe2q4 {
    static String s1,s2,s3,s4;
    public static void main (String[] args){
        s1 = new String("CAT");
        s2 = new String("DOG");
        s3 = new String("RAT");
        animal(s1,s2); //prints DOG
        System.out.println(mixThem(s2,s3)); // HAT
    } //main

    private static void animal (String a1, String a2) {
        if(a1.equals(a2))
        System.out.println(a1);
        else
        System.out.println(a2);
    }
    private static String mixThem (String b1, String b2){
        String c1 = b1; //c1=DOG
        b1 = b2; //b1=RAT
        b2 = new String ("HAT");
        System.out.println(b1);//RAT
        System.out.println(b2); //HAT
        System.out.println(c1);//DOG
        System.out.println(s2); //DOG
        return b2; //returns HAT
    }
}
