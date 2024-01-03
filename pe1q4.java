public class pe1q4{
    public static void main(String[] args){
        Book b= new Book("hello", "world", 13.0f);
        System.out.println(b.getAuthor());
        b.setAuthor("no");
        System.out.println(b.getAuthor());
    }
}
/* 
1.Instance variables for the title (String), author (String) and price (float) of the book.
2. A three-argument constructor to set each of the instance variable above. If the title or author is null or
the price is less than 0, throw an IllegalArgumentException stating the argument that is not correct.
3. Get and Set methods for each variable.
*/