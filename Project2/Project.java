import java.util.StringTokenizer;

public class Project {

    // These allow for the classes that were declared in other files to be used in
    // this file
    public static Date212 date212; // allows for the Daye212 class to be utilized in this file
    public static TextFileInput myFile; // allows for the TextFileInput class to be utilized in this file
    public static DateGUI gui; // allows for the DateGUI class to be utilized in this file
    public static Date212Node node;
    public static Date212List linkedList;
    public static SortedDate212List sortedLinkedList;
    public static UnsortedDate212List unsortedLinkedList;

    // The function linkedListFiller reads a new TextFileInput that contains
    // unsorted dates, reads each line
    // and splits the line by commas using the StringTokenizer. Then, while the line
    // is not empty (null) it will continue iterating
    // to the next line. There is a nested while loop which checks if the
    // StringTokenizer has more tokens, i.e more dates that were split
    // by commas. If it does, it will create a new Date212 object using that token
    // value, check if it is a valid date
    // and add it to the sorted and unsorted LinkedLists by calling the add method
    // and passing in the Date212 object
    public static void linkedListFiller(UnsortedDate212List unsortedLinkedList, SortedDate212List sortedLinkedList) {
        myFile = new TextFileInput("p1input.txt");
        try {
            String in = myFile.readLine();
            StringTokenizer st = new StringTokenizer(in, ",");
            while (in != null) {
                while (st.hasMoreTokens()) {
                    date212 = new Date212(st.nextToken());
                    if (date212.getValid()) {
                        unsortedLinkedList.add(date212);
                        sortedLinkedList.add(date212);
                    }
                }
                // This iterates to the next line and splits the next line by commas using the
                // StringTokenizer
                in = myFile.readLine();
                st = new StringTokenizer(in, ",");
            }
        } catch (NullPointerException f) {
        }
    }

    public static void main(String[] args) {
        // We create two new objects, the unsortedLinkedList of the class
        // UnsortedDate212List and sortedLinkedList
        // of the class SortedDate212List. Then it calls the linkedListFiller function
        // declared above to populate both objects with data
        unsortedLinkedList = new UnsortedDate212List();
        sortedLinkedList = new SortedDate212List();
        linkedListFiller(unsortedLinkedList, sortedLinkedList);

        // Creates two Date212Node type variables unsorted_current and sorted_c. They
        // take in the first node
        // of the LinkedLists, skipping over the dummy node
        Date212Node unsorted_current = unsortedLinkedList.first.next;
        Date212Node sorted_c = sortedLinkedList.first.next;

        // Creates the GUI
        gui = new DateGUI();

        // This while loop will run as long as the unsorted_current node is not empty.
        // We will fill the gui on the left side by calling gui.fillLeft and passing in
        // the unsorted node data properly formatted
        // with the toString method. Then it will set the unsorted_current node to the
        // next node in the linked list.
        // The same thing happens with the right side. It calls gui.fillRight but passes
        // in the sorted_c node formatted data
        // and moves to the next node in the sortedlinkedList
        while (unsorted_current != null) {
            gui.fillLeft(unsorted_current.data.toString());
            unsorted_current = unsorted_current.next;
            gui.fillRight(sorted_c.data.toString());
            sorted_c = sorted_c.next;
        }
    }
}