public class pe2q3{
    public static void main(String[] args){
        Distance w1 = new Distance(4,9);
        Distance w2 = new Distance (3,6);
        w1.add(w2);
        System.out.println(w1.getFeet()+" "+w1.getInches());
    }
}
