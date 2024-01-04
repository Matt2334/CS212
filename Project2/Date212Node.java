public class Date212Node{

    protected Date212 data;
    protected Date212Node next;

    // This is a constructor, which takes in a Date212 object, sets the variable data to the object,
    // and sets the next to null. It creates a single node, which will then later get added to the LinkedList
    public Date212Node (Date212 d){
        data=d;
        next=null;
    }
}
