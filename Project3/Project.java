import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Thread;
/**
 * This is the main file which takes in the Date212, TextFileInput, DateGUI, and FileMenuHandler class.  
 * We initialize the GUI as well as the sorted and unsorted ArrayLists. Then, fill their values using the Filler
 * function. The function takes in the array lists and gui, calling gui.getPathing() to get the path of the file
 * we want to read from. After, the dates are extracted from the file and added to the Array Lists
*/
public class Project {

    // These allow for the classes that were declared in other files to be used in
    // this file
    public static Date212 date212; 
    public static TextFileInput myFile; 
    public static DateGUI gui; 
    public static FileMenuHandler fileMenuHandler;

    /** 
     * Fills the unsorted and sorted ArrayList objects with validated dates
     * @param unsorted The arraylist of unsorted dates
     * @param sorted The arraylist of to-be sorted dates
     * @param gui The gui is used to retrieve the selected pathing
    */ 
    public static void ArrayListFiller(ArrayList<Date212> unsorted, ArrayList<Date212> sorted, DateGUI gui) {
        // Reads all the dates from the file that was selected from the GUI/JFileChooser and splits 
        // each line by the delimeter ",". From there, it will run until there are no more tokens 
        // and while the line is not null. While this occurs, it creates a new date212 object, 
        // checks if it's valid, then adds it to the unsorted and sorted ArrayLists.
        // if the token is illegal, it will throw the custom IllegalDate212Exception 
        myFile = new TextFileInput(gui.getPathing());
        try {
            String in = myFile.readLine();
            StringTokenizer st = new StringTokenizer(in, ",");
            while (in != null) {
                while (st.hasMoreTokens()){
                    try{
                        date212 = new Date212(st.nextToken());
                        if (date212.getValid()) {
                            unsorted.add(date212);
                            sorted.add(date212);
                        }
                    }
                    catch (IllegalDate212Exception e){}
                }
                
                // This iterates to the next line and splits the next line by commas using the StringTokenizer
                in = myFile.readLine();
                st = new StringTokenizer(in, ",");
            }
        } catch (NullPointerException f) {
        }
    }

    /** 
     * Instantiates the FileMenuHandler, Gui, unsorted and sorted array lists, and fills the gui with the dates extracted.
    */
    public static void main(String[] args) {   
        // Creates the gui object, sorted and unsorted ArrayList. Then a while loop condition checks if
        // the path provided from the gui is null. If it is, it will wait 5 seconds until the next instance. 
        // After the path is not null, ArrayListFiller function to fill the two ArrayLists. It then calls the
        // Collections sort which will sort the sorted array list utilizing the compareTo 
        // Method declared inside the Date212 class. 
        fileMenuHandler = new FileMenuHandler();
        gui = new DateGUI(fileMenuHandler);
        ArrayList<Date212> unsorted = new ArrayList<Date212>();
        ArrayList<Date212> sorted = new ArrayList<Date212>();
        while(gui.getPathing()==null){
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){}
            System.out.print("In Progress...");
        }
        System.out.print("\n");
        ArrayListFiller(unsorted, sorted, gui);
        Collections.sort(sorted);
        
        // This will loop through all items in the unsorted and sorted ArrayLists
        // passing it into the gui, filling the left and right hand sides of the GUI.
        // The left is the unsorted dates, and the right is the sorted dates.
        for(int i=0;i<unsorted.size();i++) {
            gui.fillLeft(unsorted.get(i).toString());
            gui.fillRight(sorted.get(i).toString());
        }
    }
}