
public class SortedDate212List extends Date212List{
    // This is a no argument default constructor
    public SortedDate212List(){
        super();
    }

    // This add method takes in a Date212 object as a parameter, and places it into a sorted linked list 
    // We check the data of the current node and use the compareTo method to check if the current data is less than the passed in data
    public void add(Date212 d){
        Date212Node temp= new Date212Node(d);  
        
        if(first.next==null){
            first.next=temp;
        }

        // This will set the new Date212Node to the beginning of the linked list, 
        // utilizing the first node which will then point to the next consecutive node. And we set the "current" node equal to the previous node
        Date212Node prev= first;
        Date212Node current = prev.next;
        
        // With this while loop, we compare the date contained in the current node to the date in the parameter using the compareTo method.
        // If the current date is less than the passed in date, then it will iterate to the next node in prev and current.
        while(current.data.compareTo(d)){
            prev = current;
            current = current.next;
        }
        
        // This will set the next node in the linked list to the newly declared node, which contains our Date212 object
        // Then by setting temp.next equal to current, we continue the chain going towards the end node. 
        prev.next=temp;
        temp.next=current;
    }
}