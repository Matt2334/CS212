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
        // Creates a new TextFileInput utilizing the path to the selected file
        myFile = new TextFileInput(gui.getPathing());

        int filteredYear = gui.getFilterYear(); // gets the chosen year to filter by
        
        // if the filtered year is equal to 0, then the gui method dateNotProvided will initiate
        // thereby, notifying the user the proper procedure in which to utilize the program
        if(filteredYear==0){
            gui.dateNotProvided();
        }
        else{
            try {
                // Reads all the dates from the file that was selected from the GUI/JFileChooser and splits 
                // each line by the delimeter ",". From there, it will run until there are no more tokens 
                // and while the line is not null. 
                String in = myFile.readLine();
                StringTokenizer st = new StringTokenizer(in, ",");
                while (in != null) {
                    while (st.hasMoreTokens()){
                        try{
                            // Creates a new date212 object, checks if it's valid and if the filter 
                            // year is equal to the year of that date212 object, then adds it to the unsorted 
                            // and sorted ArrayLists.
                            date212 = new Date212(st.nextToken());
                            // if(filteredYear!=0){
                            if (date212.getValid() && filteredYear==date212.getYear()) {
                                    unsorted.add(date212);
                                    sorted.add(date212);
                                // } 
                            }

                        }
                        // If the token is illegal, it will throw the custom IllegalDate212Exception 
                        catch (IllegalDate212Exception e){}
                    }
                    
                    // This iterates to the next line and splits the next line by commas using the StringTokenizer
                    in = myFile.readLine();
                    st = new StringTokenizer(in, ",");
                }
            } catch (NullPointerException f) {}

            // If no elements are entered into unsorted, i.e if the size is 0
            // then the gui will notify the user the year is not found in the file.
            if(unsorted.size()==0){
                gui.dateNotThere();
            }  
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
        fileMenuHandler = new FileMenuHandler();;
        gui = new DateGUI(fileMenuHandler);
        ArrayList<Date212> unsorted = new ArrayList<Date212>();
        ArrayList<Date212> sorted = new ArrayList<Date212>();
        while(gui.getPathing()==null ){
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
        gui.fillLeft("Unsorted\n");
        gui.fillRight("Sorted\n");
        for(int i=0;i<unsorted.size();i++) {
            gui.fillLeft(unsorted.get(i).toString());
            gui.fillRight(sorted.get(i).toString());
        }
    }
}