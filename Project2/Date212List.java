
public abstract class Date212List{
     
    protected Date212Node first;
    protected Date212Node last;
    protected int len;
    
    // This is a no argument constructor, sets the first and last nodes to null and length to 0
    // upon creating a new Date212List object
    public Date212List(){
        first=new Date212Node(null);
        last=first;
        len=0;
    }

    // his append method takes in a Date212 object, and creates a temp object under the Date212Node class.
    // The temp object is then added to the end of the Linked list, by setting the next object as temp object
    // and the length is incremented by 1. As a result of the constructor of Date212Node, the next object will 
    // be null by default. So when setting last=temp, it will maintain the last.next as null
    public void append(Date212 d){
        Date212Node temp = new Date212Node(d);
        last.next=temp;
        last=temp;
        len++;
    }
}
